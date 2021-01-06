package com.anshul.coffeevendingmachine.db;

import com.anshul.coffeevendingmachine.model.*;
import java.util.*;

public class InMemoryDB {

    public static Map<String, Beverage> beverageDB = new HashMap<>();
    public static Map<String,Ingredient> ingredientDB = new HashMap<>();
    public static Map<String,CoffeeMachine>  coffeeMachineDB = new HashMap<>();
    public static Map<Ingredient,Integer> inventoryDB = new HashMap<>();
}
