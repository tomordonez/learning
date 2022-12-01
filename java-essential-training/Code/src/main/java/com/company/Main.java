package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // A simple calculator with TDD and JUnit tests
        // Enter a numeric value: 24.2
        // Enter a numeric value: 12.1
        // The answer is 2.0

        var scanner = new Scanner(System.in);
        System.out.print("Enter a numeric value: ");
        var dividend = scanner.nextDouble();

        System.out.print("Enter a numeric value: ");
        var divisor = scanner.nextDouble();

        double quotient = Calculator.divide(dividend, divisor);
        System.out.printf("The answer is %.1f", quotient);
    }
}
