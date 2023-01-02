package com.tom.conditionarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ConditionArrayListTest {

    ConditionArrayList numberList;
    @BeforeEach
    void setUp() {
        numberList = new ConditionArrayList(RandomNumberList.createList(5, 10, 10));
    }

    @Test
    void filterByPredicate_OddEvenIntegerList_FilterByOddIntegerList() {
        ArrayList<Integer> filteredNumberList = numberList.filterByPredicate(listElement -> (listElement % 2 == 1));
        assertEquals(Arrays.asList(7, 5, 1, 1), filteredNumberList, "The ArrayList should only have odd numbers");
    }
}