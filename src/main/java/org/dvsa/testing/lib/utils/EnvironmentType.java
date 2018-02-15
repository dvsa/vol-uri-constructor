package org.dvsa.testing.lib.utils;

import org.jetbrains.annotations.NotNull;

public enum EnvironmentType {
    QUALITY_ASSURANCE("qa"),
    DAILY_ASSURANCE("da"),
    DEVELOP("dev"),
    REGRESSION("reg"),
    INTEGRATION("int"),
    PRODUCTION("prod");

    private String value;

    EnvironmentType(@NotNull String name) {
        this.value = name;
    }

    @Override
    public final String toString() {
        return this.value;
    }
}
