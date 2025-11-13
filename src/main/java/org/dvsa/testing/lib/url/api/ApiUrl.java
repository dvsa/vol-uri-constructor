package org.dvsa.testing.lib.url.api;

import org.dvsa.testing.lib.url.URLBase;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

public class ApiUrl extends URLBase {

    public static java.net.URL build(@NotNull String scheme, @NotNull EnvironmentType environment, @NotNull String path) {
        var baseUrl = "";
        if (environment == EnvironmentType.LOCAL) {
            baseUrl = String.format("%s://api.local.olcs.dev-dvsacloud.uk/api/%s", scheme, path);
        } else {
            baseUrl = String.format("%s://api.%s.olcs.dev-dvsacloud.uk/api/%s", scheme, environment, path);
            if (environment == EnvironmentType.PRODUCTION) {
                baseUrl = baseUrl.replace(".dev-", ".");
            }
        }
        setURL(baseUrl);
        return getURL();
    }

    public static java.net.URL build(@NotNull EnvironmentType environment, @NotNull String path) {
        return build("http", environment, path);
    }

    public static java.net.URL build(@NotNull EnvironmentType environment) {
        return build(environment, "");
    }
}