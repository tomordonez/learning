package com.company;

import com.company.model.ClothingItem;
import com.company.model.ClothingSize;
import com.company.model.Hat;
import com.company.model.Shirt;

import java.text.NumberFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] colors = new String[3];
        colors[0] = "rojo";
        colors[1] = "azul";
        colors[2] = "verde";

        for (String color : colors) {
            System.out.println(color);
        }

        List<String> colorsList = new ArrayList<>();
        colorsList.add("Blanco");
        colorsList.add("Amarillo");
        colorsList.add("Gris");

        for (String color : colorsList) {
            System.out.println(color);
        }

        List<ClothingItem> itemsList = new ArrayList<>();
        itemsList.add(new Shirt(
                ClothingSize.L,
                2,
                55.56));
        itemsList.add(new Hat(
                ClothingSize.M,
                1,
                25.99));

        for (ClothingItem item : itemsList) {
            displayItemDetails(item);
        }

        List<ClothingItem> itemsLinkedList = new LinkedList<>();
        itemsLinkedList.add(new Shirt(
                ClothingSize.S,
                1,
                250.33));
        itemsLinkedList.add(new Hat(
                ClothingSize.L,
                1,
                50.99));

        for (ClothingItem item : itemsLinkedList) {
            displayItemDetails(item);
        }

        Map<String, ClothingItem> itemsMap = new HashMap<>();
        itemsMap.put("Shirt", new Shirt(
                ClothingSize.S,
                1,
                123.45));
        itemsMap.put("Hat", new Hat(
                ClothingSize.L,
                1,
                50.99));

        displayItemDetails(itemsMap.get("Shirt"));

        var keys = itemsMap.keySet();
        for (String key : keys) {
            displayItemDetails(itemsMap.get(key));
        }
    }

    private static void displayItemDetails(ClothingItem item) {
        var totalPrice = item.getQuantity() * item.getPrice();

        var priceCurrencyFormat = NumberFormat.getCurrencyInstance();
        var output = String.format("Item: %s. Size: %s. Qty: %s. Total price: %s",
                item.getItemType(),
                item.getSize(),
                item.getQuantity(),
                priceCurrencyFormat.format(totalPrice));

        System.out.println(output);
    }

}
