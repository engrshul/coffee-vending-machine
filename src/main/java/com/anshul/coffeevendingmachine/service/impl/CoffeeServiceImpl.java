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
    public void processRequest(InputRequest inputRequest) {

        CoffeeMachine coffeeMachine=new CoffeeMachine(inputRequest.getNoOFOutlets());
        inventoryServiceImpl.refill(coffeeMachine,inputRequest.getTotalInventory());
        try {
            brew(coffeeMachine,inputRequest.getBeverageList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private void brew(CoffeeMachine coffeeMachine, List<Beverage> beverageList) throws InterruptedException {
        ExecutorService executorService=coffeeMachine.getExecutorService();
        List<Brew> listOfTasks = new ArrayList<>();
        for(Beverage beverage : beverageList) {
            listOfTasks.add(new Brew(coffeeMachine,beverage));
        }
        executorService.invokeAll(listOfTasks);
    }
}
