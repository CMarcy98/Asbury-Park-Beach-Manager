package com.beach.manager.service;

import com.beach.manager.data.access.dao.EmployeeDao;
import com.beach.manager.data.access.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    Employee mockEmployee;

    @Mock
    EmployeeDao mockEmployeeDao;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    public void testGetEmployeeById() {
        when(mockEmployeeDao.getEmployeeById(anyLong())).thenReturn(mockEmployee);
        assertEquals(mockEmployee, employeeService.getEmployeeById(123L));
    }

    @Test
    public void testGetAllEmployees() {
        when(mockEmployeeDao.getAllEmployees()).thenReturn(Collections.emptyList());
        assertNotNull(employeeService.getAllEmployees());
    }

    @Test
    public void testSaveEmployee() {
        employeeService.saveEmployee(mockEmployee);
        verify(mockEmployeeDao, times(1)).saveEmployee(mockEmployee);
    }

}
