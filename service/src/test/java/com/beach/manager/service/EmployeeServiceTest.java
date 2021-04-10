package com.beach.manager.service;

import com.beach.manager.dao.EmployeeDao;
import com.beach.manager.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    Employee mockEmployee;

    @Mock
    EmployeeDao mockEmployeeDao;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    public void testGetEmployee() {
        when(mockEmployeeDao.getEmployeeById(anyLong())).thenReturn(mockEmployee);
        assertEquals(mockEmployee, employeeService.getEmployeeById(123L));
    }

}
