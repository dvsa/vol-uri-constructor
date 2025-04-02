package org.dvsa.testing.lib.url.webapp;

import org.dvsa.testing.lib.url.URLBase;
import org.dvsa.testing.lib.url.webapp.utils.ApplicationType;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

import static org.dvsa.testing.lib.url.utils.EnvironmentType.*;

public class webAppURL extends URLBase {

    public static java.net.URL build(@NotNull ApplicationType appType, @NotNull String env, @NotNull String endPoint) {
        return build(appType, getEnum(env), endPoint);
    }

    public static java.net.URL build(@NotNull ApplicationType appType, @NotNull String env) {
        return build(appType, getEnum(env));
    }

    public static java.net.URL build(ApplicationType appType, EnvironmentType env, String endPoint) {
        var domain = switch (appType) {
            case EXTERNAL -> switch (env) {
                case PRODUCTION -> String.format("https://www.vehicle-operator-licensing.service.gov.uk/%s", endPoint);
                case LOCAL -> String.format("http://olcs-selfserve/", endPoint);
                case PREPRODUCTION -> String.format("https://preview.vehicle-operator-licensing.service.gov.uk/%s", endPoint);
                default -> {
                    var prodOrNonProd = (env == INTEGRATION) ? "" : "dev-";
                    yield String.format("https://ssweb.%s.olcs.%sdvsacloud.uk/%s", name(appType, env), prodOrNonProd, endPoint);
                }
            };
            case INTERNAL -> switch (env) {
                case LOCAL -> String.format("http://olcs-internal/", endPoint);
                case PREPRODUCTION -> String.format("https://pre.olcs.dvsacloud.uk/%s", endPoint);
                default -> {
                    var prodOrNonProd = (env == INTEGRATION || env == PRODUCTION) ? "" : "dev-";
                    yield String.format("https://iuweb.%s.olcs.%sdvsacloud.uk/%s", name(appType, env), prodOrNonProd, endPoint);
                }
            };
        };
        setURL(domain);
        return getURL();
    }
    public static java.net.URL build(ApplicationType appType, EnvironmentType env) {
        return webAppURL.build(appType, env, "");
    }
}