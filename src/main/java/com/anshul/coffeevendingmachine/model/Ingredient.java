package com.anshul.coffeevendingmachine.model;

import lombok.*;

import java.util.*;

@Getter
public class Ingredient {

    private String ingredientName;
    private Integer quantity;

    public Ingredient(String ingredientName, Integer quantity) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(ingredientName, that.ingredientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientName);
    }
}
