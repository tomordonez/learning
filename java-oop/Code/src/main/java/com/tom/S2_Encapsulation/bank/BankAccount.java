package com.tom.S2_Encapsulation.bank;

public class BankAccount {
    private String owner = "Stranger";
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public double deposit(double deposit) {
        return this.balance += deposit;
    }

    public double withdraw(double withdraw) {
        return this.balance -= withdraw;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
