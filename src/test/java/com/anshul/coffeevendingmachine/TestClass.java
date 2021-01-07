package com.anshul.coffeevendingmachine;

import com.anshul.coffeevendingmachine.input.*;
import com.anshul.coffeevendingmachine.model.*;
import com.anshul.coffeevendingmachine.service.*;
import com.anshul.coffeevendingmachine.service.impl.*;
import java.io.*;

// treat it as controller
public class TestClass {
    public static void main(String[] args) throws FileNotFoundException {

        InputRequest inputRequest = InputProcessor.processInputRequest("src/main/resources/input.json");

        CoffeeService service = new CoffeeServiceImpl();
        service.processRequest(inputRequest);

    }
}
