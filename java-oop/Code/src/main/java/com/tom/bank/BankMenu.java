package com.tom.bank;

import java.util.Scanner;

public class BankMenu {
    private final Scanner scanner = new Scanner(System.in);

    public BankMenu() {
    }

    public int mainMenu(BankAccount myAccount) {
        System.out.printf("Hey %s! Welcome to Bank of Wakanda\n", myAccount.getOwner());
        System.out.println("1. View your account name");
        System.out.println("2. View your balance");
        System.out.println("3. Make a deposit");
        System.out.println("4. Make a withdrawal");
        System.out.println("5. Exit");
        System.out.print("Enter a number option [1 - 5]: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void accountMenu(BankAccount myAccount) {
        if (myAccount.getOwner().equals("Stranger")) {
            System.out.print("*****\nYou don't have an account. Enter your name to create one: ");
            String account = scanner.nextLine();
            myAccount.setOwner(account);
        } else {
            System.out.printf("*****\nYour account name is: %s\n*****\n", myAccount.getOwner());
        }
    }

    public void balanceMenu(BankAccount myAccount) {
        if (myAccount.getBalance() == 0) {
            System.out.print("*****\nYou don't have any money.\n*****\n");
        } else {
            System.out.printf("*****\nYour balance is: %s\n*****\n", myAccount.getBalance());
        }
    }

    public void depositMenu(BankAccount myAccount) {
        System.out.print("*****\nEnter the deposit amount: ");
        double deposit = Double.parseDouble(scanner.nextLine());
        myAccount.deposit(deposit);
        System.out.printf("You deposited: $%s and your balance is: $%s\n", deposit, myAccount.getBalance());
    }

    public void withdrawalMenu(BankAccount myAccount) {
        System.out.print("*****\nEnter the withdrawal amount: ");
        double withdraw = Double.parseDouble(scanner.nextLine());
        myAccount.withdraw(withdraw);
        System.out.printf("You withdrew: $%s and your balance is: $%s\n", withdraw, myAccount.getBalance());
    }
}
