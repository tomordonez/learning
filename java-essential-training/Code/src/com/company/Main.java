package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        var name = scanner.nextLine();
        System.out.println("Hello " + name);

        System.out.print("Enter your birthdate: ");
        var birthdateString = scanner.nextLine();

        try {
            var dateFormat = LocalDate.parse(birthdateString, DateTimeFormatter.ofPattern("MM-d-yyyy"));
            var age = LocalDate.now().getYear() - dateFormat.getYear();
            System.out.printf("You are %s. That's really old %s", age, name);
        } catch (Exception e) {
            System.out.println("Wrong birthdate format. Enter as MM-DD-YYYY");
        }

    }
}
