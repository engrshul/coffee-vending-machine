package com.anshul.coffeevendingmachine.exceptions;

public class InsufficientIngredientQuantityException extends RuntimeException{
    public InsufficientIngredientQuantityException(String message) {
        super(message);
    }
}
