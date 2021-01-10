package com.anshul.coffeevendingmachine.service.impl;

import com.anshul.coffeevendingmachine.exceptions.*;
import com.anshul.coffeevendingmachine.model.*;
import com.anshul.coffeevendingmachine.service.*;
import lombok.*;

import java.util.*;

public class InventoryServiceImpl implements InventoryService {

    @Synchronized
    public void consumeIngredient(CoffeeMachine coffeeMachine,Component componentToConsume) {
        Map<Ingredient,Double> inventoryMap=coffeeMachine.getInventory().getInventoryMap();
        Ingredient ingredientToConsume = componentToConsume.getIngredient();
        Double quantityToConsume = componentToConsume.getQuantity();
        if(inventoryMap.containsKey(ingredientToConsume)) {
            if(inventoryMap.get(ingredientToConsume) < quantityToConsume)
                throw new InsufficientIngredientQuantityException();
            inventoryMap.put(ingredientToConsume,inventoryMap.get(ingredientToConsume)-quantityToConsume);
        }
        else {
            throw  new IngredientNotInStockException();
        }
    }


      // work before multithreading..so dont require synchhronization
    public void refill(CoffeeMachine coffeeMachine,List<Component> inventoryList) {
        Inventory inventory = new Inventory();

        Map<Ingredient,Double> inventoryMap=new HashMap<>();
        for(Component component : inventoryList) {
            Ingredient ingredient= component.getIngredient();
            inventoryMap.put(ingredient,inventoryMap.getOrDefault(ingredient,0.0)+component.getQuantity());
        }
        inventory.setInventoryMap(inventoryMap);
        coffeeMachine.setInventory(inventory);
    }
}
