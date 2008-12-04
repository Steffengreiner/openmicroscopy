/*
 *   $Id$
 *
 *   Copyright 2008 Glencoe Software, Inc. All rights reserved.
 *   Use is subject to license terms supplied in LICENSE.txt
 */

package ome.services.blitz.impl;

import ome.formats.OMEROMetadataStore;
import ome.model.IObject;
import ome.services.blitz.util.BlitzExecutor;
import ome.services.blitz.util.BlitzOnly;
import ome.services.blitz.util.ServiceFactoryAware;
import ome.services.throttling.Adapter;
import ome.services.util.Executor;
import ome.system.OmeroContext;
import ome.system.ServiceFactory;
import ome.tools.spring.InternalServiceFactory;
import omero.RBool;
import omero.RDouble;
import omero.RFloat;
import omero.RInt;
import omero.RLong;
import omero.RObject;
import omero.RString;
import omero.RType;
import omero.ServerError;
import omero.api.*;
import omero.model.BooleanAnnotation;
import omero.model.Dataset;
import omero.model.Image;
import omero.model.Instrument;
import omero.model.Pixels;
import omero.model.PlaneInfo;
import omero.model.Project;
import omero.util.IceMapper;

import org.hibernate.Session;
import org.springframework.transaction.TransactionStatus;

import Ice.Current;
import Ice.UserException;

/**
 */
