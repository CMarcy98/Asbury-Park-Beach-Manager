package com.beach.manager.service.config;

import com.beach.manager.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }

}
