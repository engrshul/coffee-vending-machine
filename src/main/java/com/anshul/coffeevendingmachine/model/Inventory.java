package com.anshul.coffeevendingmachine.model;

import lombok.*;

import java.util.*;

@Data
public class Inventory {

    private List<Component> inventory;

    public Inventory(List<Component> inventory) {
        this.inventory = inventory;
    }
}
