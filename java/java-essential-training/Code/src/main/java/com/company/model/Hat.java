package com.company.model;

public class Hat extends ClothingItem{
    public Hat(ClothingSize size, int quantity, double price) {
        super(ClothingItem.HAT, size, quantity, price);
    }
}
