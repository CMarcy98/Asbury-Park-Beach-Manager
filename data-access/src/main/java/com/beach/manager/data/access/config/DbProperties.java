package com.beach.manager.data.access.config;

import org.springframework.beans.factory.annotation.Value;

public class DbProperties {

    @Value("${spring.datasource.jdbc-url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String databaseUsername;

    @Value("${spring.datasource.password}")
    private String databasePassword;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public String getDriverClassName() {
        return driverClassName;
    }
}
