package com.tom.randomodd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    void createRandomIntegerList_SeedNumber_IntegerList() {
        ArrayList<Integer> randomIntegerList = RandomOddArray.createRandomIntegerList(5);
        // The only way to find this array was by implementing the method in the first place
        ArrayList<Integer> expectedIntegerList = new ArrayList<>(Arrays.asList(7, 2, 4, 4, 6, 5, 4, 1, 2, 1));
        assertEquals(expectedIntegerList, randomIntegerList, "ArrayList should be of same size and values");
    }
}