public class MetadataStoreI extends AbstractAmdServant implements
        _MetadataStoreOperations, ServiceFactoryAware, BlitzOnly {

    protected OMEROMetadataStore store;

    protected ServiceFactoryI sf;

    public MetadataStoreI(final BlitzExecutor be) throws Exception {
        super(null, be);
    }

    public void setServiceFactory(ServiceFactoryI sf) throws ServerError {
        this.sf = sf;
    }

    @Override
    public void setOmeroContext(final OmeroContext ctx) throws Exception {
        ServiceFactory sf = new InternalServiceFactory(ctx);
        this.store = new OMEROMetadataStore(sf);
    }

    @SuppressWarnings("unchecked")
    private <T extends IObject> T safeReverse(Object o, IceMapper mapper) {
        try {
            return (T) mapper.reverse(o);
        } catch (Exception e) {
            throw new RuntimeException("Failed to safely reverse: " + o);
        }
    }

    // ~ Service methods
    // =========================================================================

    public void createRoot_async(final AMD_MetadataStore_createRoot __cb,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.createRoot();
                        return null;
                    }
                }));
    }

    public void getDatasets_async(final AMD_MetadataStore_getDatasets __cb,
            final Project project, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.FILTERABLE_COLLECTION);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        ome.model.containers.Project _project = safeReverse(
                                project, mapper);
                        return store.getDatasets(_project);
                    }
                }));
    }

    public void getPixels_async(final AMD_MetadataStore_getPixels __cb,
            final int series, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.FILTERABLE);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        return store.getPixels(series);
                    }
                }));
    }

    public void getPlaneInfo_async(final AMD_MetadataStore_getPlaneInfo __cb,
            final int imageIndex, final int pixelsIndex, final int planeIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.getPlaneInfo(imageIndex, pixelsIndex, planeIndex);
                        return null;
                    }
                }));
    }

    public void getProjects_async(final AMD_MetadataStore_getProjects __cb,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.FILTERABLE_COLLECTION);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        return store.getProjects();
                    }
                }));
    }

    public void getRoot_async(final AMD_MetadataStore_getRoot __cb,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.FILTERABLE_COLLECTION);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {
                        return store.getRoot();
                    }
                }));
    }

    public void populateMinMax_async(
            final AMD_MetadataStore_populateMinMax __cb, final RLong id,
            final RInt i, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.populateMinMax(id.getValue(), i.getValue());
                        return null;
                    }
                }));
    }

    public void saveToDB_async(final AMD_MetadataStore_saveToDB __cb,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.FILTERABLE_COLLECTION);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        return store.saveToDB();
                    }
                }));
    }

    public void setArcPower_async(final AMD_MetadataStore_setArcPower __cb,
            final RFloat power, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setArcPower(power.getValue(), instrumentIndex,
                                lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setArcType_async(final AMD_MetadataStore_setArcType __cb,
            final RString type, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setArcType(type.getValue(), instrumentIndex,
                                lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setChannelComponentColorDomain_async(
            final AMD_MetadataStore_setChannelComponentColorDomain __cb,
            final RString colorDomain, final int imageIndex,
            final int logicalChannelIndex, final int channelComponentIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setChannelComponentColorDomain(colorDomain.getValue(),
                                imageIndex, logicalChannelIndex,
                                channelComponentIndex);
                        return null;
                    }
                }));
    }

    public void setChannelComponentIndex_async(
            final AMD_MetadataStore_setChannelComponentIndex __cb,
            final RInt index, final int imageIndex,
            final int logicalChannelIndex, final int channelComponentIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setChannelComponentIndex(index.getValue(), imageIndex,
                                logicalChannelIndex, channelComponentIndex);
                        return null;
                    }
                }));
    }

    public void setChannelGlobalMinMax_async(
            final AMD_MetadataStore_setChannelGlobalMinMax __cb,
            final int channelIdx, final RDouble globalMin,
            final RDouble globalMax, final RInt pixelsIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setChannelGlobalMinMax(channelIdx, globalMin.getValue(),
                                globalMax.getValue(), pixelsIndex.getValue());
                        return null;
                    }
                }));
    }

    public void setDetectorGain_async(
            final AMD_MetadataStore_setDetectorGain __cb, final RFloat gain,
            final int instrumentIndex, final int detectorIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorGain(gain.getValue(), instrumentIndex,
                                detectorIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorID_async(final AMD_MetadataStore_setDetectorID __cb,
            final RString id, final int instrumentIndex,
            final int detectorIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorID(id.getValue(), instrumentIndex,
                                detectorIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorManufacturer_async(
            final AMD_MetadataStore_setDetectorManufacturer __cb,
            final RString manufacturer, final int instrumentIndex,
            final int detectorIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorManufacturer(manufacturer.getValue(),
                                instrumentIndex, detectorIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorModel_async(
            final AMD_MetadataStore_setDetectorModel __cb, final RString model,
            final int instrumentIndex, final int detectorIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorModel(model.getValue(), instrumentIndex,
                                detectorIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorNodeID_async(
            final AMD_MetadataStore_setDetectorNodeID __cb,
            final RString nodeID, final int instrumentIndex,
            final int detectorIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorNodeID(nodeID.getValue(), instrumentIndex,
                                detectorIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorOffset_async(
            final AMD_MetadataStore_setDetectorOffset __cb,
            final RFloat offset, final int instrumentIndex,
            final int detectorIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorOffset(offset.getValue(), instrumentIndex,
                                detectorIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorSerialNumber_async(
            final AMD_MetadataStore_setDetectorSerialNumber __cb,
            final RString serialNumber, final int instrumentIndex,
            final int detectorIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorSerialNumber(serialNumber.getValue(),
                                instrumentIndex, detectorIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorSettingsDetector_async(
            final AMD_MetadataStore_setDetectorSettingsDetector __cb,
            final RString detector, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorSettingsDetector(detector.getValue(),
                                imageIndex, logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorSettingsGain_async(
            final AMD_MetadataStore_setDetectorSettingsGain __cb,
            final RFloat gain, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorSettingsGain(gain.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorSettingsOffset_async(
            final AMD_MetadataStore_setDetectorSettingsOffset __cb,
            final RFloat offset, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorSettingsOffset(offset.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorType_async(
            final AMD_MetadataStore_setDetectorType __cb, final RString type,
            final int instrumentIndex, final int detectorIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorType(type.getValue(), instrumentIndex,
                                detectorIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorVoltage_async(
            final AMD_MetadataStore_setDetectorVoltage __cb,
            final RFloat voltage, final int instrumentIndex,
            final int detectorIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorVoltage(voltage.getValue(), instrumentIndex,
                                detectorIndex);
                        return null;
                    }
                }));
    }

    public void setDimensionsPhysicalSizeX_async(
            final AMD_MetadataStore_setDimensionsPhysicalSizeX __cb,
            final RFloat physicalSizeX, final int imageIndex,
            final int pixelsIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDimensionsPhysicalSizeX(physicalSizeX.getValue(),
                                imageIndex, pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setDimensionsPhysicalSizeY_async(
            final AMD_MetadataStore_setDimensionsPhysicalSizeY __cb,
            final RFloat physicalSizeY, final int imageIndex,
            final int pixelsIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDimensionsPhysicalSizeY(physicalSizeY.getValue(),
                                imageIndex, pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setDimensionsPhysicalSizeZ_async(
            final AMD_MetadataStore_setDimensionsPhysicalSizeZ __cb,
            final RFloat physicalSizeZ, final int imageIndex,
            final int pixelsIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDimensionsPhysicalSizeZ(physicalSizeZ.getValue(),
                                imageIndex, pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setDimensionsTimeIncrement_async(
            final AMD_MetadataStore_setDimensionsTimeIncrement __cb,
            final RFloat timeIncrement, final int imageIndex,
            final int pixelsIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDimensionsTimeIncrement(timeIncrement.getValue(),
                                imageIndex, pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setDimensionsWaveIncrement_async(
            final AMD_MetadataStore_setDimensionsWaveIncrement __cb,
            final RInt waveIncrement, final int imageIndex,
            final int pixelsIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDimensionsWaveIncrement(waveIncrement.getValue(),
                                imageIndex, pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setDimensionsWaveStart_async(
            final AMD_MetadataStore_setDimensionsWaveStart __cb,
            final RInt waveStart, final int imageIndex, final int pixelsIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDimensionsWaveStart(waveStart.getValue(), imageIndex,
                                pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setDisplayOptionsID_async(
            final AMD_MetadataStore_setDisplayOptionsID __cb, final RString id,
            final int imageIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDisplayOptionsID(id.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setDisplayOptionsNodeID_async(
            final AMD_MetadataStore_setDisplayOptionsNodeID __cb,
            final RString nodeID, final int imageIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDisplayOptionsNodeID(nodeID.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setDisplayOptionsProjectionZStart_async(
            final AMD_MetadataStore_setDisplayOptionsProjectionZStart __cb,
            final RInt start, final int imageIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDisplayOptionsProjectionZStart(start.getValue(),
                                imageIndex);
                        return null;
                    }
                }));
    }

    public void setDisplayOptionsProjectionZStop_async(
            final AMD_MetadataStore_setDisplayOptionsProjectionZStop __cb,
            final RInt stop, final int imageIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDisplayOptionsProjectionZStop(stop.getValue(),
                                imageIndex);
                        return null;
                    }
                }));
    }

    public void setDisplayOptionsTimeTStart_async(
            final AMD_MetadataStore_setDisplayOptionsTimeTStart __cb,
            final RInt start, final int imageIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store
                                .setDisplayOptionsTimeTStart(start.getValue(),
                                        imageIndex);
                        return null;
                    }
                }));
    }

    public void setDisplayOptionsTimeTStop_async(
            final AMD_MetadataStore_setDisplayOptionsTimeTStop __cb,
            final RInt stop, final int imageIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDisplayOptionsTimeTStop(stop.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setDisplayOptionsZoom_async(
            final AMD_MetadataStore_setDisplayOptionsZoom __cb,
            final RFloat zoom, final int imageIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDisplayOptionsZoom(zoom.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setExperimenterDataDirectory_async(
            final AMD_MetadataStore_setExperimenterDataDirectory __cb,
            final RString dataDirectory, final int experimenterIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setExperimenterDataDirectory(dataDirectory.getValue(),
                                experimenterIndex);
                        return null;
                    }
                }));
    }

    public void setExperimenterEmail_async(
            final AMD_MetadataStore_setExperimenterEmail __cb,
            final RString email, final int experimenterIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store
                                .setExperimenterEmail(email.getValue(),
                                        experimenterIndex);
                        return null;
                    }
                }));
    }

    public void setExperimenterFirstName_async(
            final AMD_MetadataStore_setExperimenterFirstName __cb,
            final RString firstName, final int experimenterIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setExperimenterFirstName(firstName.getValue(),
                                experimenterIndex);
                        return null;
                    }
                }));
    }

    public void setExperimenterID_async(
            final AMD_MetadataStore_setExperimenterID __cb, final RString id,
            final int experimenterIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setExperimenterID(id.getValue(), experimenterIndex);
                        return null;
                    }
                }));
    }

    public void setExperimenterInstitution_async(
            final AMD_MetadataStore_setExperimenterInstitution __cb,
            final RString institution, final int experimenterIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setExperimenterInstitution(institution.getValue(),
                                experimenterIndex);
                        return null;
                    }
                }));
    }

    public void setExperimenterLastName_async(
            final AMD_MetadataStore_setExperimenterLastName __cb,
            final RString lastName, final int experimenterIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setExperimenterLastName(lastName.getValue(),
                                experimenterIndex);
                        return null;
                    }
                }));
    }

    public void setExperimenterNodeID_async(
            final AMD_MetadataStore_setExperimenterNodeID __cb,
            final RString nodeID, final int experimenterIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setExperimenterNodeID(nodeID.getValue(),
                                experimenterIndex);
                        return null;
                    }
                }));
    }

    public void setFilamentPower_async(
            final AMD_MetadataStore_setFilamentPower __cb, final RFloat power,
            final int instrumentIndex, final int lightSourceIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setFilamentPower(power.getValue(), instrumentIndex,
                                lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setFilamentType_async(
            final AMD_MetadataStore_setFilamentType __cb, final RString type,
            final int instrumentIndex, final int lightSourceIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setFilamentType(type.getValue(), instrumentIndex,
                                lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setImageCreationDate_async(
            final AMD_MetadataStore_setImageCreationDate __cb,
            final RString creationDate, final int imageIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store
                                .setImageCreationDate(creationDate.getValue(),
                                        imageIndex);
                        return null;
                    }
                }));
    }

    public void setImageDescription_async(
            final AMD_MetadataStore_setImageDescription __cb,
            final RString description, final int imageIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setImageDescription(description.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setImageID_async(final AMD_MetadataStore_setImageID __cb,
            final RString id, final int imageIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setImageID(id.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setImageInstrumentRef_async(
            final AMD_MetadataStore_setImageInstrumentRef __cb,
            final RString instrumentRef, final int imageIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setImageInstrumentRef(instrumentRef.getValue(),
                                imageIndex);
                        return null;
                    }
                }));
    }

    public void setImageName_async(final AMD_MetadataStore_setImageName __cb,
            final RString name, final int imageIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setImageName(name.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setImageNodeID_async(
            final AMD_MetadataStore_setImageNodeID __cb, final RString nodeID,
            final int imageIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setImageNodeID(nodeID.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setImagingEnvironmentAirPressure_async(
            final AMD_MetadataStore_setImagingEnvironmentAirPressure __cb,
            final RFloat airPressure, final int imageIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setImagingEnvironmentAirPressure(airPressure.getValue(),
                                imageIndex);
                        return null;
                    }
                }));
    }

    public void setImagingEnvironmentCO2Percent_async(
            final AMD_MetadataStore_setImagingEnvironmentCO2Percent __cb,
            final RFloat percent, final int imageIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setImagingEnvironmentCO2Percent(percent.getValue(),
                                imageIndex);
                        return null;
                    }
                }));
    }

    public void setImagingEnvironmentHumidity_async(
            final AMD_MetadataStore_setImagingEnvironmentHumidity __cb,
            final RFloat humidity, final int imageIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setImagingEnvironmentHumidity(humidity.getValue(),
                                imageIndex);
                        return null;
                    }
                }));
    }

    public void setImagingEnvironmentTemperature_async(
            final AMD_MetadataStore_setImagingEnvironmentTemperature __cb,
            final RFloat temperature, final int imageIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setImagingEnvironmentTemperature(temperature.getValue(),
                                imageIndex);
                        return null;
                    }
                }));
    }

    public void setInstrumentID_async(
            final AMD_MetadataStore_setInstrumentID __cb, final RString id,
            final int instrumentIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setInstrumentID(id.getValue(), instrumentIndex);
                        return null;
                    }
                }));
    }

    public void setInstrumentNodeID_async(
            final AMD_MetadataStore_setInstrumentNodeID __cb,
            final RString nodeID, final int instrumentIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setInstrumentNodeID(nodeID.getValue(), instrumentIndex);
                        return null;
                    }
                }));
    }

    public void setLaserFrequencyMultiplication_async(
            final AMD_MetadataStore_setLaserFrequencyMultiplication __cb,
            final RInt frequencyMultiplication, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLaserFrequencyMultiplication(
                                frequencyMultiplication.getValue(), instrumentIndex,
                                lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setLaserLaserMedium_async(
            final AMD_MetadataStore_setLaserLaserMedium __cb,
            final RString laserMedium, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLaserLaserMedium(laserMedium.getValue(),
                                instrumentIndex, lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setLaserPower_async(final AMD_MetadataStore_setLaserPower __cb,
            final RFloat power, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLaserPower(power.getValue(), instrumentIndex,
                                lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setLaserPulse_async(final AMD_MetadataStore_setLaserPulse __cb,
            final RString pulse, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLaserPulse(pulse.getValue(), instrumentIndex,
                                lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setLaserTuneable_async(
            final AMD_MetadataStore_setLaserTuneable __cb,
            final RBool tuneable, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLaserTuneable(tuneable.getValue(), instrumentIndex,
                                lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setLaserType_async(final AMD_MetadataStore_setLaserType __cb,
            final RString type, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLaserType(type.getValue(), instrumentIndex,
                                lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setLaserWavelength_async(
            final AMD_MetadataStore_setLaserWavelength __cb,
            final RInt wavelength, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLaserWavelength(wavelength.getValue(),
                                instrumentIndex, lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setLightSourceID_async(
            final AMD_MetadataStore_setLightSourceID __cb, final RString id,
            final int instrumentIndex, final int lightSourceIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLightSourceID(id.getValue(), instrumentIndex,
                                lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setLightSourceManufacturer_async(
            final AMD_MetadataStore_setLightSourceManufacturer __cb,
            final RString manufacturer, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLightSourceManufacturer(manufacturer.getValue(),
                                instrumentIndex, lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setLightSourceModel_async(
            final AMD_MetadataStore_setLightSourceModel __cb,
            final RString model, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {
                        store.setLightSourceModel(model.getValue(), instrumentIndex,
                                lightSourceIndex);
                        return null;
                    }
                }));

    }

    public void setLightSourceNodeID_async(
            final AMD_MetadataStore_setLightSourceNodeID __cb,
            final RString nodeID, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLightSourceID(nodeID.getValue(), instrumentIndex,
                                lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setLightSourcePower_async(
            final AMD_MetadataStore_setLightSourcePower __cb,
            final RFloat power, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLightSourcePower(power.getValue(), instrumentIndex,
                                lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setLightSourceSerialNumber_async(
            final AMD_MetadataStore_setLightSourceSerialNumber __cb,
            final RString serialNumber, final int instrumentIndex,
            final int lightSourceIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLightSourceSerialNumber(serialNumber.getValue(),
                                instrumentIndex, lightSourceIndex);
                        return null;
                    }
                }));
    }

    public void setLightSourceSettingsAttenuation_async(
            final AMD_MetadataStore_setLightSourceSettingsAttenuation __cb,
            final RFloat attenuation, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLightSourceSettingsAttenuation(
                                attenuation.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLightSourceSettingsLightSource_async(
            final AMD_MetadataStore_setLightSourceSettingsLightSource __cb,
            final RString lightSource, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLightSourceSettingsLightSource(
                                lightSource.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLightSourceSettingsWavelength_async(
            final AMD_MetadataStore_setLightSourceSettingsWavelength __cb,
            final RInt wavelength, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLightSourceSettingsWavelength(wavelength.getValue(),
                                imageIndex, logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelContrastMethod_async(
            final AMD_MetadataStore_setLogicalChannelContrastMethod __cb,
            final RString contrastMethod, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelContrastMethod(
                                contrastMethod.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelEmWave_async(
            final AMD_MetadataStore_setLogicalChannelEmWave __cb,
            final RInt emWave, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelEmWave(emWave.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelExWave_async(
            final AMD_MetadataStore_setLogicalChannelExWave __cb,
            final RInt exWave, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelExWave(exWave.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelFluor_async(
            final AMD_MetadataStore_setLogicalChannelFluor __cb,
            final RString fluor, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelFluor(fluor.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelID_async(
            final AMD_MetadataStore_setLogicalChannelID __cb, final RString id,
            final int imageIndex, final int logicalChannelIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelID(id.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelIlluminationType_async(
            final AMD_MetadataStore_setLogicalChannelIlluminationType __cb,
            final RString illuminationType, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelIlluminationType(
                                illuminationType.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelMode_async(
            final AMD_MetadataStore_setLogicalChannelMode __cb,
            final RString mode, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelMode(mode.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelName_async(
            final AMD_MetadataStore_setLogicalChannelName __cb,
            final RString name, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelName(name.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelNdFilter_async(
            final AMD_MetadataStore_setLogicalChannelNdFilter __cb,
            final RFloat ndFilter, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelNdFilter(ndFilter.getValue(),
                                imageIndex, logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelNodeID_async(
            final AMD_MetadataStore_setLogicalChannelNodeID __cb,
            final RString nodeID, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelNodeID(nodeID.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelPhotometricInterpretation_async(
            final AMD_MetadataStore_setLogicalChannelPhotometricInterpretation __cb,
            final RString photometricInterpretation, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelPhotometricInterpretation(
                                photometricInterpretation.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelPinholeSize_async(
            final AMD_MetadataStore_setLogicalChannelPinholeSize __cb,
            final RFloat pinholeSize, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelPinholeSize(pinholeSize.getValue(),
                                imageIndex, logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelPockelCellSetting_async(
            final AMD_MetadataStore_setLogicalChannelPockelCellSetting __cb,
            final RInt pockelCellSetting, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelPockelCellSetting(
                                pockelCellSetting.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setLogicalChannelSamplesPerPixel_async(
            final AMD_MetadataStore_setLogicalChannelSamplesPerPixel __cb,
            final RInt samplesPerPixel, final int imageIndex,
            final int logicalChannelIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setLogicalChannelSamplesPerPixel(
                                samplesPerPixel.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setOTFID_async(final AMD_MetadataStore_setOTFID __cb,
            final RString id, final int instrumentIndex, final int otfIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setOTFID(id.getValue(), instrumentIndex, otfIndex);
                        return null;
                    }
                }));
    }

    public void setOTFNodeID_async(final AMD_MetadataStore_setOTFNodeID __cb,
            final RString nodeID, final int instrumentIndex,
            final int otfIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setOTFNodeID(nodeID.getValue(), instrumentIndex,
                                otfIndex);
                        return null;
                    }
                }));
    }

    public void setOTFOpticalAxisAveraged_async(
            final AMD_MetadataStore_setOTFOpticalAxisAveraged __cb,
            final RBool opticalAxisAveraged, final int instrumentIndex,
            final int otfIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setOTFOpticalAxisAveraged(
                                opticalAxisAveraged.getValue(), instrumentIndex,
                                otfIndex);
                        return null;
                    }
                }));
    }

    public void setOTFPath_async(final AMD_MetadataStore_setOTFPath __cb,
            final RString path, final int instrumentIndex, final int otfIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setOTFPath(path.getValue(), instrumentIndex, otfIndex);
                        return null;
                    }
                }));
    }

    public void setOTFPixelType_async(
            final AMD_MetadataStore_setOTFPixelType __cb,
            final RString pixelType, final int instrumentIndex,
            final int otfIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setOTFPixelType(pixelType.getValue(), instrumentIndex,
                                otfIndex);
                        return null;
                    }
                }));
    }

    public void setOTFSizeX_async(final AMD_MetadataStore_setOTFSizeX __cb,
            final RInt sizeX, final int instrumentIndex, final int otfIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setOTFSizeX(sizeX.getValue(), instrumentIndex, otfIndex);
                        return null;
                    }
                }));
    }

    public void setOTFSizeY_async(final AMD_MetadataStore_setOTFSizeY __cb,
            final RInt sizeY, final int instrumentIndex, final int otfIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setOTFSizeY(sizeY.getValue(), instrumentIndex, otfIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveCalibratedMagnification_async(
            final AMD_MetadataStore_setObjectiveCalibratedMagnification __cb,
            final RFloat calibratedMagnification, final int instrumentIndex,
            final int objectiveIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveCalibratedMagnification(
                                calibratedMagnification.getValue(), instrumentIndex,
                                objectiveIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveCorrection_async(
            final AMD_MetadataStore_setObjectiveCorrection __cb,
            final RString correction, final int instrumentIndex,
            final int objectiveIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveCorrection(correction.getValue(),
                                instrumentIndex, objectiveIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveID_async(
            final AMD_MetadataStore_setObjectiveID __cb, final RString id,
            final int instrumentIndex, final int objectiveIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveID(id.getValue(), instrumentIndex,
                                objectiveIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveIris_async(
            final AMD_MetadataStore_setObjectiveID __cb, final RBool iris,
            final int instrumentIndex, final int objectiveIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveIris(iris.getValue(), instrumentIndex,
                                objectiveIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveImmersion_async(
            final AMD_MetadataStore_setObjectiveImmersion __cb,
            final RString immersion, final int instrumentIndex,
            final int objectiveIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveImmersion(immersion.getValue(),
                                instrumentIndex, objectiveIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveLensNA_async(
            final AMD_MetadataStore_setObjectiveLensNA __cb,
            final RFloat lensNA, final int instrumentIndex,
            final int objectiveIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveLensNA(lensNA.getValue(), instrumentIndex,
                                objectiveIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveManufacturer_async(
            final AMD_MetadataStore_setObjectiveManufacturer __cb,
            final RString manufacturer, final int instrumentIndex,
            final int objectiveIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveManufacturer(manufacturer.getValue(),
                                instrumentIndex, objectiveIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveModel_async(
            final AMD_MetadataStore_setObjectiveModel __cb,
            final RString model, final int instrumentIndex,
            final int objectiveIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveModel(model.getValue(), instrumentIndex,
                                objectiveIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveNodeID_async(
            final AMD_MetadataStore_setObjectiveNodeID __cb,
            final RString nodeID, final int instrumentIndex,
            final int objectiveIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveNodeID(nodeID.getValue(), instrumentIndex,
                                objectiveIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveNominalMagnification_async(
            final AMD_MetadataStore_setObjectiveNominalMagnification __cb,
            final RInt nominalMagnification, final int instrumentIndex,
            final int objectiveIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveNominalMagnification(
                                nominalMagnification.getValue(), instrumentIndex,
                                objectiveIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveSerialNumber_async(
            final AMD_MetadataStore_setObjectiveSerialNumber __cb,
            final RString serialNumber, final int instrumentIndex,
            final int objectiveIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveSerialNumber(serialNumber.getValue(),
                                instrumentIndex, objectiveIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveWorkingDistance_async(
            final AMD_MetadataStore_setObjectiveWorkingDistance __cb,
            final RFloat workingDistance, final int instrumentIndex,
            final int objectiveIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveWorkingDistance(workingDistance.getValue(),
                                instrumentIndex, objectiveIndex);
                        return null;
                    }
                }));
    }

    public void setPixelsBigEndian_async(
            final AMD_MetadataStore_setPixelsBigEndian __cb,
            final RBool bigEndian, final int imageIndex, final int pixelsIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPixelsBigEndian(bigEndian.getValue(), imageIndex,
                                pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setPixelsDimensionOrder_async(
            final AMD_MetadataStore_setPixelsDimensionOrder __cb,
            final RString dimensionOrder, final int imageIndex,
            final int pixelsIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPixelsDimensionOrder(dimensionOrder.getValue(),
                                imageIndex, pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setPixelsID_async(final AMD_MetadataStore_setPixelsID __cb,
            final RString id, final int imageIndex, final int pixelsIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPixelsID(id.getValue(), imageIndex, pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setPixelsNodeID_async(
            final AMD_MetadataStore_setPixelsNodeID __cb, final RString nodeID,
            final int imageIndex, final int pixelsIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPixelsNodeID(nodeID.getValue(), imageIndex,
                                pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setPixelsPixelType_async(
            final AMD_MetadataStore_setPixelsPixelType __cb,
            final RString pixelType, final int imageIndex,
            final int pixelsIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPixelsPixelType(pixelType.getValue(), imageIndex,
                                pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setPixelsSizeC_async(
            final AMD_MetadataStore_setPixelsSizeC __cb, final RInt sizeC,
            final int imageIndex, final int pixelsIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store
                                .setPixelsSizeC(sizeC.getValue(), imageIndex,
                                        pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setPixelsSizeT_async(
            final AMD_MetadataStore_setPixelsSizeT __cb, final RInt sizeT,
            final int imageIndex, final int pixelsIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store
                                .setPixelsSizeT(sizeT.getValue(), imageIndex,
                                        pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setPixelsSizeX_async(
            final AMD_MetadataStore_setPixelsSizeX __cb, final RInt sizeX,
            final int imageIndex, final int pixelsIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store
                                .setPixelsSizeX(sizeX.getValue(), imageIndex,
                                        pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setPixelsSizeY_async(
            final AMD_MetadataStore_setPixelsSizeY __cb, final RInt sizeY,
            final int imageIndex, final int pixelsIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store
                                .setPixelsSizeY(sizeY.getValue(), imageIndex,
                                        pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setPixelsSizeZ_async(
            final AMD_MetadataStore_setPixelsSizeZ __cb, final RInt sizeZ,
            final int imageIndex, final int pixelsIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store
                                .setPixelsSizeZ(sizeZ.getValue(), imageIndex,
                                        pixelsIndex);
                        return null;
                    }
                }));
    }

    public void setPlaneTheC_async(final AMD_MetadataStore_setPlaneTheC __cb,
            final RInt theC, final int imageIndex, final int pixelsIndex,
            final int planeIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPlaneTheC(theC.getValue(), imageIndex, pixelsIndex,
                                planeIndex);
                        return null;
                    }
                }));
    }

    public void setPlaneTheT_async(final AMD_MetadataStore_setPlaneTheT __cb,
            final RInt theT, final int imageIndex, final int pixelsIndex,
            final int planeIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPlaneTheT(theT.getValue(), imageIndex, pixelsIndex,
                                planeIndex);
                        return null;
                    }
                }));
    }

    public void setPlaneTheZ_async(final AMD_MetadataStore_setPlaneTheZ __cb,
            final RInt theZ, final int imageIndex, final int pixelsIndex,
            final int planeIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPlaneTheZ(theZ.getValue(), imageIndex, pixelsIndex,
                                planeIndex);
                        return null;
                    }
                }));
    }

    public void setPlaneTimingDeltaT_async(
            final AMD_MetadataStore_setPlaneTimingDeltaT __cb,
            final RFloat deltaT, final int imageIndex, final int pixelsIndex,
            final int planeIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPlaneTimingDeltaT(deltaT.getValue(), imageIndex,
                                pixelsIndex, planeIndex);
                        return null;
                    }
                }));
    }

    public void setPlaneTimingExposureTime_async(
            final AMD_MetadataStore_setPlaneTimingExposureTime __cb,
            final RFloat exposureTime, final int imageIndex,
            final int pixelsIndex, final int planeIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPlaneTimingExposureTime(exposureTime.getValue(),
                                imageIndex, pixelsIndex, planeIndex);
                        return null;
                    }
                }));
    }

    public void setPlateDescription_async(
            final AMD_MetadataStore_setPlateDescription __cb,
            final RString description, final int plateIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPlateDescription(description.getValue(), plateIndex);
                        return null;
                    }
                }));
    }

    public void setPlateExternalIdentifier_async(
            final AMD_MetadataStore_setPlateExternalIdentifier __cb,
            final RString externalIdentifier, final int plateIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPlateExternalIdentifier(
                                externalIdentifier.getValue(), plateIndex);
                        return null;
                    }
                }));
    }

    public void setPlateID_async(final AMD_MetadataStore_setPlateID __cb,
            final RString id, final int plateIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPlateID(id.getValue(), plateIndex);
                        return null;
                    }
                }));
    }

    public void setPlateName_async(final AMD_MetadataStore_setPlateName __cb,
            final RString name, final int plateIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPlateName(name.getValue(), plateIndex);
                        return null;
                    }
                }));
    }

    public void setPlateRefID_async(final AMD_MetadataStore_setPlateRefID __cb,
            final RString id, final int screenIndex, final int plateRefIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPlateRefID(id.getValue(), screenIndex, plateRefIndex);
                        return null;
                    }
                }));
    }

    public void setPlateStatus_async(
            final AMD_MetadataStore_setPlateStatus __cb, final RString status,
            final int plateIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus _status,
                            Session session, ServiceFactory sf) {

                        store.setPlateStatus(status.getValue(), plateIndex);
                        return null;
                    }
                }));
    }

    public void setROIID_async(final AMD_MetadataStore_setROIID __cb,
            final RString id, final int imageIndex, final int roiIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setROIID(id.getValue(), imageIndex, roiIndex);
                        return null;
                    }
                }));
    }

    public void setROINodeID_async(final AMD_MetadataStore_setROINodeID __cb,
            final RString nodeID, final int imageIndex, final int roiIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setROINodeID(nodeID.getValue(), imageIndex, roiIndex);
                        return null;
                    }
                }));
    }

    public void setROIT0_async(final AMD_MetadataStore_setROIT0 __cb,
            final RInt t0, final int imageIndex, final int roiIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setROIT0(t0.getValue(), imageIndex, roiIndex);
                        return null;
                    }
                }));
    }

    public void setROIT1_async(final AMD_MetadataStore_setROIT1 __cb,
            final RInt t1, final int imageIndex, final int roiIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setROIT1(t1.getValue(), imageIndex, roiIndex);
                        return null;
                    }
                }));
    }

    public void setROIX0_async(final AMD_MetadataStore_setROIX0 __cb,
            final RInt x0, final int imageIndex, final int roiIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setROIX0(x0.getValue(), imageIndex, roiIndex);
                        return null;
                    }
                }));
    }

    public void setROIX1_async(final AMD_MetadataStore_setROIX1 __cb,
            final RInt x1, final int imageIndex, final int roiIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setROIX1(x1.getValue(), imageIndex, roiIndex);
                        return null;
                    }
                }));
    }

    public void setROIY0_async(final AMD_MetadataStore_setROIY0 __cb,
            final RInt y0, final int imageIndex, final int roiIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setROIY0(y0.getValue(), imageIndex, roiIndex);
                        return null;
                    }
                }));
    }

    public void setROIY1_async(final AMD_MetadataStore_setROIY1 __cb,
            final RInt y1, final int imageIndex, final int roiIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setROIY1(y1.getValue(), imageIndex, roiIndex);
                        return null;
                    }
                }));
    }

    public void setROIZ0_async(final AMD_MetadataStore_setROIZ0 __cb,
            final RInt z0, final int imageIndex, final int roiIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setROIZ0(z0.getValue(), imageIndex, roiIndex);
                        return null;
                    }
                }));
    }

    public void setROIZ1_async(final AMD_MetadataStore_setROIZ1 __cb,
            final RInt z1, final int imageIndex, final int roiIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setROIZ1(z1.getValue(), imageIndex, roiIndex);
                        return null;
                    }
                }));
    }

    public void setReagentDescription_async(
            final AMD_MetadataStore_setReagentDescription __cb,
            final RString description, final int screenIndex,
            final int reagentIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setReagentDescription(description.getValue(),
                                screenIndex, reagentIndex);
                        return null;
                    }
                }));
    }

    public void setReagentID_async(final AMD_MetadataStore_setReagentID __cb,
            final RString id, final int screenIndex, final int reagentIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setReagentID(id.getValue(), screenIndex, reagentIndex);
                        return null;
                    }
                }));
    }

    public void setReagentName_async(
            final AMD_MetadataStore_setReagentName __cb, final RString name,
            final int screenIndex, final int reagentIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setReagentName(name.getValue(), screenIndex,
                                reagentIndex);
                        return null;
                    }
                }));
    }

    public void setReagentReagentIdentifier_async(
            final AMD_MetadataStore_setReagentReagentIdentifier __cb,
            final RString reagentIdentifier, final int screenIndex,
            final int reagentIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setReagentReagentIdentifier(
                                reagentIdentifier.getValue(), screenIndex,
                                reagentIndex);
                        return null;
                    }
                }));
    }

    public void setRoot_async(final AMD_MetadataStore_setRoot __cb,
            final RType root, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        Object object = null;
                        try {
                            object = mapper.fromRType(root);
                        } catch (Exception e) {
                            throw new RuntimeException(
                                    "Failure to map from rtype: " + root);
                        }
                        store.setRoot(object);
                        return null;
                    }
                }));
    }

    public void setScreenAcquisitionEndTime_async(
            final AMD_MetadataStore_setScreenAcquisitionEndTime __cb,
            final RString endTime, final int screenIndex,
            final int screenAcquisitionIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setScreenAcquisitionEndTime(endTime.getValue(),
                                screenIndex, screenAcquisitionIndex);
                        return null;
                    }
                }));
    }

    public void setScreenAcquisitionID_async(
            final AMD_MetadataStore_setScreenAcquisitionID __cb,
            final RString id, final int screenIndex,
            final int screenAcquisitionIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setScreenAcquisitionID(id.getValue(), screenIndex,
                                screenAcquisitionIndex);
                        return null;
                    }
                }));
    }

    public void setScreenAcquisitionStartTime_async(
            final AMD_MetadataStore_setScreenAcquisitionStartTime __cb,
            final RString startTime, final int screenIndex,
            final int screenAcquisitionIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setScreenAcquisitionStartTime(startTime.getValue(),
                                screenIndex, screenAcquisitionIndex);
                        return null;
                    }
                }));
    }

    public void setScreenID_async(final AMD_MetadataStore_setScreenID __cb,
            final RString id, final int screenIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setScreenID(id.getValue(), screenIndex);
                        return null;
                    }
                }));
    }

    public void setScreenName_async(final AMD_MetadataStore_setScreenName __cb,
            final RString name, final int screenIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setScreenName(name.getValue(), screenIndex);
                        return null;
                    }
                }));
    }

    public void setScreenProtocolDescription_async(
            final AMD_MetadataStore_setScreenProtocolDescription __cb,
            final RString protocolDescription, final int screenIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setScreenProtocolDescription(
                                protocolDescription.getValue(), screenIndex);
                        return null;
                    }
                }));
    }

    public void setScreenProtocolIdentifier_async(
            final AMD_MetadataStore_setScreenProtocolIdentifier __cb,
            final RString protocolIdentifier, final int screenIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setScreenProtocolIdentifier(
                                protocolIdentifier.getValue(), screenIndex);
                        return null;
                    }
                }));
    }

    public void setScreenReagentSetDescription_async(
            final AMD_MetadataStore_setScreenReagentSetDescription __cb,
            final RString reagentSetDescription, final int screenIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setScreenReagentSetDescription(
                                reagentSetDescription.getValue(), screenIndex);
                        return null;
                    }
                }));
    }

    public void setStageLabelName_async(
            final AMD_MetadataStore_setStageLabelName __cb, final RString name,
            final int imageIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setStageLabelName(name.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setStageLabelX_async(
            final AMD_MetadataStore_setStageLabelX __cb, final RFloat x,
            final int imageIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setStageLabelX(x.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setStageLabelY_async(
            final AMD_MetadataStore_setStageLabelY __cb, final RFloat y,
            final int imageIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setStageLabelY(y.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setStageLabelZ_async(
            final AMD_MetadataStore_setStageLabelZ __cb, final RFloat z,
            final int imageIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setStageLabelZ(z.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setStagePositionPositionX_async(
            final AMD_MetadataStore_setStagePositionPositionX __cb,
            final RFloat positionX, final int imageIndex,
            final int pixelsIndex, final int planeIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setStagePositionPositionX(positionX.getValue(),
                                imageIndex, pixelsIndex, planeIndex);
                        return null;
                    }
                }));
    }

    public void setStagePositionPositionY_async(
            final AMD_MetadataStore_setStagePositionPositionY __cb,
            final RFloat positionY, final int imageIndex,
            final int pixelsIndex, final int planeIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setStagePositionPositionY(positionY.getValue(),
                                imageIndex, pixelsIndex, planeIndex);
                        return null;
                    }
                }));
    }

    public void setStagePositionPositionZ_async(
            final AMD_MetadataStore_setStagePositionPositionZ __cb,
            final RFloat positionZ, final int imageIndex,
            final int pixelsIndex, final int planeIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setStagePositionPositionZ(positionZ.getValue(),
                                imageIndex, pixelsIndex, planeIndex);
                        return null;
                    }
                }));
    }

    public void setThePixelsId_async(
            final AMD_MetadataStore_setThePixelsId __cb, final RLong id,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPixelsId(id.getValue());
                        return null;
                    }
                }));
    }

    public void setTiffDataFileName_async(
            final AMD_MetadataStore_setTiffDataFileName __cb,
            final RString fileName, final int imageIndex,
            final int pixelsIndex, final int tiffDataIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setTiffDataFileName(fileName.getValue(), imageIndex,
                                pixelsIndex, tiffDataIndex);
                        return null;
                    }
                }));
    }

    public void setTiffDataFirstC_async(
            final AMD_MetadataStore_setTiffDataFirstC __cb, final RInt firstC,
            final int imageIndex, final int pixelsIndex,
            final int tiffDataIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setTiffDataFirstC(firstC.getValue(), imageIndex,
                                pixelsIndex, tiffDataIndex);
                        return null;
                    }
                }));
    }

    public void setTiffDataFirstT_async(
            final AMD_MetadataStore_setTiffDataFirstT __cb, final RInt firstT,
            final int imageIndex, final int pixelsIndex,
            final int tiffDataIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setTiffDataFirstT(firstT.getValue(), imageIndex,
                                pixelsIndex, tiffDataIndex);
                        return null;
                    }
                }));
    }

    public void setTiffDataFirstZ_async(
            final AMD_MetadataStore_setTiffDataFirstZ __cb, final RInt firstZ,
            final int imageIndex, final int pixelsIndex,
            final int tiffDataIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setTiffDataFirstZ(firstZ.getValue(), imageIndex,
                                pixelsIndex, tiffDataIndex);
                        return null;
                    }
                }));
    }

    public void setTiffDataIFD_async(
            final AMD_MetadataStore_setTiffDataIFD __cb, final RInt ifd,
            final int imageIndex, final int pixelsIndex,
            final int tiffDataIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setTiffDataIFD(ifd.getValue(), imageIndex, pixelsIndex,
                                tiffDataIndex);
                        return null;
                    }
                }));
    }

    public void setTiffDataNumPlanes_async(
            final AMD_MetadataStore_setTiffDataNumPlanes __cb,
            final RInt numPlanes, final int imageIndex, final int pixelsIndex,
            final int tiffDataIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setTiffDataNumPlanes(numPlanes.getValue(), imageIndex,
                                pixelsIndex, tiffDataIndex);
                        return null;
                    }
                }));
    }

    public void setTiffDataUUID_async(
            final AMD_MetadataStore_setTiffDataUUID __cb, final RString uuid,
            final int imageIndex, final int pixelsIndex,
            final int tiffDataIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setTiffDataUUID(uuid.getValue(), imageIndex,
                                pixelsIndex, tiffDataIndex);
                        return null;
                    }
                }));
    }

    public void setUUID_async(final AMD_MetadataStore_setUUID __cb,
            final RString uuid, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setUUID(uuid.getValue());
                        return null;
                    }
                }));
    }

    public void setWellColumn_async(final AMD_MetadataStore_setWellColumn __cb,
            final RInt column, final int plateIndex, final int wellIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setWellColumn(column.getValue(), plateIndex, wellIndex);
                        return null;
                    }
                }));
    }

    public void setWellExternalDescription_async(
            final AMD_MetadataStore_setWellExternalDescription __cb,
            final RString externalDescription, final int plateIndex,
            final int wellIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setWellExternalDescription(
                                externalDescription.getValue(), plateIndex, wellIndex);
                        return null;
                    }
                }));
    }

    public void setWellExternalIdentifier_async(
            final AMD_MetadataStore_setWellExternalIdentifier __cb,
            final RString externalIdentifier, final int plateIndex,
            final int wellIndex, final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setWellExternalIdentifier(externalIdentifier.getValue(),
                                plateIndex, wellIndex);
                        return null;
                    }
                }));
    }

    public void setWellID_async(final AMD_MetadataStore_setWellID __cb,
            final RString id, final int plateIndex, final int wellIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setWellID(id.getValue(), plateIndex, wellIndex);
                        return null;
                    }
                }));
    }

    public void setWellRow_async(final AMD_MetadataStore_setWellRow __cb,
            final RInt row, final int plateIndex, final int wellIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setWellRow(row.getValue(), plateIndex, wellIndex);
                        return null;
                    }
                }));
    }

    public void setWellSampleID_async(
            final AMD_MetadataStore_setWellSampleID __cb, final RString id,
            final int plateIndex, final int wellIndex,
            final int wellSampleIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setWellSampleID(id.getValue(), plateIndex, wellIndex,
                                wellSampleIndex);
                        return null;
                    }
                }));
    }

    public void setWellSampleIndex_async(
            final AMD_MetadataStore_setWellSampleIndex __cb, final RInt index,
            final int plateIndex, final int wellIndex,
            final int wellSampleIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setWellSampleIndex(index.getValue(), plateIndex,
                                wellIndex, wellSampleIndex);
                        return null;
                    }
                }));
    }

    public void setWellSamplePosX_async(
            final AMD_MetadataStore_setWellSamplePosX __cb, final RFloat posX,
            final int plateIndex, final int wellIndex,
            final int wellSampleIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setWellSamplePosX(posX.getValue(), plateIndex,
                                wellIndex, wellSampleIndex);
                        return null;
                    }
                }));
    }

    public void setWellSamplePosY_async(
            final AMD_MetadataStore_setWellSamplePosY __cb, final RFloat posY,
            final int plateIndex, final int wellIndex,
            final int wellSampleIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setWellSamplePosY(posY.getValue(), plateIndex,
                                wellIndex, wellSampleIndex);
                        return null;
                    }
                }));
    }

    public void setWellSampleTimepoint_async(
            final AMD_MetadataStore_setWellSampleTimepoint __cb,
            final RInt timepoint, final int plateIndex, final int wellIndex,
            final int wellSampleIndex, final Current __current)
            throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setWellSampleTimepoint(timepoint.getValue(), plateIndex,
                                wellIndex, wellSampleIndex);
                        return null;
                    }
                }));
    }

    public void setWellType_async(final AMD_MetadataStore_setWellType __cb,
            final RString type, final int plateIndex, final int wellIndex,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setWellType(type.getValue(), plateIndex, wellIndex);
                        return null;
                    }
                }));
    }

    public void close_async(final AMD_StatefulServiceInterface_close __cb,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        // Nulling should be sufficient.
                        store = null;
                        return null;
                    }
                }));
    }

    public void getCurrentEventContext_async(
            final AMD_StatefulServiceInterface_getCurrentEventContext __cb,
            final Current __current) throws ServerError {

        final IceMapper mapper = new IceMapper(new IceMapper.ReturnMapping() {

            public Object mapReturnValue(IceMapper mapper, Object value)
                    throws UserException {
                return mapper.convert((ome.system.EventContext) value);
            }
        });

        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        return store.getSF().getAdminService()
                                .getEventContext();
                    }
                }));
    }
    
    // ~ Service methods
    // =========================================================================

    public void setPlaneInfo_async(
            final AMD_MetadataStore_setPlaneInfo __cb,
            final PlaneInfo planeInfo, final int imageIndex, 
            final int pixelsIndex, final int planeIndex,
            final Current __current) throws ServerError
    {
        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setPlaneTheC(planeInfo.getTheC().getValue(), imageIndex, 
                                pixelsIndex, planeIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorSettingsBinning_async(
            AMD_MetadataStore_setDetectorSettingsBinning __cb, 
            final RString binning, final int imageIndex, 
            final int logicalChannelIndex, Current __current)
            throws ServerError
    {
        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorSettingsBinning(binning.getValue(),
                                                         imageIndex,
                                                         logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorSettingsReadOutRate_async(
            AMD_MetadataStore_setDetectorSettingsReadOutRate __cb,
            final RFloat readOutRate, final int imageIndex, 
            final int logicalChannelIndex,
            Current __current) throws ServerError
    {
        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorSettingsReadOutRate(
                                readOutRate.getValue(), imageIndex,
                                logicalChannelIndex);
                        return null;
                    }
                }));
    }

    public void setDetectorSettingsVoltage_async(
            AMD_MetadataStore_setDetectorSettingsVoltage __cb,
            final RFloat voltage, final int imageIndex, 
            final int logicalChannelIndex, Current __current)
            throws ServerError
    {
        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setDetectorSettingsVoltage(voltage.getValue(),
                                                         imageIndex,
                                                         logicalChannelIndex);
                        return null;
                    }
                }));
    }
    
    public void setObjectiveSettingsCorrectionCollar_async(
            AMD_MetadataStore_setObjectiveSettingsCorrectionCollar __cb,
            final RFloat correctionCollar, final int imageIndex,
            Current __current)
            throws ServerError
    {
        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveSettingsCorrectionCollar(
                                correctionCollar.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveSettingsMedium_async(
            AMD_MetadataStore_setObjectiveSettingsMedium __cb, 
            final RString medium, final int imageIndex, 
            Current __current) throws ServerError
    {
        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveSettingsMedium(medium.getValue(),
                                                         imageIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveSettingsObjective_async(
            AMD_MetadataStore_setObjectiveSettingsObjective __cb,
            final RString objective, final int imageIndex, Current __current)
            throws ServerError
    {
        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveSettingsObjective(
                                objective.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

    public void setObjectiveSettingsRefractiveIndex_async(
            AMD_MetadataStore_setObjectiveSettingsRefractiveIndex __cb,
            final RFloat refractiveIndex, final int imageIndex,
            Current __current)
            throws ServerError
    {
        final IceMapper mapper = new IceMapper(IceMapper.VOID);
        runnableCall(__current, new Adapter(__cb, __current, mapper,
                this.sf.executor, this.sf.principal, new Executor.Work() {
                    public Object doWork(TransactionStatus status,
                            Session session, ServiceFactory sf) {

                        store.setObjectiveSettingsRefractiveIndex(
                                refractiveIndex.getValue(), imageIndex);
                        return null;
                    }
                }));
    }

}
