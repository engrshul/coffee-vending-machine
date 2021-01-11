package com.anshul.coffeevendingmachine.model;

import lombok.*;

@Getter
public class Component {

    private Ingredient ingredient;
    private Double quantity;

    public Component(Ingredient ingredient, Double quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Component{" +
                "ingredient=" + ingredient +
                ", quantity=" + quantity +
                '}';
    }
}
