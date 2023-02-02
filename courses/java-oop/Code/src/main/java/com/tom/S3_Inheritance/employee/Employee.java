package com.tom.S3_Inheritance.employee;

public class Employee extends Person {
    private double salary;

    public Employee(String name, int age) {
        super(name, age);
    }

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double raiseSalary() {
        return this.salary += 10000;
    }
}
