package com.tom.S3_Inheritance.employee;

import com.tom.S3_Inheritance.employee.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee testEmployee = null;
    @BeforeEach
    void setUp() {
        testEmployee = new Employee("Namor", 40);
    }

    @Test
    void raiseSalary() {
        testEmployee.setSalary(50000);
        assertEquals(60000, testEmployee.raiseSalary());
    }
}