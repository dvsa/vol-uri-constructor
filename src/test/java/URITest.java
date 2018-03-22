import org.dvsa.testing.lib.uri.webapp.URI;
import org.junit.Assert;
import org.junit.Test;
import org.dvsa.testing.lib.uri.webapp.utils.ApplicationType;
import org.dvsa.testing.lib.uri.webapp.utils.EnvironmentType;

import java.net.MalformedURLException;
import java.net.URL;

public class URITest {

    @Test
    public void createInternalDailyAssuranceDomain() throws MalformedURLException {
        URL actualDomain = new URL("https://iuap1.olcs.da.nonprod.dvsa.aws/");
        URL expectedDomain = URI.build(ApplicationType.INTERNAL, EnvironmentType.DAILY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalDailyAssuranceDomain() throws MalformedURLException {
        URL actualDomain = new URL("https://ssap1.olcs.da.nonprod.dvsa.aws/");
        URL expectedDomain = URI.build(ApplicationType.EXTERNAL, EnvironmentType.DAILY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalProductionDomain() throws MalformedURLException {
        URL actualDomain = new URL("https://www.vehicle-operator-licensing.service.gov.uk/");
        URL expectedDomain = URI.build(ApplicationType.EXTERNAL, EnvironmentType.PRODUCTION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalProductionDomain() throws MalformedURLException {
        URL actualDomain = new URL("https://iuap1.olcs.prod.dvsa.aws/");
        URL expectedDomain = URI.build(ApplicationType.INTERNAL, EnvironmentType.PRODUCTION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalQualityAssuranceDomain() throws MalformedURLException {
        URL actualDomain = new URL("https://ssap1.olcs.qa.nonprod.dvsa.aws/");
        URL expectedDomain = URI.build(ApplicationType.EXTERNAL, EnvironmentType.QUALITY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalQualityAssuranceDomain() throws MalformedURLException {
        URL actualDomain = new URL("https://iuap1.olcs.qa.nonprod.dvsa.aws/");
        URL expectedDomain = URI.build(ApplicationType.INTERNAL, EnvironmentType.QUALITY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalDevelopDomain() throws MalformedURLException {
        URL actualDomain = new URL("https://ssap1.olcs.dev.nonprod.dvsa.aws/");
        URL expectedDomain = URI.build(ApplicationType.EXTERNAL, EnvironmentType.DEVELOP);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalDevelopDomain() throws MalformedURLException {
        URL actualDomain = new URL("https://iuap1.olcs.dev.nonprod.dvsa.aws/");
        URL expectedDomain = URI.build(ApplicationType.INTERNAL, EnvironmentType.DEVELOP);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalRegressionDomain() throws MalformedURLException {
        URL actualDomain = new URL("https://ssap1.olcs.reg.nonprod.dvsa.aws/");
        URL expectedDomain = URI.build(ApplicationType.EXTERNAL, EnvironmentType.REGRESSION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalRegressionDomain() throws MalformedURLException {
        URL actualDomain = new URL("https://iuap1.olcs.reg.nonprod.dvsa.aws/");
        URL expectedDomain = URI.build(ApplicationType.INTERNAL, EnvironmentType.REGRESSION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void updatesTheURLPath() throws MalformedURLException {
        URI.build(ApplicationType.EXTERNAL, EnvironmentType.PRODUCTION, "register");

        URL actualURL = new URL("https://www.vehicle-operator-licensing.service.gov.uk/auth/login/");
        URL expectedURL = URI.updatePath("auth/login/");

        Assert.assertEquals(expectedURL, actualURL);
    }

    @Test
    public void appendsPathToTheUrl() throws MalformedURLException {
        URL URL = URI.build(ApplicationType.EXTERNAL, EnvironmentType.PRODUCTION, "register");

        URL actualURL = new URL("https://www.vehicle-operator-licensing.service.gov.uk/auth/login/");
        URL expectedURL = URI.updatePath("auth/login/");

        Assert.assertEquals(expectedURL, actualURL);
    }

}
