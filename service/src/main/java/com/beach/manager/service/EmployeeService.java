package com.beach.manager.service;

import com.beach.manager.data.access.dao.EmployeeDao;
import com.beach.manager.data.access.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public Employee getEmployeeById(long employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public int saveEmployee(Employee employee) {
        return employeeDao.saveEmployee(employee);
    }

}
