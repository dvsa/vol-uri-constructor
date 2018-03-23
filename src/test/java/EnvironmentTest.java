import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.junit.Assert;
import org.junit.Test;

public class EnvironmentTest {

    @Test
    public void returnQAEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.QUALITY_ASSURANCE;
        EnvironmentType actualEnvironment = EnvironmentType.getEnum("qa");

        Assert.assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnDAEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.DAILY_ASSURANCE;
        EnvironmentType actualEnvironment = EnvironmentType.getEnum("da");

        Assert.assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnDevelopEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.DEVELOP;
        EnvironmentType actualEnvironment = EnvironmentType.getEnum("dev");

        Assert.assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnRegressionEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.REGRESSION;
        EnvironmentType actualEnvironment = EnvironmentType.getEnum("reg");

        Assert.assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnProductionEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.PRODUCTION;
        EnvironmentType actualEnvironment = EnvironmentType.getEnum("prod");

        Assert.assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnsQAName(){
        String expectedName = "qa";
        String actualName = EnvironmentType.QUALITY_ASSURANCE.toString();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsDevelopName(){
        String expectedName = "dev";
        String actualName = EnvironmentType.DEVELOP.toString();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsDailyAssuranceName(){
        String expectedName = "da";
        String actualName = EnvironmentType.DAILY_ASSURANCE.toString();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsRegressionName(){
        String expectedName = "reg";
        String actualName = EnvironmentType.REGRESSION.toString();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsProductionName(){
        String expectedName = "prod";
        String actualName = EnvironmentType.PRODUCTION.toString();

        Assert.assertEquals(expectedName, actualName);
    }

}
