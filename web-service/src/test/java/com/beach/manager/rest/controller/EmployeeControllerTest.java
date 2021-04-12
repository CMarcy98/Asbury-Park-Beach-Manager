package com.beach.manager.rest.controller;

import com.beach.manager.data.access.model.Employee;
import com.beach.manager.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @Mock
    Employee mockEmployee;

    @Mock
    EmployeeService mockEmployeeService;

    @InjectMocks
    EmployeeController employeeController;

    @Test
    public void getAllEmployeesTest() {
        when(mockEmployeeService.getAllEmployees()).thenReturn(Collections.emptyList());
        assertNotNull(employeeController.getAllEmployees());
    }

    @Test
    public void getEmployeeByIdTest() {
        when(mockEmployeeService.getEmployeeById(anyLong())).thenReturn(mockEmployee);
        assertEquals(mockEmployee, employeeController.getEmployeeById(123L));
    }

    @Test
    public void saveEmployeeTest() {
        employeeController.saveEmployee(mockEmployee);
        verify(mockEmployeeService, times(1)).saveEmployee(mockEmployee);
    }

}
