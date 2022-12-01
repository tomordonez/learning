package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUp() {
        System.out.println("Setting up");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down");
    }

    @Test
    void divide() {
        assertEquals(2, Calculator.divide(4, 2));
    }
}