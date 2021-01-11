package com.anshul.coffeevendingmachine.model;

import lombok.*;

import java.util.*;
import java.util.concurrent.*;

@Data
public class CoffeeMachine {
    private List<Beverage> beveragesToPrepare;
    private Integer noOfOutlets;
    private Inventory inventory;
    private ExecutorService executorService;

    public CoffeeMachine( Integer noOfOutlets,List<Beverage> beveragesToPrepare) {
        this.noOfOutlets = noOfOutlets;
        this.beveragesToPrepare = beveragesToPrepare;
        executorService = Executors.newFixedThreadPool(noOfOutlets);
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "CoffeeMachine{" +
                "noOfOutlets=" + noOfOutlets +
                ", inventory=" + inventory +
                '}';
    }
}
