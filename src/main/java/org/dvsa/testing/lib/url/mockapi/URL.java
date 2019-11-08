package org.dvsa.testing.lib.url.mockapi;

import org.dvsa.testing.lib.url.URLBase;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

public class URL extends URLBase {

    public static java.net.URL build(@NotNull String scheme, @NotNull String path) {

        setURL(String.format("%s://mockapi-ps.dev-dvsacloud.uk/1.0/%s", scheme, path));
        return getURL();
    }

    public static java.net.URL build( @NotNull String path) {
        return build("https", path);
    }

}
