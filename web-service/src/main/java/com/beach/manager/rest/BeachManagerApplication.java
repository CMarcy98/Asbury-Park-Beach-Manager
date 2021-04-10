package com.beach.manager.rest;

import com.beach.manager.dao.EmployeeDao;
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

	@Bean
	public EmployeeDao employeeDao() {
		return new EmployeeDao();
	}

	public static void main(String[] args) {
		SpringApplication.run(BeachManagerApplication.class, args);
	}

}
