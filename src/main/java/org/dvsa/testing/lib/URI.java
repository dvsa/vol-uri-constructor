package org.dvsa.testing.lib;

import com.sun.istack.internal.NotNull;
import org.dvsa.testing.lib.utils.ApplicationType;
import org.dvsa.testing.lib.utils.Environment;

public class URI {
    private static String scheme = "https";

    public static String build(ApplicationType appType, Environment env, String endPoint){
        String domain = null;
        if(appType == ApplicationType.EXTERNAL && env == Environment.PRODUCTION){
            domain = String.format("%s://www.vehicle-operator-licensing.service.gov.uk/%s", getScheme(), endPoint);
        } else {
            String nonProdSection = (env == Environment.PRODUCTION ) ? "" : ".nonprod";
            domain = String.format("%s://%s.olcs.%s%s.dvsa.aws/%s", getScheme(), appName(appType), envName(appType, env), nonProdSection, endPoint);
        }
        return domain;
    }

    public static String build(ApplicationType appType, Environment env){
        String endPoint = "";
        return URI.build(appType, env, endPoint);
    }

    private static String appName(ApplicationType appType){
        return (appType == ApplicationType.INTERNAL) ? "iuap1" : "ssap1";
    }

    private static String envName(ApplicationType appType, Environment env){
        String envName = null;
        switch(env){
            case QUALITY_ASSURANCE:
                envName = "qa";
                break;
            case DEVELOP:
                envName = "dev";
                break;
            case DAILY_ASSURANCE:
                envName = "da";
                break;
            case REGRESSION:
                envName = "reg";
                break;
            case PRODUCTION:
                if(appType.equals(ApplicationType.INTERNAL)){
                    envName = "prod";
                } else {
                    throw new IllegalArgumentException("The external(self serve) production app does not contain an environment name.");
                }
                break;
            default:
                throw new IllegalArgumentException(String.format("unable to handle application type of %s and/or environment of type %s.", appType, env));
        }
        return envName;
    }

    private static Environment envEnum(@NotNull String env){
        Environment envEnum = null;
        switch(env){
            case "qa":
                envEnum = Environment.QUALITY_ASSURANCE;
                break;
            case "dev":
                envEnum = Environment.DEVELOP;
                break;
            case "da":
                envEnum = Environment.DAILY_ASSURANCE;
                break;
            case "reg":
                envEnum = Environment.REGRESSION;
                break;
            case "prod":
                envEnum = Environment.PRODUCTION;
                break;
            default:
                throw new IllegalArgumentException(String.format("%s does not match up to any environment"));
        }
        return envEnum;
    }

    private static String getScheme() {
        return scheme;
    }
}