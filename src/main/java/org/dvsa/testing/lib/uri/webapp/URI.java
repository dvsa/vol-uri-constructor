package org.dvsa.testing.lib.uri.webapp;

import org.dvsa.testing.lib.uri.URIBase;
import org.dvsa.testing.lib.uri.webapp.utils.ApplicationType;
import org.dvsa.testing.lib.uri.webapp.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;

public class URI extends URIBase {

    public static URL build(@NotNull ApplicationType appType, @NotNull String env, @NotNull String endPoint) throws MalformedURLException {
        return build(appType, EnvironmentType.getEnum(env), endPoint);
    }

    public static URL build(@NotNull ApplicationType appType, @NotNull String env) throws MalformedURLException {
        return build(appType, EnvironmentType.getEnum(env));
    }

    public static java.net.URL build(ApplicationType appType, EnvironmentType env, String endPoint) throws MalformedURLException {
        String domain;
        if(appType == ApplicationType.EXTERNAL && env == EnvironmentType.PRODUCTION){
            domain = String.format("https://www.vehicle-operator-licensing.service.gov.uk/%s", endPoint);
        } else {
            String nonProdSection = (env == EnvironmentType.PRODUCTION ) ? "" : ".nonprod";
            domain = String.format("https://%s.olcs.%s%s.dvsa.aws/%s", appName(appType), EnvironmentType.name(appType, env), nonProdSection, endPoint);
        }

        setURL(domain);

        return getURL();
    }

    public static URL build(ApplicationType appType, EnvironmentType env) throws MalformedURLException {
        String endPoint = "";
        return URI.build(appType, env, endPoint);
    }

    private static String appName(ApplicationType appType){
        return (appType == ApplicationType.INTERNAL) ? "iuap1" : "ssap1";
    }

}