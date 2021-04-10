package com.beach.manager.service;

import com.beach.manager.dao.EmployeeDao;
import com.beach.manager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public Employee getEmployeeById(long employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

}
