package com.tom.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalystTest {

    Analyst analyst = null;
    @BeforeEach
    void setUp() {
        analyst = new Analyst("Love", 10, 80000);
    }

    @Test
    void getAnnualBonus() {
        assertEquals(92000, analyst.getAnnualBonus());
    }
}