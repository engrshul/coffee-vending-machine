package com.anshul.coffeevendingmachine.model;

import lombok.*;
import java.util.*;

@Data
public class Beverage {

    private String beverageName;
    private List<Component> components;
    private boolean isPrepared;

    public Beverage(String beverageName, List<Component> components) {
        this.beverageName = beverageName;
        this.components = components;
    }
}
