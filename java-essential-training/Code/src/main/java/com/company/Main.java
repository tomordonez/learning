package com.company;

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double d1 = getInput(sc, "Enter first number: ");
        double d2 = getInput(sc, "Enter second number: ");

        double result = addNumbers(d1, d2);
        System.out.println("The sum is: " + result);

        double d3 = getInput(sc, "Enter third number: ");
        double resultWithThreeNumbers = addNumbers(d1, d2, d3);
        System.out.println("Sum of three numbers is: " + resultWithThreeNumbers);

        double resultWithFourNumbers = addNumbers(d1, d2, d1, d2);
        System.out.println("Sum of four numbers with DoubleStream is: " + resultWithFourNumbers);
    }

    private static double addNumbers(double d1, double d2) {
        return d1 + d2;
    }
    private static double addNumbers(double d1, double d2, double d3) {
        return d1 + d2 + d3;
    }

    private static double addNumbers(double... values) {
        return DoubleStream.of(values)
                .sum();
    }

    private static double getInput(Scanner sc, String inputText) {
        System.out.print(inputText);
        return sc.nextDouble();
    }


}
