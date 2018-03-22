package org.dvsa.testing.lib.uri;

import org.dvsa.testing.lib.uri.exceptions.UninitialisedURLException;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URIBase {

    private static URL URL;

    public static java.net.URL getURL() {
        if(URL == null) {
            throw new UninitialisedURLException();
        }

        return URL;
    }

    protected static void setURL(String spec) throws MalformedURLException {
        URL = new java.net.URL(spec);
    }

    public static URL updatePath(@NotNull String path) throws MalformedURLException {
        String regex = "(?:(?<=\\.aws\\/)|(?<=\\.uk\\/))[\\w\\/]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(getURL().toString());
        String URLSpec;

        if(matcher.find()){
            URLSpec = getURL().toString().replaceAll(regex, path);
        } else {
            URLSpec = getURL() + (getURL().toString().endsWith("/") ? path : "/" + path);
        }

        URLSpec = URLSpec.endsWith("/") ? URLSpec : URLSpec + "/";

        setURL(URLSpec);

        return URL;
    }

}
