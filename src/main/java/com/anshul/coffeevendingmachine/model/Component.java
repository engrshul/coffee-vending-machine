package com.anshul.coffeevendingmachine.model;

public class Component {

    private Ingredient ingredient;
    private Double quantity;

    public Component(Ingredient ingredient, Double quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }
}
