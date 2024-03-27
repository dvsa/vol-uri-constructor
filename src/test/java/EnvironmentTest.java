import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnvironmentTest {

    @Test
    public void returnQAEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.QUALITY_ASSURANCE;
        EnvironmentType actualEnvironment = EnvironmentType.getEnum("qa");

        assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnDAEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.DAILY_ASSURANCE;
        EnvironmentType actualEnvironment = EnvironmentType.getEnum("da");

        assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnDevelopEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.DEVELOP;
        EnvironmentType actualEnvironment = EnvironmentType.getEnum("dev");

        assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnRegressionEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.REGRESSION;
        EnvironmentType actualEnvironment = EnvironmentType.getEnum("reg");

        assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnProductionEnvironmentEnum(){
        EnvironmentType expectedEnvironment = EnvironmentType.PRODUCTION;
        EnvironmentType actualEnvironment = EnvironmentType.getEnum("prod");

        assertEquals(expectedEnvironment, actualEnvironment);
    }

    @Test
    public void returnsQAName(){
        String expectedName = "qa";
        String actualName = EnvironmentType.QUALITY_ASSURANCE.toString();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsDevelopName(){
        String expectedName = "dev";
        String actualName = EnvironmentType.DEVELOP.toString();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsDailyAssuranceName(){
        String expectedName = "da";
        String actualName = EnvironmentType.DAILY_ASSURANCE.toString();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsRegressionName(){
        String expectedName = "reg";
        String actualName = EnvironmentType.REGRESSION.toString();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsProdSupportName(){
        String expectedName = "ps";
        String actualName = EnvironmentType.PROD_SUPP.toString();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsPreProductionName(){
        String expectedName = "pre";
        String actualName = EnvironmentType.PREPRODUCTION.toString();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsProductionName(){
        String expectedName = "prod";
        String actualName = EnvironmentType.PRODUCTION.toString();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void returnsLocalName(){
        String expectedName = "local";
        String actualName = EnvironmentType.LOCAL.toString();

        assertEquals(expectedName, actualName);
    }

}
