package com.beach.manager.data.access.config;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ DbConfiguration.class })
public class FlywayConfiguration {

    private static final Logger log = LoggerFactory.getLogger(FlywayConfiguration.class);

    @Value("${flyway.locations}")
    private String flywayLocations;

    @Value("${flyway.baseline.version}")
    private String baselineVersion;

    @Value("${flyway.target.version}")
    private String targetVersion;

    @Autowired
    DbProperties dbProperties;

    @Bean(initMethod = "migrate")
    Flyway flyway() {
        log.info("Flyway: Instance created...");
        log.info("Flyway: Database Url:              " + dbProperties.getDatabaseUrl());
        log.info("Flyway: Database Username:         " + dbProperties.getDatabaseUsername());
        log.info("Flyway: Migration script location: " + flywayLocations);

        Flyway flyway = new Flyway();
        flyway.setDataSource(dbProperties.getDatabaseUrl(), dbProperties.getDatabaseUsername(), dbProperties.getDatabasePassword());
        flyway.setLocations(flywayLocations);
        flyway.setBaselineVersionAsString(baselineVersion);
        flyway.setTargetAsString(targetVersion);
        flyway.setBaselineOnMigrate(true);

        return flyway;
    }

}
