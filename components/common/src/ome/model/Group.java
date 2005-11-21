package ome.model;

import java.util.*;




/**
 * Group generated by hbm2java
 */
public class
Group 
implements java.io.Serializable ,
ome.api.OMEModel,
ome.util.Filterable {

    // Fields    

     private Integer attributeId;
     private String name;
     private Set datasets;
     private Set images;
     private Set projects;
     private Set experimenters;
     private Set moduleExecutions;
     private Set imageInfos;
     private Experimenter leader;
     private Experimenter contact;
     private ModuleExecution moduleExecution;


    // Constructors

    /** default constructor */
    public Group() {
    }
    
    /** constructor with id */
    public Group(Integer attributeId) {
        this.attributeId = attributeId;
    }
   
    
    

    // Property accessors

    /**
     * 
     */
    public Integer getAttributeId() {
        return this.attributeId;
    }
    
    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    /**
     * 
     */
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public Set getDatasets() {
        return this.datasets;
    }
    
    public void setDatasets(Set datasets) {
        this.datasets = datasets;
    }

    /**
     * 
     */
    public Set getImages() {
        return this.images;
    }
    
    public void setImages(Set images) {
        this.images = images;
    }

    /**
     * 
     */
    public Set getProjects() {
        return this.projects;
    }
    
    public void setProjects(Set projects) {
        this.projects = projects;
    }

    /**
     * 
     */
    public Set getExperimenters() {
        return this.experimenters;
    }
    
    public void setExperimenters(Set experimenters) {
        this.experimenters = experimenters;
    }

    /**
     * 
     */
    public Set getModuleExecutions() {
        return this.moduleExecutions;
    }
    
    public void setModuleExecutions(Set moduleExecutions) {
        this.moduleExecutions = moduleExecutions;
    }

    /**
     * 
     */
    public Set getImageInfos() {
        return this.imageInfos;
    }
    
    public void setImageInfos(Set imageInfos) {
        this.imageInfos = imageInfos;
    }

    /**
     * 
     */
    public Experimenter getLeader() {
        return this.leader;
    }
    
    public void setLeader(Experimenter leader) {
        this.leader = leader;
    }

    /**
     * 
     */
    public Experimenter getContact() {
        return this.contact;
    }
    
    public void setContact(Experimenter contact) {
        this.contact = contact;
    }

    /**
     * 
     */
    public ModuleExecution getModuleExecution() {
        return this.moduleExecution;
    }
    
    public void setModuleExecution(ModuleExecution moduleExecution) {
        this.moduleExecution = moduleExecution;
    }






  public boolean acceptFilter(ome.util.Filter filter){


	  // Visiting: AttributeId ------------------------------------------
	  Integer _AttributeId = null;
	  try {
	     _AttributeId = getAttributeId();
	  } catch (Exception e) {
		 setAttributeId(null);
	  }

	  setAttributeId((Integer) filter.filter(ATTRIBUTEID,_AttributeId)); 

	  // Visiting: Name ------------------------------------------
	  String _Name = null;
	  try {
	     _Name = getName();
	  } catch (Exception e) {
		 setName(null);
	  }

	  setName((String) filter.filter(NAME,_Name)); 

	  // Visiting: Datasets ------------------------------------------
	  Set _Datasets = null;
	  try {
	     _Datasets = getDatasets();
	  } catch (Exception e) {
		 setDatasets(null);
	  }

	  setDatasets((Set) filter.filter(DATASETS,_Datasets)); 

	  // Visiting: Images ------------------------------------------
	  Set _Images = null;
	  try {
	     _Images = getImages();
	  } catch (Exception e) {
		 setImages(null);
	  }

	  setImages((Set) filter.filter(IMAGES,_Images)); 

	  // Visiting: Projects ------------------------------------------
	  Set _Projects = null;
	  try {
	     _Projects = getProjects();
	  } catch (Exception e) {
		 setProjects(null);
	  }

	  setProjects((Set) filter.filter(PROJECTS,_Projects)); 

	  // Visiting: Experimenters ------------------------------------------
	  Set _Experimenters = null;
	  try {
	     _Experimenters = getExperimenters();
	  } catch (Exception e) {
		 setExperimenters(null);
	  }

	  setExperimenters((Set) filter.filter(EXPERIMENTERS,_Experimenters)); 

	  // Visiting: ModuleExecutions ------------------------------------------
	  Set _ModuleExecutions = null;
	  try {
	     _ModuleExecutions = getModuleExecutions();
	  } catch (Exception e) {
		 setModuleExecutions(null);
	  }

	  setModuleExecutions((Set) filter.filter(MODULEEXECUTIONS,_ModuleExecutions)); 

	  // Visiting: ImageInfos ------------------------------------------
	  Set _ImageInfos = null;
	  try {
	     _ImageInfos = getImageInfos();
	  } catch (Exception e) {
		 setImageInfos(null);
	  }

	  setImageInfos((Set) filter.filter(IMAGEINFOS,_ImageInfos)); 

	  // Visiting: Leader ------------------------------------------
	  Experimenter _Leader = null;
	  try {
	     _Leader = getLeader();
	  } catch (Exception e) {
		 setLeader(null);
	  }

	  setLeader((Experimenter) filter.filter(LEADER,_Leader)); 

	  // Visiting: Contact ------------------------------------------
	  Experimenter _Contact = null;
	  try {
	     _Contact = getContact();
	  } catch (Exception e) {
		 setContact(null);
	  }

	  setContact((Experimenter) filter.filter(CONTACT,_Contact)); 

	  // Visiting: ModuleExecution ------------------------------------------
	  ModuleExecution _ModuleExecution = null;
	  try {
	     _ModuleExecution = getModuleExecution();
	  } catch (Exception e) {
		 setModuleExecution(null);
	  }

	  setModuleExecution((ModuleExecution) filter.filter(MODULEEXECUTION,_ModuleExecution)); 
   	 return true;
  }
  
  public String toString(){
	return "Group"+(attributeId==null ? ":Hash_"+this.hashCode() : ":Id_"+attributeId);
  }
  
  // FIELD-FIELDS
  
	public final static String ATTRIBUTEID = "Group_AttributeId";
	public final static String NAME = "Group_Name";
	public final static String DATASETS = "Group_Datasets";
	public final static String IMAGES = "Group_Images";
	public final static String PROJECTS = "Group_Projects";
	public final static String EXPERIMENTERS = "Group_Experimenters";
	public final static String MODULEEXECUTIONS = "Group_ModuleExecutions";
	public final static String IMAGEINFOS = "Group_ImageInfos";
	public final static String LEADER = "Group_Leader";
	public final static String CONTACT = "Group_Contact";
	public final static String MODULEEXECUTION = "Group_ModuleExecution";
 	public final static Set FIELDS = new HashSet();
	static {
	   FIELDS.add(ATTRIBUTEID);
	   FIELDS.add(NAME);
	   FIELDS.add(DATASETS);
	   FIELDS.add(IMAGES);
	   FIELDS.add(PROJECTS);
	   FIELDS.add(EXPERIMENTERS);
	   FIELDS.add(MODULEEXECUTIONS);
	   FIELDS.add(IMAGEINFOS);
	   FIELDS.add(LEADER);
	   FIELDS.add(CONTACT);
	   FIELDS.add(MODULEEXECUTION);
 	}


}
