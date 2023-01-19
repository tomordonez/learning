package com.company;

public class Calculator {
    public static double add(double... operands) {
        return operands[0] + operands[1];
    }
    public static double subtract(double... operands) {
        return operands[0] - operands[1];
    }
    public static double product(double... operands) {
        return operands[0] * operands[1];
    }
    public static double divide(double... operands) {
        try {
            return operands[0] / operands[1];
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Divided by 0");
        }
    }



}
