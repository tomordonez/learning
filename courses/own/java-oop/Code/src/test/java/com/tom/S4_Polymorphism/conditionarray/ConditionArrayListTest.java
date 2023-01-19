package com.tom.S4_Polymorphism.conditionarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConditionArrayListTest {

    ConditionArrayList randomNumberList;
    ArrayList<Integer> filteredNumberList;
    @BeforeEach
    void setUp() {
        randomNumberList = new ConditionArrayList(RandomNumberList.createList(5, 10, 10));
    }

    @Test
    void filterByPredicate_OddEvenIntegerList_OddIntegerList() {
        filteredNumberList = randomNumberList.filterByPredicate(listElement -> (listElement % 2 == 1));
        assertEquals(Arrays.asList(7, 5, 1, 1), filteredNumberList, "The ArrayList should only have odd numbers");
    }

    @Test
    void filterByPredicate_OddEvenIntegerList_EvenIntegerList() {
        filteredNumberList = randomNumberList.filterByPredicate(listElement -> (listElement % 2 == 0));
        assertEquals(Arrays.asList(2, 4, 4, 6, 4, 2), filteredNumberList, "The ArrayList should only have odd numbers");
    }

    @Test
    void filterByPredicate_OddEvenIntegerList_PrimeNumberList()  {
        ConditionArrayList numberList = new ConditionArrayList(Arrays.asList(0, 1, 2, 3, 4, 5));
        filteredNumberList = numberList.filterByPredicate(ConditionArrayList::isPrime);
        assertEquals(Arrays.asList(2, 3, 5), filteredNumberList, "The ArrayList should only have prime numbers");

    }
}