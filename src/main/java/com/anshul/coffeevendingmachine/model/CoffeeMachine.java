package com.anshul.coffeevendingmachine.model;

import lombok.*;
import java.util.concurrent.*;

@Data
public class CoffeeMachine {

    private Integer noOfOutlets;
    private Inventory inventory;
    private ExecutorService executorService;

    public CoffeeMachine( Integer noOfOutlets) {
        this.noOfOutlets = noOfOutlets;
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
}
