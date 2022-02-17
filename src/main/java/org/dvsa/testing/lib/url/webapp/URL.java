package org.dvsa.testing.lib.url.webapp;

import org.dvsa.testing.lib.url.URLBase;
import org.dvsa.testing.lib.url.webapp.utils.ApplicationType;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;

import static org.dvsa.testing.lib.url.utils.EnvironmentType.*;

public class URL extends URLBase {

    public static java.net.URL build(@NotNull ApplicationType appType, @NotNull String env, @NotNull String endPoint) {
        return build(appType, getEnum(env), endPoint);
    }

    public static java.net.URL build(@NotNull ApplicationType appType, @NotNull String env) {
        return build(appType, getEnum(env));
    }

    public static java.net.URL build(ApplicationType appType, EnvironmentType env, String endPoint) {
        String domain;
        if (appType == ApplicationType.EXTERNAL && env == PRODUCTION) {
            domain = String.format("https://www.vehicle-operator-licensing.service.gov.uk/%s", endPoint);
        } else if (appType == ApplicationType.EXTERNAL && env == LOCAL) {
            domain = String.format("http://olcs-selfserve.olcs.gov.uk/auth/login/%s", endPoint);
        } else if (appType == ApplicationType.INTERNAL && env == LOCAL) {
            domain = String.format("http://olcs-internal.olcs.gov.uk/%s", endPoint);
        } else {
            if (appType == ApplicationType.EXTERNAL){
                String prodOrNonProd = (env == INTEGRATION || env == PREPRODUCTION) ? "" : "dev-";
                    domain = String.format("https://ssweb.%s.olcs.%sdvsacloud.uk/%s", name(appType, env), prodOrNonProd, endPoint);
            } else {
                String prodOrNonProd = (env == INTEGRATION || env == PREPRODUCTION || env == PRODUCTION) ? "" : "dev-";
                    domain = String.format("https://iuweb.%s.olcs.%sdvsacloud.uk/%s", name(appType, env), prodOrNonProd, endPoint);
            }
        }

        setURL(domain);

        return getURL();
    }

    public static java.net.URL build(ApplicationType appType, EnvironmentType env) {
        String endPoint = "";
        return org.dvsa.testing.lib.url.webapp.URL.build(appType, env, endPoint);
    }

    private static String appName(ApplicationType appType) {
        return (appType == ApplicationType.INTERNAL) ? "iuap1" : "ssap1";
    }
}