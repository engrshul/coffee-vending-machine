package com.anshul.coffeevendingmachine.exceptions;

public class InsufficientIngredientQuantityException extends RuntimeException{
    public InsufficientIngredientQuantityException() {
        super("please first create coffee machine..");
    }
}
