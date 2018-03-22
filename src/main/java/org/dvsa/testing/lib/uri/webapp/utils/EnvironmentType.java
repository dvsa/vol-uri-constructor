package org.dvsa.testing.lib.uri.webapp.utils;

import activesupport.system.out.Output;
import org.jetbrains.annotations.NotNull;

public enum EnvironmentType {

    QUALITY_ASSURANCE("qa"),
    DAILY_ASSURANCE("da"),
    DEVELOP("dev"),
    REGRESSION("reg"),
    INTEGRATION("int"),
    PRODUCTION("prod");

    private String name;

    EnvironmentType(@NotNull String name) {
        this.name = name;
    }

    public static EnvironmentType getEnum(@NotNull String env){
        EnvironmentType envEnum;

        switch(env.toLowerCase()){
            case "qa":
                envEnum = EnvironmentType.QUALITY_ASSURANCE;
                break;
            case "dev":
                envEnum = EnvironmentType.DEVELOP;
                break;
            case "da":
                envEnum = EnvironmentType.DAILY_ASSURANCE;
                break;
            case "int":
                envEnum = EnvironmentType.INTEGRATION;
                break;
            case "reg":
                envEnum = EnvironmentType.REGRESSION;
                break;
            case "prod":
                envEnum = EnvironmentType.PRODUCTION;
                break;
            default:
                throw new IllegalArgumentException(Output.printColoredLog(String.format("[ERROR] %s does not match up to any environment")));
        }
        return envEnum;
    }

    public static String name(@NotNull ApplicationType appType, @NotNull EnvironmentType env){
        String name;

        switch(env){
            case QUALITY_ASSURANCE:
                name = "qa";
                break;
            case DEVELOP:
                name = "dev";
                break;
            case DAILY_ASSURANCE:
                name = "da";
                break;
            case INTEGRATION:
                name = "int";
                break;
            case REGRESSION:
                name = "reg";
                break;
            case PRODUCTION:
                if(appType.equals(ApplicationType.INTERNAL)){
                    name = "prod";
                } else {
                    throw new IllegalArgumentException(Output.printColoredLog("[ERROR] The external(self serve) production app does not contain an environment name."));
                }
                break;
            default:
                throw new IllegalArgumentException(Output.printColoredLog(String.format("unable to handle application type of %s and/or environment of type %s.", appType, env)));
        }

        return name;
    }

    @Override
    public final String toString() {
        return this.name;
    }

}
