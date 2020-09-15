package org.dvsa.testing.lib.url.webapp;

import org.dvsa.testing.lib.url.URLBase;
import org.dvsa.testing.lib.url.webapp.utils.ApplicationType;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;

public class URL extends URLBase {

    public static java.net.URL build(@NotNull ApplicationType appType, @NotNull String env, @NotNull String endPoint) {
        return build(appType, EnvironmentType.getEnum(env), endPoint);
    }

    public static java.net.URL build(@NotNull ApplicationType appType, @NotNull String env) {
        return build(appType, EnvironmentType.getEnum(env));
    }

    public static java.net.URL build(ApplicationType appType, EnvironmentType env, String endPoint) {
        String domain;
        if (appType == ApplicationType.EXTERNAL && env == EnvironmentType.PRODUCTION) {
            domain = String.format("https://www.vehicle-operator-licensing.service.gov.uk/%s", endPoint);
        } else if (appType == ApplicationType.EXTERNAL && env == EnvironmentType.LOCAL) {
            domain = String.format("http://olcs-selfserve.olcs.gov.uk/auth/login/%s", endPoint);
        } else if (appType == ApplicationType.INTERNAL && env == EnvironmentType.LOCAL) {
            domain = String.format("http://olcs-internal.olcs.gov.uk/%s", endPoint);
        } else {
            if (appType == ApplicationType.EXTERNAL){
                String prodOrNonProd = (env == EnvironmentType.INTEGRATION || env == EnvironmentType.PREPRODUCTION) ? ".prod" : ".nonprod";
                domain = String.format("https://ssap1.olcs.%s%s.dvsa.aws/%s", EnvironmentType.name(appType, env), prodOrNonProd, endPoint);
            } else {
                String prodOrNonProd = (env == EnvironmentType.INTEGRATION || env == EnvironmentType.PREPRODUCTION) ? "" : "dev-";
                domain = String.format("https://iuap1.%s.olcs.%sdvsacloud.uk/%s", EnvironmentType.name(appType, env), prodOrNonProd, endPoint);
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