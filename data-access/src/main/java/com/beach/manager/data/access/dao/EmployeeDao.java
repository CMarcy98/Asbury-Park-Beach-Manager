package com.beach.manager.data.access.dao;

import com.beach.manager.data.access.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
public class EmployeeDao {

    private final static Logger log = LoggerFactory.getLogger(EmployeeDao.class);
    final String GET_ALL_EMPLOYEES = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HOURLY_WAGE FROM EMPLOYEE";
    final String GET_EMPLOYEE_BY_ID = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HOURLY_WAGE FROM EMPLOYEE WHERE EMPLOYEE_ID = :employeeId";
    final String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEE (FIRST_NAME, LAST_NAME, HOURLY_WAGE) VALUES (:firstName, :lastName, :hourlyWage)";

    private NamedParameterJdbcTemplate template;

    public EmployeeDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public int saveEmployee(Employee employee) {
        MapSqlParameterSource sqlParameters = new MapSqlParameterSource();
        sqlParameters.addValue("firstName", employee.getFirstName());
        sqlParameters.addValue("lastName", employee.getLastName());
        sqlParameters.addValue("hourlyWage", employee.getHourlyWage());
        return template.update(INSERT_EMPLOYEE, sqlParameters);
    }

    public List<Employee> getAllEmployees() {
        return template.query(GET_ALL_EMPLOYEES, new EmployeeRowMapper());
    }

    public Employee getEmployeeById(long employeeId) {
        MapSqlParameterSource sqlParameters = new MapSqlParameterSource();
        sqlParameters.addValue("employeeId", employeeId);
        List<Employee> employees = template.query(GET_EMPLOYEE_BY_ID, sqlParameters, new EmployeeRowMapper());
        return CollectionUtils.isEmpty(employees) ? null : employees.get(0);
    }

    private class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet resultSet, int rows) throws SQLException {
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getLong("employee_id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setHourlyWage(resultSet.getBigDecimal("hourly_wage"));
            return employee;
        }

    }

}
