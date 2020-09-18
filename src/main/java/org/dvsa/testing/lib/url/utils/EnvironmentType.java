package org.dvsa.testing.lib.url.utils;

import org.dvsa.testing.lib.url.webapp.utils.ApplicationType;
import org.jetbrains.annotations.NotNull;

public enum EnvironmentType {

    QUALITY_ASSURANCE("qa"),
    PROD_SUPP("prodsupp"),
    DAILY_ASSURANCE("da"),
    DEMO("demo"),
    DEVELOP("dev"),
    REGRESSION("reg"),
    INTEGRATION("int"),
    PREPRODUCTION("pre"),
    PRODUCTION("prod"),
    LOCAL("local");

    private String name;

    EnvironmentType(@NotNull String name) {
        this.name = name;
    }

    public static EnvironmentType getEnum(@NotNull String env) {
        EnvironmentType envEnum;

        switch (env.toLowerCase()) {
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
            case "pre":
                envEnum = EnvironmentType.PREPRODUCTION;
                break;
            case "prod":
                envEnum = EnvironmentType.PRODUCTION;
                break;
            case "prodsupp":
                envEnum = EnvironmentType.PROD_SUPP;
                break;
            case "demo":
                envEnum = EnvironmentType.DEMO;
                break;
            case "local":
                envEnum = EnvironmentType.LOCAL;
                break;
            default:
                throw new IllegalArgumentException(String.format("[ERROR] %s does not match up to any environment"));
        }
        return envEnum;
    }

    public static String name(@NotNull ApplicationType appType, @NotNull EnvironmentType env) {
        String name;

        switch (env) {
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
            case PROD_SUPP:
                name = "prodsupp";
                break;
            case PREPRODUCTION:
                name = "pre";
                break;
            case DEMO:
                name = "demo";
                break;
            case LOCAL:
                name = "local";
                break;
            case PRODUCTION:
                if (appType.equals(ApplicationType.INTERNAL)) {
                    name = "prod";
                } else {
                    throw new IllegalArgumentException("[ERROR] The external(self serve) production app does not contain an environment name.");
                }
                break;
            default:
                throw new IllegalArgumentException(String.format("unable to handle application type of %s and/or environment of type %s.", appType, env));
        }

        return name;
    }

    @Override
    public final String toString() {
        return this.name;
    }

}
