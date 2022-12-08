package com.tom.employee;

import java.text.NumberFormat;

public class Employee {
    private String name;
    private int age;
    private String location;
    private double salary;

    public Employee(String name, int age, String location, double salary) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.salary = salary;
    }

    public String raiseSalary() {
        // this example doesn't change the variable, only formats the change in currency
        var formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(this.salary + 10000);
    }
}
