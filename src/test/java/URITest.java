import org.dvsa.testing.lib.uri.URI;
import org.junit.Assert;
import org.junit.Test;
import org.dvsa.testing.lib.uri.utils.ApplicationType;
import org.dvsa.testing.lib.uri.utils.EnvironmentType;

public class URITest {

    @Test
    public void createInternalDailyAssuranceDomain(){
        String actualDomain = "https://iuap1.olcs.da.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.INTERNAL, EnvironmentType.DAILY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalDailyAssuranceDomain(){
        String actualDomain = "https://ssap1.olcs.da.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.EXTERNAL, EnvironmentType.DAILY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalProductionDomain(){
        String actualDomain = "https://www.vehicle-operator-licensing.service.gov.uk/";
        String expectedDomain = URI.build(ApplicationType.EXTERNAL, EnvironmentType.PRODUCTION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalProductionDomain(){
        String actualDomain = "https://iuap1.olcs.prod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.INTERNAL, EnvironmentType.PRODUCTION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalQualityAssuranceDomain(){
        String actualDomain = "https://ssap1.olcs.qa.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.EXTERNAL, EnvironmentType.QUALITY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalQualityAssuranceDomain(){
        String actualDomain = "https://iuap1.olcs.qa.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.INTERNAL, EnvironmentType.QUALITY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalDevelopDomain(){
        String actualDomain = "https://ssap1.olcs.dev.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.EXTERNAL, EnvironmentType.DEVELOP);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalDevelopDomain(){
        String actualDomain = "https://iuap1.olcs.dev.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.INTERNAL, EnvironmentType.DEVELOP);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalRegressionDomain(){
        String actualDomain = "https://ssap1.olcs.reg.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.EXTERNAL, EnvironmentType.REGRESSION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalRegressionDomain(){
        String actualDomain = "https://iuap1.olcs.reg.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.INTERNAL, EnvironmentType.REGRESSION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void updatesTheURLPath(){
        String URL = URI.build(ApplicationType.EXTERNAL, EnvironmentType.PRODUCTION);

        String actualURL = URL + "auth/login/";
        String expectedURL = URI.updatePath(URL + "register", "auth/login/");

        Assert.assertEquals(expectedURL, actualURL);
    }

    @Test
    public void appendsPathToTheUrl(){
        String URL = URI.build(ApplicationType.EXTERNAL, EnvironmentType.PRODUCTION);

        String actualURL = URL + "auth/login/";
        String expectedURL = URI.updatePath(URL + "register", "auth/login/");

        Assert.assertEquals(expectedURL, actualURL);
    }

}
