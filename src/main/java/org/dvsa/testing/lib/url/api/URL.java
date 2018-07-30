package org.dvsa.testing.lib.url.api;

import org.dvsa.testing.lib.url.URLBase;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.dvsa.testing.lib.url.webapp.utils.ApplicationType;
import org.jetbrains.annotations.NotNull;

public class URL extends URLBase {

    public static java.net.URL build(@NotNull String scheme, @NotNull EnvironmentType environment, @NotNull String path) {
        // TODO: find out how prod url looks and incorporate findings
        if (environment == EnvironmentType.LOCAL) {
            setURL(String.format("%s://backend/%s",scheme, path));
        } else {
            setURL(String.format("%s://api.olcs.%s.nonprod.dvsa.aws/api/%s", scheme, environment, path));
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
