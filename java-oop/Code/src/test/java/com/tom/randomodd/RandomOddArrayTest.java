package com.tom.randomodd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomOddArrayTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void randomOddArray_ArrayOddEvenNumbers_RemoveEvenNumbers() {
        RandomOddArray oddEvenNumbers = new RandomOddArray(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> oddNumbers = Arrays.asList(1, 3, 5);
        assertEquals(oddNumbers, oddEvenNumbers, "Constructor should remove even numbers");
    }
}