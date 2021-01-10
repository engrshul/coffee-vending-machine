package com.anshul.coffeevendingmachine.exceptions;

public class IngredientNotInStockException extends RuntimeException{
    public IngredientNotInStockException() {
        super("ingredient not in stock..");
    }
}
