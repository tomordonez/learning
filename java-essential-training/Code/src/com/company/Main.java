package com.company;

public class Main {
    public static void main(String[] args) {
        var s1 = "Hola Namor";
        System.out.println("Length of string: " + s1.length());

        int position = s1.indexOf("Namor");
        System.out.println("Position of string: " + position);

        System.out.println("Trim whitespace: " + s1.trim());

        var namorString = s1.substring(5);
        System.out.println("String is: " + namorString);

        var namString = s1.substring(5, 7);
        System.out.println("Other substring method: " + namString);
    }
}
