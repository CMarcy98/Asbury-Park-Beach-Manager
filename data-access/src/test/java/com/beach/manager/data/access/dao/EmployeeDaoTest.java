package com.beach.manager.data.access.dao;

import com.beach.manager.data.access.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDaoTest {

    @Mock
    NamedParameterJdbcTemplate mockTemplate;

    @Mock
    Employee mockEmployee;

    EmployeeDao employeeDao;

    @Before
    public void setup() {
        employeeDao = new EmployeeDao(mockTemplate);
    }

    @Test
    public void testGetEmployeeById_NoEmployeesWithId() {
        when(mockTemplate.query(eq(employeeDao.GET_EMPLOYEE_BY_ID), any(MapSqlParameterSource.class), any(RowMapper.class)))
                .thenReturn(Collections.emptyList());

        Employee foundEmployee = employeeDao.getEmployeeById(123L);
        assertNull(foundEmployee);
    }

    @Test
    public void testGetEmployeeById_EmployeeWithIdReturned() {
        when(mockTemplate.query(eq(employeeDao.GET_EMPLOYEE_BY_ID), any(MapSqlParameterSource.class), any(RowMapper.class)))
                .thenReturn(Collections.singletonList(mockEmployee));

        Employee foundEmployee = employeeDao.getEmployeeById(123L);
        assertEquals(mockEmployee, foundEmployee);
    }

    @Test
    public void testSaveEmployee() {
        when(mockTemplate.update(eq(employeeDao.INSERT_EMPLOYEE), any(MapSqlParameterSource.class)))
                .thenReturn(1);
        int rowsUpdated = employeeDao.saveEmployee(mockEmployee);
        assertEquals(1, rowsUpdated);
    }

    @Test
    public void testGetAllEmployees() {
        when(mockTemplate.query(eq(employeeDao.GET_ALL_EMPLOYEES), any(RowMapper.class))).thenReturn(Collections.singletonList(mockEmployee));
        List<Employee> employees = employeeDao.getAllEmployees();
        assertEquals(1, employees.size());
        assertEquals(mockEmployee, employees.get(0));
    }

}
