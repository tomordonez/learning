package com.company.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClothingItemTest {

    ClothingItem item = null;

    @BeforeEach
    void setup() {
        item = new ClothingItem(ClothingItem.SHIRT, ClothingSize.L, 2, 55.45);
    }

    @Test
    void getItemType() {
        assertEquals("Shirt", item.getItemType());
    }

    @Test
    void getSize() {
        assertEquals(ClothingSize.L, item.getSize());
    }

    @Test
    void getQuantity() {
        assertEquals(2, item.getQuantity());
    }

    @Test
    void getPrice() {
        assertEquals(55.45, item.getPrice());
    }
}