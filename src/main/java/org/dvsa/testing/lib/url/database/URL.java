package org.dvsa.testing.lib.url.database;

import org.dvsa.testing.lib.url.URLBase;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;

public class URL extends URLBase {

    private static String DEFAULT_SCHEMA = "OLCS_RDS_OLCSDB";
    private static int DEFAULT_PORT = 3306;

    public static String build(@NotNull String DBUsername, @NotNull String DBPassword, EnvironmentType environment, @NotNull String schema, int port) {
        return String.format(
                // TODO: Investigate prod structure, this only supports nonprod VPC for now.
                "jdbc:mysql://olcsdb-rds.olcs.%s.nonprod.dvsa.aws:%d/%s?user=%s&password=%s&useSSL=false",
                environment.toString(),
                port,
                schema,
                DBUsername,
                DBPassword
        );
    }

    public static String build(@NotNull String DBUsername, @NotNull String DBPassword, EnvironmentType environment, int port) {
        return build(DBUsername, DBPassword, environment, DEFAULT_SCHEMA, port);
    }

    public static String build(@NotNull String DBUsername, @NotNull String DBPassword, EnvironmentType environment, @NotNull String schema) {
        return build(DBUsername, DBPassword, environment, schema, DEFAULT_PORT);
    }

    public static String build(@NotNull String DBUsername, @NotNull String DBPassword, EnvironmentType environment) {
        return build(DBUsername, DBPassword, environment, DEFAULT_SCHEMA, DEFAULT_PORT);
    }

    public static String build(@NotNull String DBUsername, @NotNull String DBPassword, @NotNull String environment, @NotNull String schema, int port) {
        return build(DBUsername, DBPassword, EnvironmentType.getEnum(environment), schema, port);
    }

    public static String build(@NotNull String DBUsername, @NotNull String DBPassword, @NotNull String environment, int port) {
        return build(DBUsername, DBPassword, EnvironmentType.getEnum(environment), port);
    }

    public static String build(@NotNull String DBUsername, @NotNull String DBPassword, @NotNull String environment, @NotNull String schema) {
        return build(DBUsername, DBPassword, EnvironmentType.getEnum(environment), schema, DEFAULT_PORT);
    }

    public static String build(@NotNull String DBUsername, @NotNull String DBPassword, @NotNull String environment) {
        return build(DBUsername, DBPassword, EnvironmentType.getEnum(environment));
    }

}
