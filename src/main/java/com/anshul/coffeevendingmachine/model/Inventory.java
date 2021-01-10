package com.anshul.coffeevendingmachine.model;

import java.util.*;

public class Inventory {

    private  Map<Ingredient,Double> inventoryMap;;

    public Inventory() {
        inventoryMap = new HashMap<>();
    }

    public Map<Ingredient, Double> getInventoryMap() {
        return inventoryMap;
    }

    public void setInventoryMap(Map<Ingredient, Double> inventoryMap) {
        this.inventoryMap = inventoryMap;
    }
}
