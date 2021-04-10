package com.beach.manager.rest;

import com.beach.manager.service.profile.ProfileService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeachManagerApplication {

	@Bean
	public ProfileService profileService() {
		return new ProfileService();
	}

	public static void main(String[] args) {
		SpringApplication.run(BeachManagerApplication.class, args);
	}

}
