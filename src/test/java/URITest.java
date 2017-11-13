import org.junit.Assert;
import org.junit.Test;
import utils.ApplicationType;
import utils.Environment;

public class URITest {

    @Test
    public void createInternalDailyAssuranceDomain(){
        String actualDomain = "https://iuap1.olcs.da.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.INTERNAL, Environment.DAILY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalDailyAssuranceDomain(){
        String actualDomain = "https://ssap1.olcs.da.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.EXTERNAL, Environment.DAILY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalProductionDomain(){
        String actualDomain = "https://www.vehicle-operator-licensing.service.gov.uk/";
        String expectedDomain = URI.build(ApplicationType.EXTERNAL, Environment.PRODUCTION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalProductionDomain(){
        String actualDomain = "https://iuap1.olcs.prod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.INTERNAL, Environment.PRODUCTION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalQualityAssuranceDomain(){
        String actualDomain = "https://ssap1.olcs.qa.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.EXTERNAL, Environment.QUALITY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalQualityAssuranceDomain(){
        String actualDomain = "https://iuap1.olcs.qa.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.INTERNAL, Environment.QUALITY_ASSURANCE);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalDevelopDomain(){
        String actualDomain = "https://ssap1.olcs.dev.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.EXTERNAL, Environment.DEVELOP);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalDevelopDomain(){
        String actualDomain = "https://iuap1.olcs.dev.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.INTERNAL, Environment.DEVELOP);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalRegressionDomain(){
        String actualDomain = "https://ssap1.olcs.reg.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.EXTERNAL, Environment.REGRESSION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalRegressionDomain(){
        String actualDomain = "https://iuap1.olcs.reg.nonprod.dvsa.aws/";
        String expectedDomain = URI.build(ApplicationType.INTERNAL, Environment.REGRESSION);

        Assert.assertEquals(expectedDomain, actualDomain);
    }

}
