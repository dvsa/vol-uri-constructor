package org.dvsa.testing.lib.url.database;

import org.dvsa.testing.lib.url.URLBase;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;

public class URL extends URLBase {

    private static String DEFAULT_SCHEMA = "OLCS_RDS_OLCSDB";
    private static int DEFAULT_PORT = 3306;

    public static java.net.URL build(@NotNull String DBUsername, @NotNull String DBPassword, EnvironmentType environment, @NotNull String schema, int port) throws MalformedURLException {
        String URL = String.format(
                // TODO: Investigate prod structure, this only supports nonprod VPC for now.
                "jdbc:mysql://olcsdb-rds.olcs.%s.nonprod.dvsa.aws:%d/%s?user=%s&password=%s&useSSL=false",
                environment.toString(),
                port,
                schema,
                DBUsername,
                DBPassword
        );

        setURL(URL);
        return getURL();
    }

    public static java.net.URL build(@NotNull String DBUsername, @NotNull String DBPassword, EnvironmentType environment, int port) throws MalformedURLException {
        return build(DBUsername, DBPassword, environment, DEFAULT_SCHEMA, port);
    }

    public static java.net.URL build(@NotNull String DBUsername, @NotNull String DBPassword, EnvironmentType environment, @NotNull String schema) throws MalformedURLException {
        return build(DBUsername, DBPassword, environment, schema, DEFAULT_PORT);
    }

    public static java.net.URL build(@NotNull String DBUsername, @NotNull String DBPassword, EnvironmentType environment) throws MalformedURLException {
        return build(DBUsername, DBPassword, environment, DEFAULT_SCHEMA, DEFAULT_PORT);
    }

    public static java.net.URL build(@NotNull String DBUsername, @NotNull String DBPassword, @NotNull String environment, @NotNull String schema, int port) throws MalformedURLException {
        return build(DBUsername, DBPassword, EnvironmentType.getEnum(environment), schema, port);
    }

    public static java.net.URL build(@NotNull String DBUsername, @NotNull String DBPassword, @NotNull String environment, int port) throws MalformedURLException {
        return build(DBUsername, DBPassword, EnvironmentType.getEnum(environment), port);
    }

    public static java.net.URL build(@NotNull String DBUsername, @NotNull String DBPassword, @NotNull String environment, @NotNull String schema) throws MalformedURLException {
        return build(DBUsername, DBPassword, EnvironmentType.getEnum(environment), schema, DEFAULT_PORT);
    }

    public static java.net.URL build(@NotNull String DBUsername, @NotNull String DBPassword, @NotNull String environment) throws MalformedURLException {
        return build(DBUsername, DBPassword, EnvironmentType.getEnum(environment));
    }

}
