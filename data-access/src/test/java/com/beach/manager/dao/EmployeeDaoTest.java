package com.beach.manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDaoTest {

    @InjectMocks
    EmployeeDao employeeDao;

    @Test
    public void testGetEmployeeById() {
        assertNull(employeeDao.getEmployeeById(123L));
    }


}
