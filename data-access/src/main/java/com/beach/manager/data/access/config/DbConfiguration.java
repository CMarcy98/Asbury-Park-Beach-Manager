package com.beach.manager.data.access.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfiguration {

    @Bean
    public DbProperties dbProperties() {
        return new DbProperties();
    }

    @Bean
    public DataSource dataSource() {
        DbProperties dbProperties = dbProperties();
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(dbProperties.getDatabaseUrl());
        dataSourceBuilder.username(dbProperties.getDatabaseUsername());
        dataSourceBuilder.password(dbProperties.getDatabasePassword());
        dataSourceBuilder.driverClassName(dbProperties.getDriverClassName());
        return dataSourceBuilder.build();
    }

}
