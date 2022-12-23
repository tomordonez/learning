package com.tom.oddarrayagain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OddArrayAgainListTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void oddArrayAgainListConstructor_InitializedWithOddEvenNumbersList_FilterOutEvenNumbers() {
        OddArrayAgainList oddArrayList = new OddArrayAgainList(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(Arrays.asList(1, 3, 5), oddArrayList);
    }
    @Test
    void isOdd_Integer5_IsOdd() {
        assertTrue(OddArrayAgainList.isOdd(5));
    }
    @Test
    void isOdd_Integer4_IsEven() {
        assertFalse(OddArrayAgainList.isOdd(4));
    }

    @Test
    void isOdd_Integer0_IsEven() {
        assertFalse(OddArrayAgainList.isOdd(0));
    }

    @Test
    void add_EvenNumber_NumberNotAddedListSizeZero() {
        OddArrayAgainList oddNumbersList = new OddArrayAgainList();
        oddNumbersList.add(2);
        assertEquals(0, oddNumbersList.size());
    }

    @Test
    void add_OddNumber_NumberAddedListSizeOne() {
        OddArrayAgainList oddNumbersList = new OddArrayAgainList();
        oddNumbersList.add(3);
        assertEquals(1, oddNumbersList.size());
    }

    @Test
    void addWithIndex_EvenNumber_NumberNotAddedListSizeZero() {
        OddArrayAgainList oddNumberList = new OddArrayAgainList();
        oddNumberList.add(0, 2);
        assertEquals(0, oddNumberList.size());
    }

    @Test
    void addWithIndex_OddNumber_NumberAddedListSizeOne() {
        OddArrayAgainList oddNumberList = new OddArrayAgainList();
        oddNumberList.add(0, 3);
        assertEquals(1, oddNumberList.size());
    }
    @Test
    void addAll_OddEvenNumbers_EvenNumbersNotAdded() {
        OddArrayAgainList oddNumbersList = new OddArrayAgainList();
        oddNumbersList.addAll(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(Arrays.asList(1, 3, 5), oddNumbersList);
    }

    @Test
    void addAllWithIndex_OddEvenNumbers_EvenNumbersNotAdded() {
        OddArrayAgainList oddNumbersList = new OddArrayAgainList();
        oddNumbersList.addAll(0, Arrays.asList(1, 2, 3, 4, 5));
        oddNumbersList.addAll(3, Arrays.asList(6, 7, 8, 9));
        assertEquals(Arrays.asList(1, 3, 5, 7, 9), oddNumbersList);
    }
}