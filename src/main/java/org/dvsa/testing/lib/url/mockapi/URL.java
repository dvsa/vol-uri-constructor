package org.dvsa.testing.lib.url.mockapi;

import org.dvsa.testing.lib.url.URLBase;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

public class URL extends URLBase {

    public static java.net.URL build(@NotNull String scheme, @NotNull EnvironmentType environment, @NotNull String path) {

        setURL(String.format("%s://mockapi.olcs.%s.nonprod.dvsa.aws/%s", scheme, environment, path));
        return getURL();
    }

    public static java.net.URL build(@NotNull EnvironmentType environment, @NotNull String path) {
        return build("https", environment, path);
    }

    public static java.net.URL build(@NotNull EnvironmentType environment) {
        return build(environment, "");
    }

}
