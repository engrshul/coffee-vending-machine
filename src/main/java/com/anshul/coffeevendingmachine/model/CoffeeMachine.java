package com.anshul.coffeevendingmachine.model;

import lombok.*;
import java.util.concurrent.*;

@Data
public class CoffeeMachine {

    private Integer machineId;
    private Integer noOfOutlets;
    private Inventory inventory;
    private ExecutorService executorService;

    public CoffeeMachine(Integer machineId, Integer noOfOutlets, Inventory inventory) {
        this.machineId = machineId;
        this.noOfOutlets = noOfOutlets;
        this.inventory=inventory;
        executorService = Executors.newFixedThreadPool(noOfOutlets);
    }
}
