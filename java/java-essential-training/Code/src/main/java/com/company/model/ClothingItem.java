package com.company.model;

public class ClothingItem {

    private String itemType;
    public static final String SHIRT = "Shirt";
    public static final String HAT = "Hat";

    private final ClothingSize size;
    private int quantity;
    private double price;

    public ClothingItem(String itemType, ClothingSize size, int quantity, double price) {
        this.itemType = itemType;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ClothingSize getSize() {
        return size;
    }
}
