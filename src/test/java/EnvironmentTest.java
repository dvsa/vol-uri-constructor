import org.dvsa.testing.lib.Environment;
import org.dvsa.testing.lib.utils.ApplicationType;
import org.dvsa.testing.lib.utils.EnvironmentType;
import org.junit.Assert;
import org.junit.Test;

public class EnvironmentTest {

    @Test
    public void returnQAEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.QUALITY_ASSURANCE;
        EnvironmentType actualEnvironment = Environment.enumType("qa");

        Assert.assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnDAEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.DAILY_ASSURANCE;
        EnvironmentType actualEnvironment = Environment.enumType("da");

        Assert.assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnDevelopEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.DEVELOP;
        EnvironmentType actualEnvironment = Environment.enumType("dev");

        Assert.assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnRegressionEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.REGRESSION;
        EnvironmentType actualEnvironment = Environment.enumType("reg");

        Assert.assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnProductionEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.PRODUCTION;
        EnvironmentType actualEnvironment = Environment.enumType("prod");

        Assert.assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnsQAName(){
        String expectedName = "qa";
        String actualName = Environment.name(EnvironmentType.QUALITY_ASSURANCE);

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsDevelopName(){
        String expectedName = "dev";
        String actualName = Environment.name(EnvironmentType.DEVELOP);

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsDailyAssuranceName(){
        String expectedName = "da";
        String actualName = Environment.name(EnvironmentType.DAILY_ASSURANCE);

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsRegressionName(){
        String expectedName = "reg";
        String actualName = Environment.name(EnvironmentType.REGRESSION);

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsProductionName(){
        String expectedName = "prod";
        String actualName = Environment.name(EnvironmentType.PRODUCTION);

        Assert.assertEquals(expectedName, actualName);
    }

}
