package com.intern.squad.rest;

import com.intern.squad.service.profile.ProfileService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InternSquadApplication {

	@Bean
	public ProfileService profileService() {
		return new ProfileService();
	}

	public static void main(String[] args) {
		SpringApplication.run(InternSquadApplication.class, args);
	}

}
