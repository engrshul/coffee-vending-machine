package com.anshul.coffeevendingmachine;

import com.anshul.coffeevendingmachine.input.*;
import com.anshul.coffeevendingmachine.model.*;
import com.anshul.coffeevendingmachine.service.*;
import com.anshul.coffeevendingmachine.service.impl.*;
import org.junit.*;
import java.io.*;
import java.util.*;

public class TestClass {

    @Test
    public void testWithTotalInventoryAsZero() throws FileNotFoundException {
        InputRequest inputRequest = InputProcessor.processInputRequest("src/main/resources/testWithTotalInventoryAsZero.json");
        CoffeeService service = new CoffeeServiceImpl();
        CoffeeMachine coffeeMachine = service.processRequest(inputRequest);
        int noOfBeveragesPrepared=0;
        List<Beverage> beverageList = coffeeMachine.getBeveragesToPrepare();
        for(Beverage beverage : beverageList) {
            if(beverage.isPrepared())
                ++noOfBeveragesPrepared;
        }
        Assert.assertEquals(0,noOfBeveragesPrepared);
    }

    @Test
    public void testWithOneBeverageAndSufficientQuantity() throws FileNotFoundException {
        InputRequest inputRequest = InputProcessor.processInputRequest("src/main/resources/testWithOneBeverageAndSufficientQuantity.json");
        CoffeeService service = new CoffeeServiceImpl();
        CoffeeMachine coffeeMachine = service.processRequest(inputRequest);
        int noOfBeveragesPrepared=0;
        List<Beverage> beverageList = coffeeMachine.getBeveragesToPrepare();
        for(Beverage beverage : beverageList) {
            if(beverage.isPrepared())
                ++noOfBeveragesPrepared;
        }
        Assert.assertEquals(1,noOfBeveragesPrepared);
    }


    @Test
    public void testInventoryStatusAfterConsumption() throws FileNotFoundException {
        InputRequest inputRequest = InputProcessor.processInputRequest("src/main/resources/testInventoryStatusAfterConsumption.json");
        CoffeeService service = new CoffeeServiceImpl();
        CoffeeMachine coffeeMachine = service.processRequest(inputRequest);
        int noOfBeveragesPrepared=0;
        List<Beverage> beverageList = coffeeMachine.getBeveragesToPrepare();
        for(Beverage beverage : beverageList) {
            if(beverage.isPrepared())
                ++noOfBeveragesPrepared;
        }
        Assert.assertEquals(1,noOfBeveragesPrepared);
        Map<Ingredient,Double> inventoryMap = coffeeMachine.getInventory().getInventoryMap();
        for (Ingredient ingredient : inventoryMap.keySet()) {
            if(inventoryMap.get(ingredient) !=500)
                Assert.fail("inventory consumption logic not wokig properly");
        }
    }
  }
