package org.dvsa.testing.lib;

import org.dvsa.testing.lib.utils.ApplicationType;
import org.dvsa.testing.lib.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static String updatePath(@NotNull String URL, @NotNull String path){
        String regex = "(?:(?<=\\.aws\\/)|(?<=\\.uk\\/))[\\w\\/]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(URL);

        if(matcher.find()){
            return URL.replaceAll(regex, path);
        } else {
            path = URL.endsWith("/") ? path : "/" + path;
        }

        return URL.replaceAll(regex, path);
    }

    private static String appName(ApplicationType appType){
        return (appType == ApplicationType.INTERNAL) ? "iuap1" : "ssap1";
    }

    private static String getScheme() {
        return scheme;
    }
}