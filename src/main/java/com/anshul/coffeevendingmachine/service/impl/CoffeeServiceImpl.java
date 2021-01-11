package com.anshul.coffeevendingmachine.service.impl;

import com.anshul.coffeevendingmachine.input.*;
import com.anshul.coffeevendingmachine.model.*;
import com.anshul.coffeevendingmachine.service.*;
import com.anshul.coffeevendingmachine.task.*;
import java.util.*;
import java.util.concurrent.*;

public class CoffeeServiceImpl implements CoffeeService {

    public static final InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
    @Override
    public CoffeeMachine processRequest(InputRequest inputRequest) {

        CoffeeMachine coffeeMachine=new CoffeeMachine(inputRequest.getNoOFOutlets(),inputRequest.getBeverageList());
        inventoryServiceImpl.refill(coffeeMachine,inputRequest.getTotalInventory());
        try {
            brew(coffeeMachine);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return coffeeMachine;
    }
    private void brew(CoffeeMachine coffeeMachine) throws InterruptedException {
        ExecutorService executorService=coffeeMachine.getExecutorService();
        List<Brew> listOfTasks = new ArrayList<>();
        for(Beverage beverage : coffeeMachine.getBeveragesToPrepare()) {
            listOfTasks.add(new Brew(coffeeMachine,beverage));
        }
        executorService.invokeAll(listOfTasks);
        executorService.shutdown();
    }
}
