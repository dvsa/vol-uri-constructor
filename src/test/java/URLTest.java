import org.dvsa.testing.lib.url.webapp.URL;
import org.junit.Assert;
import org.junit.Test;
import org.dvsa.testing.lib.url.webapp.utils.ApplicationType;
import org.dvsa.testing.lib.url.utils.EnvironmentType;

import java.net.MalformedURLException;

public class URLTest {

    @Test
    public void apiLocalDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("http://olcs-backend/api/");
        java.net.URL expectedDomain = org.dvsa.testing.lib.url.api.URL.build(EnvironmentType.LOCAL);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalDailyAssuranceDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://iuap1.olcs.da.nonprod.dvsa.aws/");
        java.net.URL expectedDomain = URL.build(ApplicationType.INTERNAL, EnvironmentType.DAILY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalDailyAssuranceDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://ssap1.olcs.da.nonprod.dvsa.aws/");
        java.net.URL expectedDomain = URL.build(ApplicationType.EXTERNAL, EnvironmentType.DAILY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalProductionDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://www.vehicle-operator-licensing.service.gov.uk/");
        java.net.URL expectedDomain = URL.build(ApplicationType.EXTERNAL, EnvironmentType.PRODUCTION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalProductionDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://iuap1.olcs.prod.dvsa.aws/");
        java.net.URL expectedDomain = URL.build(ApplicationType.INTERNAL, EnvironmentType.PRODUCTION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalQualityAssuranceDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://ssap1.olcs.qa.nonprod.dvsa.aws/");
        java.net.URL expectedDomain = URL.build(ApplicationType.EXTERNAL, EnvironmentType.QUALITY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalQualityAssuranceDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://iuap1.olcs.qa.nonprod.dvsa.aws/");
        java.net.URL expectedDomain = URL.build(ApplicationType.INTERNAL, EnvironmentType.QUALITY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalDevelopDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://ssap1.olcs.dev.nonprod.dvsa.aws/");
        java.net.URL expectedDomain = URL.build(ApplicationType.EXTERNAL, EnvironmentType.DEVELOP);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalDevelopDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://iuap1.olcs.dev.nonprod.dvsa.aws/");
        java.net.URL expectedDomain = URL.build(ApplicationType.INTERNAL, EnvironmentType.DEVELOP);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalLocalDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("http://olcs-internal.olcs.gov.uk/");
        java.net.URL expectedDomain = URL.build(ApplicationType.INTERNAL, EnvironmentType.LOCAL);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalLocalDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("http://olcs-selfserve.olcs.gov.uk/auth/login/");
        java.net.URL expectedDomain = URL.build(ApplicationType.EXTERNAL, EnvironmentType.LOCAL);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalRegressionDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://ssap1.olcs.reg.nonprod.dvsa.aws/");
        java.net.URL expectedDomain = URL.build(ApplicationType.EXTERNAL, EnvironmentType.REGRESSION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalRegressionDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://iuap1.olcs.reg.nonprod.dvsa.aws/");
        java.net.URL expectedDomain = URL.build(ApplicationType.INTERNAL, EnvironmentType.REGRESSION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void updatesTheURLPath() throws MalformedURLException {
        URL.build(ApplicationType.EXTERNAL, EnvironmentType.PRODUCTION, "register");

        java.net.URL actualURL = new java.net.URL("https://www.vehicle-operator-licensing.service.gov.uk/auth/login/");
        java.net.URL expectedURL = URL.updatePath("auth/login/");

        Assert.assertEquals(expectedURL, actualURL);
    }

    @Test
    public void appendsPathToTheUrl() throws MalformedURLException {
        java.net.URL URL = org.dvsa.testing.lib.url.webapp.URL.build(ApplicationType.EXTERNAL, EnvironmentType.PRODUCTION, "register");

        java.net.URL actualURL = new java.net.URL("https://www.vehicle-operator-licensing.service.gov.uk/auth/login/");
        java.net.URL expectedURL = org.dvsa.testing.lib.url.webapp.URL.updatePath("auth/login/");

        Assert.assertEquals(expectedURL, actualURL);
    }

}
