import org.dvsa.testing.lib.url.api.ApiUrl;
import org.dvsa.testing.lib.url.webapp.webAppURL;
import org.dvsa.testing.lib.url.webapp.utils.ApplicationType;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiUrlTest {

    @Test
    public void apiLocalDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("http://api.local.olcs.dev-dvsacloud.uk/api/");
        java.net.URL expectedDomain = ApiUrl.build(EnvironmentType.LOCAL);

        assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalProdSupDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://ssweb.prodsupp.olcs.dev-dvsacloud.uk/");
        java.net.URL expectedDomain = webAppURL.build(ApplicationType.EXTERNAL, EnvironmentType.PROD_SUPP);

        assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalProdSupDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://iuweb.prodsupp.olcs.dev-dvsacloud.uk/");
        java.net.URL expectedDomain = webAppURL.build(ApplicationType.INTERNAL, EnvironmentType.PROD_SUPP);

        assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalDailyAssuranceDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://ssweb.da.olcs.dev-dvsacloud.uk/");
        java.net.URL expectedDomain = webAppURL.build(ApplicationType.EXTERNAL, EnvironmentType.DAILY_ASSURANCE);

        assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalDailyAssuranceDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://iuweb.da.olcs.dev-dvsacloud.uk/");
        java.net.URL expectedDomain = webAppURL.build(ApplicationType.INTERNAL, EnvironmentType.DAILY_ASSURANCE);

        assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalIntegrationDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://ssweb.int.olcs.dvsacloud.uk/");
        java.net.URL expectedDomain = webAppURL.build(ApplicationType.EXTERNAL, EnvironmentType.INTEGRATION);

        assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalIntegrationDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://iuweb.int.olcs.dvsacloud.uk/");
        java.net.URL expectedDomain = webAppURL.build(ApplicationType.INTERNAL, EnvironmentType.INTEGRATION);

        assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalPreProductionDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://www.preview.vehicle-operator-licensing.service.gov.uk/");
        java.net.URL expectedDomain = webAppURL.build(ApplicationType.EXTERNAL, EnvironmentType.PREPRODUCTION);

        assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalPreProductionDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://iuweb.pre.olcs.dvsacloud.uk/");
        java.net.URL expectedDomain = webAppURL.build(ApplicationType.INTERNAL, EnvironmentType.PREPRODUCTION);

        assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalProductionDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://www.vehicle-operator-licensing.service.gov.uk/");
        java.net.URL expectedDomain = webAppURL.build(ApplicationType.EXTERNAL, EnvironmentType.PRODUCTION);

        assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalProductionDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("https://iuweb.prod.olcs.dvsacloud.uk/");
        java.net.URL expectedDomain = webAppURL.build(ApplicationType.INTERNAL, EnvironmentType.PRODUCTION);

        assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createExternalLocalDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("http://ssweb.local.olcs.dev-dvsacloud.uk/");
        java.net.URL expectedDomain = webAppURL.build(ApplicationType.EXTERNAL, EnvironmentType.LOCAL);

        assertEquals(expectedDomain, actualDomain);
    }

    @Test
    public void createInternalLocalDomain() throws MalformedURLException {
        java.net.URL actualDomain = new java.net.URL("http://iuweb.local.olcs.dev-dvsacloud.uk/");
        java.net.URL expectedDomain = webAppURL.build(ApplicationType.INTERNAL, EnvironmentType.LOCAL);

        assertEquals(expectedDomain, actualDomain);
    }
}