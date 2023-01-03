package com.tom.S4_Polymorphism.conditionarray;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ConditionArrayList randomNumberList = new ConditionArrayList(RandomNumberList.createList(5, 50, 10));

        ArrayList<Integer> oddNumberList = randomNumberList.filterByPredicate(listElement -> (listElement % 2 == 1));
        ArrayList<Integer> evenNumberList = randomNumberList.filterByPredicate(listElement -> (listElement % 2 == 0));
        ArrayList<Integer> primeNumberList = randomNumberList.filterByPredicate(ConditionArrayList::isPrime);

        System.out.println("Original list: " + randomNumberList);
        System.out.println("Filtered by odd numbers: " + oddNumberList);
        System.out.println("Filtered by even numbers: " + evenNumberList);
        System.out.println("Filtered by prime numbers: " + primeNumberList);
    }
}
