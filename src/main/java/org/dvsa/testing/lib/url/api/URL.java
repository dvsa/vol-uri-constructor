package org.dvsa.testing.lib.url.api;

import org.dvsa.testing.lib.url.URLBase;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;

public class URL extends URLBase {

    public static java.net.URL build(@NotNull String scheme, @NotNull EnvironmentType environment, @NotNull String path) throws MalformedURLException {
        setURL(String.format("%s://api.olcs.%s.nonprod.dvsa.aws/api/%s", scheme, environment, path));

        return getURL();
    }

    public static java.net.URL build(@NotNull EnvironmentType environment, @NotNull String path) throws MalformedURLException {
        return build("http", environment, path);
    }

    public static java.net.URL build(@NotNull EnvironmentType environment) throws MalformedURLException {
        return build(environment, "");
    }

}
