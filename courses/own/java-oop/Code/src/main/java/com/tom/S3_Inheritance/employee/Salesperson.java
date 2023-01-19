package com.tom.S3_Inheritance.employee;

public class Salesperson extends Employee{
    private double commissionPercentage;
    public Salesperson(String name, int age, double salary) {
        super(name, age, salary);
    }

    public double getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(double commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public double raiseCommission(double raisedCommissionDollars) {
        return (this.getCommissionPercentage() * super.getSalary()) + raisedCommissionDollars;
    }
}
