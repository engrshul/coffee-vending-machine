package com.anshul.coffeevendingmachine.exceptions;

public class CoffeeMachineNotAvailableException extends RuntimeException{
    public CoffeeMachineNotAvailableException() {
        super("please first create coffee machine..");
    }
}
