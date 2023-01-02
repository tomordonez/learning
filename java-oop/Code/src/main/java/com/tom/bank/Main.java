package com.tom.bank;

public class Main {
    public static void main(String[] args) {

        BankMenu menu = new BankMenu();
        BankAccount myAccount = new BankAccount();

        while (true) {
            int mainMenuOption = menu.mainMenu(myAccount);
            switch (mainMenuOption) {
                case 1 -> menu.accountMenu(myAccount);
                case 2 -> menu.balanceMenu(myAccount);
                case 3 -> menu.depositMenu(myAccount);
                case 4 -> menu.withdrawalMenu(myAccount);
                default -> System.out.println("Only enter an option from 1-5");
            }
            if (mainMenuOption == 5) {
                break;
            }
        }
    }
}
