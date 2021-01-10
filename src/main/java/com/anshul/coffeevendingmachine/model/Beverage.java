package com.anshul.coffeevendingmachine.model;

import java.util.*;

public class Beverage {

    private String beverageName;
    private List<Component> components;

    public Beverage(String beverageName, List<Component> components) {
        this.beverageName = beverageName;
        this.components = components;
    }


}
