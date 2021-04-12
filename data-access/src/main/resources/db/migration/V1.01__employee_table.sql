DROP TABLE IF EXISTS `EMPLOYEE`;
CREATE TABLE EMPLOYEE (
    employee_id int NOT NULL AUTO_INCREMENT,
    first_name varchar(50),
    last_name varchar(50),
    hourly_wage float(2),
    PRIMARY KEY (employee_id)
);