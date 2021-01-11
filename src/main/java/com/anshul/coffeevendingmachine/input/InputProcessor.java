package com.anshul.coffeevendingmachine.input;

import com.anshul.coffeevendingmachine.model.*;
import com.google.gson.*;
import com.google.gson.stream.*;
import java.io.*;
import java.util.*;

public class InputProcessor {

    public static InputRequest processInputRequest(String fileName) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(fileName) ;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        JsonReader jsonReader = new JsonReader(inputStreamReader);
        JsonObject jsonObject= JsonParser.parseReader(jsonReader).getAsJsonObject();
        // got master object
        JsonObject machine=jsonObject.getAsJsonObject("machine");
        // get all childs
        JsonObject outletsJson = machine.getAsJsonObject("outlets");
        JsonObject totalInventoryJson = machine.getAsJsonObject("total_items_quantity");
        JsonObject beveragesJson = machine.getAsJsonObject("beverages");

        // get data to create input request
        List<Beverage> beveragesList = getBeveragesList(beveragesJson);
        List<Component> totalInventory = getTotalInventory(totalInventoryJson);
        InputRequest inputRequest = new InputRequest(beveragesList,totalInventory,outletsJson.get("count_n").getAsInt());
        return inputRequest;
    }

    private static List<Beverage> getBeveragesList(JsonObject beverageJson) {
       // System.out.println("going to process..");
        List<Beverage> beverageList = new ArrayList<>();
        for(String key :beverageJson.keySet()) {
            // System.out.println("key is"+key);
            List<Component> beverageComponents = new ArrayList<>();
            // for this beverage key lets get its composition..
            JsonObject composition = beverageJson.getAsJsonObject(key);
            // get each ingredient
            for(String ingredientName : composition.keySet()) {
                Ingredient ingredient = new Ingredient(ingredientName);
               // System.out.println(ingredient);
                Double qty =composition.get(ingredientName).getAsDouble();
                // System.out.println(qty);
                Component component = new Component(ingredient,qty);
                beverageComponents.add(component);
            }
            Beverage beverage = new Beverage(key,beverageComponents);
            beverageList.add(beverage);
        }
    return beverageList;
    }

    private static List<Component> getTotalInventory(JsonObject totalInventory) {
        List<Component>  stock = new ArrayList<>();
        for(String key : totalInventory.keySet()) {
            Double qty=totalInventory.get(key).getAsDouble();
            Component component = new Component(new Ingredient(key),qty);
            stock.add(component);
        }
        return stock;
    }

    public static void main(String[] args) {
        try {
            processInputRequest("src/main/resources/testInventoryStatusAfterConsumption.json");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
