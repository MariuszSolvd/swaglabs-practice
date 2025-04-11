package com.solvd.utilis.enums;

public enum Sorter {

    A_TO_Z("Name (A to Z)"),
    Z_TO_A("Name (Z to A)"),
    LOW_TO_HIGH("Price (low to high)"),
    HIGH_TO_LOW("Price (high to low)");

    private final String name;

    Sorter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
