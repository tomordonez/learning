package com.tom.S4_Polymorphism.oddarray;

import com.tom.S4_Polymorphism.oddarray.OddArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OddArrayListTest {

    OddArrayList oddList;
    @BeforeEach
    void setUp() {
        oddList = new OddArrayList();
    }

    @Test
    void addWithOneParameter_EvenNumber_ExceptionThrown() {
        oddList.add(2);
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> oddList.get(0));
        assertEquals("Index 0 out of bounds for length 0", exception.getMessage());
    }

    @Test
    void addWithOneParameter_OddNumber_NumberAdded() {
        oddList.add(1);
        assertEquals(1, oddList.get(0), "Number should have been an odd number (1)");
    }

    @Test
    void addWithTwoParameters_EvenNumber_ExceptionThrown() {
        oddList.add(0, 2);
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> oddList.get(0));
        assertEquals("Index 0 out of bounds for length 0", exception.getMessage());
    }

    @Test
    void addWithTwoParameters_OddNumber_NumberAdded() {
        oddList.add(0, 1);
        assertEquals(1, oddList.get(0), "Number should have been an odd number (1)");
    }

    @Test
    void addAllWithOneParameter_ListOddEven_ListOdd() {
        oddList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertEquals(Arrays.asList(1, 3, 5, 7, 9), oddList, "It should only contain odd numbers");
    }
}