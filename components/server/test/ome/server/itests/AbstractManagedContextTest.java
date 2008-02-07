/*
 *   $Id$
 *
 *   Copyright 2006 University of Dundee. All rights reserved.
 *   Use is subject to license terms supplied in LICENSE.txt
 */
package ome.server.itests;

import java.util.UUID;

import javax.sql.DataSource;

import ome.api.IAnalysis;
import ome.api.IConfig;
import ome.api.IPixels;
import ome.api.IPojos;
import ome.api.local.LocalAdmin;
import ome.api.local.LocalLdap;
import ome.api.local.LocalQuery;
import ome.api.local.LocalUpdate;
import ome.model.meta.Experimenter;
import ome.model.meta.ExperimenterGroup;
import ome.model.meta.Session;
import ome.security.SecuritySystem;
import ome.services.sessions.SessionManager;
import ome.system.OmeroContext;
import ome.system.Principal;
import ome.system.Roles;
import ome.system.ServiceFactory;
import ome.testing.OMEData;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.testng.annotations.Configuration;
import org.testng.annotations.Test;

@Test(groups = { "integration" })
public class AbstractManagedContextTest extends
        AbstractDependencyInjectionSpringContextTests {

    // ~ Testng Adapter
    // =========================================================================
    @Configuration(beforeTestMethod = true)
    public void adaptSetUp() throws Exception {
        setUp();
    }

    @Configuration(afterTestMethod = true)
    public void adaptTearDown() throws Exception {
        tearDown();
    }

    // =========================================================================

    protected ServiceFactory factory;

    protected LocalQuery iQuery;

    protected LocalUpdate iUpdate;

    protected LocalAdmin iAdmin;

    protected LocalLdap iLdap;

    protected IConfig iConfig;

    protected IAnalysis iAnalysis;

    protected IPojos iPojos;

    protected IPixels iPixels;

    protected OMEData data;

    protected JdbcTemplate jdbcTemplate;

    protected LdapTemplate ldapTemplate;

    protected HibernateTemplate hibernateTemplate;

    protected SecuritySystem securitySystem;

    protected Roles roles;

    protected SessionManager sessionManager;

    /**
     * @see org.springframework.test.AbstractDependencyInjectionSpringContextTests#onSetUp()
     */
    @Override
    protected void onSetUp() throws Exception {
        this.applicationContext = createApplicationContext(null);
        factory = new ServiceFactory((OmeroContext) applicationContext);
        iQuery = (LocalQuery) factory.getQueryService();
        iUpdate = (LocalUpdate) factory.getUpdateService();
        iAdmin = (LocalAdmin) factory.getAdminService();
        iLdap = (LocalLdap) factory.getLdapService();
        iAnalysis = factory.getAnalysisService();
        iConfig = factory.getConfigService();
        iPojos = factory.getPojosService();
        iPixels = factory.getPixelsService();

        DataSource dataSource = (DataSource) applicationContext
                .getBean("dataSource");
        jdbcTemplate = (JdbcTemplate) applicationContext
                .getBean("jdbcTemplate");

        ldapTemplate = (LdapTemplate) applicationContext
                .getBean("ldapTemplate");

        data = new OMEData();
        data.setDataSource(dataSource);

        hibernateTemplate = (HibernateTemplate) applicationContext
                .getBean("hibernateTemplate");

        securitySystem = (SecuritySystem) applicationContext
                .getBean("securitySystem");
        roles = securitySystem.getSecurityRoles();
        sessionManager = (SessionManager) applicationContext
                .getBean("sessionManager");
        loginRoot();

    }

    protected void loginRoot() {

        login(roles.getRootName(), roles.getSystemGroupName(), "Test");

    }

    public Experimenter loginNewUser() {
        loginRoot();
        String guid = uuid();
        ExperimenterGroup group = new ExperimenterGroup();
        group.setName(guid);
        iAdmin.createGroup(group);

        String uuid = uuid();
        Experimenter e = new Experimenter();
        e.setFirstName("New");
        e.setLastName("User");
        e.setOmeName(uuid);

        long uid = iAdmin.createUser(e, guid);
        loginUser(uuid);

        return iQuery.get(Experimenter.class, uid);
    }

    protected void loginUser(String omeName) {
        login(omeName, roles.getUserGroupName(), "Test");
    }

    @Override
    protected ConfigurableApplicationContext createApplicationContext(
            String[] locations) {
        return OmeroContext.getManagedServerContext();
    }

    protected void login(String userName, String groupName, String eventType) {
        Principal p = new Principal(userName, groupName, eventType);
        Session s = sessionManager.create(p);
        p = new Principal(s.getUuid(), groupName, eventType);
        securitySystem.login(p);
    }

    protected String uuid() {
        return UUID.randomUUID().toString();
    }

}
