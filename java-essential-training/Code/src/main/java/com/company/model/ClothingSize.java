package com.company.model;

public enum ClothingSize {
    S("Small"), L("Large"), M("Medium");
    private final String description;

    ClothingSize(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
