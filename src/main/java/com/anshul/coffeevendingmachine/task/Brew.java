package com.anshul.coffeevendingmachine.task;

import com.anshul.coffeevendingmachine.model.*;

import java.util.concurrent.*;

public class Brew  implements Callable<Brew> {
    private CoffeeMachine machine;
    private Beverage beverage;

    public Brew(CoffeeMachine machine, Beverage beverage) {
        this.machine=machine;
        this.beverage = beverage;
    }


    @Override
    public Brew call() throws Exception {
        System.out.println("in call method");
        return null;
    }
}
