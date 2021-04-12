package com.beach.manager.rest.controller;

import com.beach.manager.data.access.model.Employee;
import com.beach.manager.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees from the database.");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        log.info("Fetching employee #{} from the database.", employeeId);
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/")
    public void saveEmployee(Employee employee) {
        log.info("Saving {} {} as a new employee to the database with an hourly wage of {}.", employee.getFirstName(), employee.getLastName(), employee.getHourlyWage());
        employeeService.saveEmployee(employee);
    }

}
