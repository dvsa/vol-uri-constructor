package org.dvsa.testing.lib.url;

import org.dvsa.testing.lib.url.exceptions.UninitialisedURLException;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLBase {

    private static URL url;

    public static java.net.URL getURL() {
        if (url == null) {
            throw new UninitialisedURLException();
        }
        return url;
    }

    protected static void setURL(String spec) {
        try {
            url = new URL(spec);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new org.dvsa.testing.lib.url.exceptions.MalformedURLException();
        }
    }

    public static URL updatePath(@NotNull String path) {
        var regex = "(?:(?<=\\.aws\\/)|(?<=\\.uk\\/))[\\w\\/]+";
        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(getURL().toString());
        var urlSpec = matcher.find() ? getURL().toString().replaceAll(regex, path) : getURL() + (getURL().toString().endsWith("/") ? path : "/" + path);
        urlSpec = urlSpec.endsWith("/") ? urlSpec : urlSpec + "/";
        setURL(urlSpec);
        return url;
    }
}