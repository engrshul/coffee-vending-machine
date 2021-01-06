package com.anshul.coffeevendingmachine.model;

import java.util.concurrent.*;

public class CoffeeMachine {

    private Integer id;
    private Integer noOfOutlets;
    private ExecutorService executorService;

    public CoffeeMachine(Integer id, Integer noOfOutlets) {
        this.id = id;
        this.noOfOutlets = noOfOutlets;
    }
}
