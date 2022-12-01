package com.company;

public class Main {
    public static void main(String[] args) {

        String s1 = "Hello!";
        var s2 = "Hello!";

        // the comparison is referencing the same object with the same value
        if (s1.equals(s2)) {
            System.out.printf("%s and %s are equal", s1, s2);
        }

        String s3 = new String("HOLA");
        String s4 = new String("HOLA");

        // the comparison is referencing different objects with the same value
        if (s3.equals(s4)) {
            System.out.printf("%s y %s son iguales%n", s3, s4);
        }
    }
}
