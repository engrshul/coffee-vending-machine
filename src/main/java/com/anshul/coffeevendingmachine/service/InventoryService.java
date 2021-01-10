package com.anshul.coffeevendingmachine.service;

import com.anshul.coffeevendingmachine.model.*;

import java.util.*;

public interface InventoryService {
    void consumeIngredient(CoffeeMachine coffeeMachine,Component componentToConsume);
    void refill(CoffeeMachine coffeeMachine,List<Component> inventoryList);
}

