package com.anshul.coffeevendingmachine.task;

import com.anshul.coffeevendingmachine.model.*;
import com.anshul.coffeevendingmachine.service.impl.*;
import java.util.*;
import java.util.concurrent.*;

public class Brew  implements Callable<Void> {
    private CoffeeMachine machine;
    private Beverage beverage;

    public Brew(CoffeeMachine machine, Beverage beverage) {
        this.machine=machine;
        this.beverage = beverage;
    }

    @Override
    public Void call() throws Exception {
        Map<Ingredient,Double> totalInventory=machine.getInventory().getInventoryMap();
        List<Component> components=this.beverage.getComponents();
        InventoryServiceImpl serviceImpl = new InventoryServiceImpl();
        synchronized(CoffeeMachine.class) {
            boolean areAllIngredientsConsumed = true;
            for(Component component : components) {
                areAllIngredientsConsumed = areAllIngredientsConsumed && serviceImpl.consumeIngredient(machine,component);
                if(!areAllIngredientsConsumed){
                    beverage.setPrepared(false);
                    System.out.println(beverage.getBeverageName() +" can not be prepared because "+ component.getIngredient().getIngredientName()+ " is not available");
                    break;
                }
            }
            if(areAllIngredientsConsumed) {
                beverage.setPrepared(true);
                System.out.println(beverage.getBeverageName() +" is prepared");
            }
        }
        return null;
    }
}
