package com.company;

public class Calculator {
    static double divide(double... operands) {
        try {
            return operands[0] / operands[1];
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Divided by 0");
        }
    }
}
