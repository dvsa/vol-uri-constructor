package org.dvsa.testing.lib;

import org.dvsa.testing.lib.utils.ApplicationType;
import org.dvsa.testing.lib.utils.EnvironmentType;

public class URI {
    private static String scheme = "https";

    public static String build(ApplicationType appType, EnvironmentType env, String endPoint){
        String domain;
        if(appType == ApplicationType.EXTERNAL && env == EnvironmentType.PRODUCTION){
            domain = String.format("%s://www.vehicle-operator-licensing.service.gov.uk/%s", getScheme(), endPoint);
        } else {
            String nonProdSection = (env == EnvironmentType.PRODUCTION ) ? "" : ".nonprod";
            domain = String.format("%s://%s.olcs.%s%s.dvsa.aws/%s", getScheme(), appName(appType), Environment.name(appType, env), nonProdSection, endPoint);
        }
        return domain;
    }

    public static String build(ApplicationType appType, EnvironmentType env){
        String endPoint = "";
        return URI.build(appType, env, endPoint);
    }

    private static String appName(ApplicationType appType){
        return (appType == ApplicationType.INTERNAL) ? "iuap1" : "ssap1";
    }

    private static String getScheme() {
        return scheme;
    }
}