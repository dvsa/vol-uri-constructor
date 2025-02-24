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
    PREPRODUCTION("prep"),
    PRODUCTION("prod"),
    LOCAL("local");

    private final String name;

    EnvironmentType(@NotNull String name) {
        this.name = name;
    }

    public static EnvironmentType getEnum(@NotNull String env) {
        return switch (env.toLowerCase()) {
            case "qa" -> EnvironmentType.QUALITY_ASSURANCE;
            case "dev" -> EnvironmentType.DEVELOP;
            case "da" -> EnvironmentType.DAILY_ASSURANCE;
            case "int" -> EnvironmentType.INTEGRATION;
            case "reg" -> EnvironmentType.REGRESSION;
            case "prep" -> EnvironmentType.PREPRODUCTION;
            case "prod" -> EnvironmentType.PRODUCTION;
            case "prodsupp" -> EnvironmentType.PROD_SUPP;
            case "demo" -> EnvironmentType.DEMO;
            case "local" -> EnvironmentType.LOCAL;
            default -> throw new IllegalArgumentException(String.format("[ERROR] %s does not match up to any environment", env));
        };
    }

    public static String name(@NotNull ApplicationType appType, @NotNull EnvironmentType env) {
        return switch (env) {
            case QUALITY_ASSURANCE -> "qa";
            case DEVELOP -> "dev";
            case DAILY_ASSURANCE -> "da";
            case INTEGRATION -> "int";
            case REGRESSION -> "reg";
            case PROD_SUPP -> "prodsupp";
            case PREPRODUCTION -> "prep";
            case DEMO -> "demo";
            case LOCAL -> "local";
            case PRODUCTION -> {
                if (appType.equals(ApplicationType.INTERNAL)) {
                    yield "prod";
                } else {
                    throw new IllegalArgumentException("[ERROR] The external(self serve) production app does not contain an environment name.");
                }
            }
            default -> throw new IllegalArgumentException(String.format("unable to handle application type of %s and/or environment of type %s. ", appType, env));
        };
    }

    @Override
    public final String toString() {
        return this.name;
    }
}