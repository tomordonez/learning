package com.tom.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalespersonTest {

    Salesperson salesperson = null;
    @BeforeEach
    void setUp() {
        salesperson = new Salesperson("Loki", 35, 114000);
    }

    @Test
    void raiseCommission() {
        salesperson.setCommissionPercentage(0.05);
        assertEquals(15700, salesperson.raiseCommission(10000));
    }
}