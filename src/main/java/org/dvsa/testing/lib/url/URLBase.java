package org.dvsa.testing.lib.url;

import org.dvsa.testing.lib.url.exceptions.UninitialisedURLException;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLBase {

    private static URL URL;

    public static java.net.URL getURL() {
        if(URL == null) {
            throw new UninitialisedURLException();
        }

        return URL;
    }

    protected static void setURL(String spec) {
        spec = addResourceDelimiterIfMissing(spec);
        try {
            URL = new URL(spec);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new org.dvsa.testing.lib.url.exceptions.MalformedURLException();
        }
    }

    public static URL updatePath(@NotNull String path) {
        String regex = "(?:(?<=\\.aws\\/)|(?<=\\.uk\\/))[\\w\\/-]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(getURL().toString());
        String URLSpec;

        String partialPath = isAPIUrl(getURL()) ? "api/" : "";

        if(matcher.find()){
            URLSpec = getURL().toString().replaceAll(regex, partialPath + path);
        } else {
            URLSpec = getURL() + (getURL().toString().endsWith("/") ? path : "/" + path);
        }

        URLSpec = URLSpec.endsWith("/") ? URLSpec : URLSpec + "/";

        setURL(URLSpec);

        return URL;
    }

    private static String addResourceDelimiterIfMissing(@NotNull String URLSpec) {
        return URLSpec.endsWith("/") ? URLSpec : URLSpec + "/";
    }

    private static boolean isAPIUrl(URL URL){
        String regex = "(?:(?<=\\.aws\\/)|(?<=\\.uk\\/))api\\/?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(URL.toString());
        return matcher.find();
    }

}
