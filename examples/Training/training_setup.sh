#! /bin/bash
# Script to create the training material using the CLI

set -e
set -u
set -x

HOSTNAME=${HOSTNAME:-localhost}
PORT=${PORT:-4064}
WEBHOST=${WEBHOST:-http://localhost}
SERVER_NAME=${SERVER_NAME:-omero}
ROOT_PASSWORD=${ROOT_PASSWORD:-omero}
GROUP_NAME=${GROUP_NAME:-training_group}
GROUP_NAME_2=${GROUP_NAME_2:-training_group-2}
USER_NAME=${USER_NAME:-training_user}
USER_NAME_2=${USER_NAME_2:-training_user-2}
LIGHTADMIN_USER_NAME=${LIGHTADMIN_USER_NAME:-ladmin_user}
USER_PASSWORD=${USER_PASSWORD:-ome}
CONFIG_FILENAME=${CONFIG_FILENAME:-training_ice.config}

# Create training user and group
omero login root@$HOSTNAME:$PORT -w $ROOT_PASSWORD
omero group add $GROUP_NAME --type read-only --ignore-existing
omero group add $GROUP_NAME_2 --type read-only --ignore-existing
omero user add $USER_NAME $USER_NAME $USER_NAME $GROUP_NAME $GROUP_NAME_2 --ignore-existing -P $USER_PASSWORD
omero user add $USER_NAME_2 $USER_NAME_2 $USER_NAME_2 $GROUP_NAME $GROUP_NAME_2 --ignore-existing -P $USER_PASSWORD
omero user add $LIGHTADMIN_USER_NAME $LIGHTADMIN_USER_NAME $LIGHTADMIN_USER_NAME $GROUP_NAME $GROUP_NAME_2 -a --ignore-existing -P $USER_PASSWORD
id=$(omero user info $LIGHTADMIN_USER_NAME  --style plain |  cut -d, -f1)
omero obj map-set Experimenter:$id config AdminPrivilege:Sudo true
omero logout

# Create fake files
touch test.fake

# Create training user and group
omero login $USER_NAME@$HOSTNAME:$PORT -w $USER_PASSWORD -g $GROUP_NAME
nProjects=1
nDatasets=2
echo "Creating projects and datasets"
for (( i=1; i<=$nProjects; i++ ))
do
  project=$(omero obj new Project name='Project '$i)
  for (( j=1; j<=$nDatasets; j++ ))
  do
    dataset=$(omero obj new Dataset name='Dataset '$i-$j)
    omero obj new ProjectDatasetLink parent=$project child=$dataset
    echo "Importing image into dataset"
    omero import -d $dataset test.fake --debug ERROR
  done
done

# Create orphaned datasets
for (( j=1; j<=$nDatasets; j++ ))
do
  omero obj new Dataset name='Orphaned dataset '$j
done

# Import Image
echo "Importing image file"
touch "test&sizeT=10&sizeZ=5&sizeC=3.fake"
omero import "test&sizeT=10&sizeZ=5&sizeC=3.fake" > image_import.log 2>&1
imageid=$(sed -n -e 's/^Image://p' image_import.log)

# Add a Map annotation
MAP=$(omero obj new MapAnnotation)
omero obj map-set $MAP mapValue testkey testvalue
omero obj new ImageAnnotationLink parent=Image:$imageid child=$MAP

# Create screen/plate
screen=$(omero obj new Screen name='Screen')
plate=$(omero obj new Plate name='Plate')
omero obj new ScreenPlateLink parent=$screen child=$plate

# Import orphaned plate
echo "Importing SPW file"
touch "SPW&plates=1&plateRows=1&plateCols=3&fields=1&plateAcqs=1.fake"
omero import -r $screen "SPW&plates=1&plateRows=1&plateCols=3&fields=1&plateAcqs=1.fake" > plate_import.log 2>&1
plateid=$(sed -n -e 's/^Plate://p' plate_import.log)

# Logout
omero logout

# Create data owned by another user in the same group
omero login $USER_NAME_2@$HOSTNAME:$PORT -w $USER_PASSWORD -g $GROUP_NAME
omero obj new Project name='Project 0'
omero obj new Dataset name='Dataset 0'
omero import test.fake --debug ERROR
omero obj new Screen name='Screen'
omero obj new Plate name='Plate'

# Create data owned by the same user in the second group
omero login $USER_NAME@$HOSTNAME:$PORT -w $USER_PASSWORD -g $GROUP_NAME_2
omero obj new Project name='Project 0'
omero obj new Dataset name='Dataset 0'
omero import test.fake --debug ERROR
omero obj new Screen name='Screen'
omero obj new Plate name='Plate'

# Logout
omero logout

# Create ice.config file
echo "omero.host=$HOSTNAME" > "$CONFIG_FILENAME"
echo "omero.port=$PORT" >> "$CONFIG_FILENAME"
echo "omero.webhost=$WEBHOST" >> "$CONFIG_FILENAME"
echo "omero.servername=$SERVER_NAME" >> "$CONFIG_FILENAME"
echo "omero.user=$USER_NAME" >> "$CONFIG_FILENAME"
echo "omero.pass=$USER_PASSWORD" >> "$CONFIG_FILENAME"
echo "omero.group=$GROUP_NAME" >> "$CONFIG_FILENAME"
echo "omero.projectid=${project##*:}" >> "$CONFIG_FILENAME"
echo "omero.datasetid=${dataset##*:}" >> "$CONFIG_FILENAME"
echo "omero.imageid=${imageid}" >> "$CONFIG_FILENAME"
echo "omero.plateid=${plateid}" >> "$CONFIG_FILENAME"
echo "omero.screenid=${screen##*:}" >> "$CONFIG_FILENAME"
echo "omero.group2=$GROUP_NAME_2" >> "$CONFIG_FILENAME"
echo "omero.ladmin=$LIGHTADMIN_USER_NAME" >> "$CONFIG_FILENAME"

# Remove fake file
rm *.fake
