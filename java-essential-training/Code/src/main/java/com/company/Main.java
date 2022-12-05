package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNumber, secondNumber;
        try {
            System.out.print("Enter the first number value: ");
            firstNumber = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter the second number value: ");
            secondNumber = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Enter a number only!");
            throw new RuntimeException(e);
        }

        System.out.print("Select an operation (+ - * /): ");
        var operation = scanner.nextLine();

        double result = 0;
        switch (operation) {
            case "+" -> result = Calculator.add(firstNumber, secondNumber);
            case "-" -> result = Calculator.subtract(firstNumber, secondNumber);
            case "*" -> result = Calculator.product(firstNumber, secondNumber);
            case "/" -> result = Calculator.divide(firstNumber, secondNumber);
            default -> System.out.println("Only enter one of: + - * /");
        }
        System.out.printf("The answer is: %.1f", result);
    }

}
