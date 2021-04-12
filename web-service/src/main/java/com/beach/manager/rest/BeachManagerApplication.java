package com.beach.manager.rest;

import com.beach.manager.data.access.config.DaoConfig;
import com.beach.manager.data.access.config.FlywayConfiguration;
import com.beach.manager.service.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ FlywayConfiguration.class, ServiceConfig.class, DaoConfig.class })
public class BeachManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeachManagerApplication.class, args);
	}

}
