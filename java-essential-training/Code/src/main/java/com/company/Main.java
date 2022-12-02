package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        double d1 = getNumberFromSystemInput(sc);
        double d2 = getNumberFromSystemInput(sc);

        double result = d1 / d2;
        System.out.println("The answer is: " + result);
    }

    private static double getNumberFromSystemInput(Scanner sc) {
        System.out.print("Enter a number: ");
        return sc.nextDouble();
    }
}
