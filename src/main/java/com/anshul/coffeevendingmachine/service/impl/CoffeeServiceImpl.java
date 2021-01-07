package com.anshul.coffeevendingmachine.service.impl;

import com.anshul.coffeevendingmachine.exceptions.*;
import com.anshul.coffeevendingmachine.input.*;
import com.anshul.coffeevendingmachine.model.*;
import com.anshul.coffeevendingmachine.service.*;

public class CoffeeServiceImpl implements CoffeeService {

    @Override
    public void processRequest(InputRequest inputRequest) {
        // create inventory
        Inventory inventory = new Inventory(inputRequest.getTotalInventory());
        // create coffee machine and provide coffee machine inventory
        CoffeeMachine coffeeMachine=new CoffeeMachine(inputRequest.getMachineId(),inputRequest.getNoOFOutlets(),inventory);

    }
}
