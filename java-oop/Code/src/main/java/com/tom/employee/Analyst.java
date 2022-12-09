package com.tom.employee;

public class Analyst extends Employee{
    public Analyst(String name, int age, double salary) {
        super(name, age, salary);
    }

    public double getAnnualBonus() {
        return super.getSalary() * 1.15;
    }
}
