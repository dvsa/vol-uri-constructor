package org.dvsa.testing.lib.url.api;

import org.dvsa.testing.lib.url.URLBase;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

public class URL extends URLBase {

    public static java.net.URL build(@NotNull String scheme, @NotNull EnvironmentType environment, @NotNull String path) {
        String environmentString = environment.toString().toLowerCase();

        if (environment == EnvironmentType.LOCAL) {
            setURL(String.format("%s://olcs-backend/api/%s", scheme, path));
        } else {
            setURL(String.format("%s://api.%s.olcs.dev-dvsacloud.uk/api/%s", scheme, environmentString, path));
        }

        return getURL();
    }

    public static java.net.URL build(@NotNull EnvironmentType environment, @NotNull String path) {
        return build("http", environment, path);
    }

    public static java.net.URL build(@NotNull EnvironmentType environment) {
        return build(environment, "");
    }
}