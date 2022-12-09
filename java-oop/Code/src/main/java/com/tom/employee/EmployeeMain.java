package com.tom.employee;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        List<Employee> employees = new ArrayList<>();
        employees.add(new Analyst("Love", 10, 80000));
        employees.add(new Salesperson("Loki", 35, 114000));

        Analyst analyst = (Analyst) employees.get(0);
        System.out.printf("Analyst salary + bonus: %s\n", formatter.format(analyst.getAnnualBonus()));

        Salesperson salesperson = (Salesperson) employees.get(1);
        salesperson.setCommissionPercentage(0.05);

        System.out.printf("Salesperson commission increased to: %s",
                formatter.format(salesperson.raiseCommission(10000)));
    }
}
