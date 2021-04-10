package com.beach.manager.model;

import java.math.BigDecimal;

public class Employee {

    private long employeeId;
    private String firstName;
    private String lastName;
    private BigDecimal hourlyWage;

    public Employee() {}

    public Employee(String firstName, String lastName, BigDecimal hourlyWage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyWage = hourlyWage;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(BigDecimal hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
