package com.anshul.coffeevendingmachine.input;

import com.google.gson.*;
import com.google.gson.stream.*;

import java.io.*;
import java.util.logging.*;

public class InputProcessor {
    public static void processInputRequest(String fileName) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(fileName) ;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        JsonReader jsonReader = new JsonReader(inputStreamReader);
        JsonObject jsonObject= JsonParser.parseReader(jsonReader).getAsJsonObject();
        // got master object
        JsonObject machine=jsonObject.getAsJsonObject("machine");
        // get all childs
        JsonObject outlets = machine.getAsJsonObject("outlets");
        JsonObject total_items_quantity = machine.getAsJsonObject("total_items_quantity");
        JsonObject beverages = machine.getAsJsonObject("beverages");

        // create input request
    }

    public static void main(String[] args) {
        try {
            processInputRequest("src/main/resources/input.json");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
