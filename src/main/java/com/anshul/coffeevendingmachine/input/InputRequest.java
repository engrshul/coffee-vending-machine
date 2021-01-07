package com.anshul.coffeevendingmachine.input;

import com.anshul.coffeevendingmachine.model.*;
import lombok.*;
import java.util.*;

@Data
public class InputRequest {
    private Integer machineId;
    private List<Beverage> beverageList;
    private Integer noOFOutlets;
    private List<Component> totalInventory;

    public InputRequest(Integer machineId,List<Beverage> beverageList, List<Component> totalInventory, Integer noOFOutlets) {
        this.machineId=machineId;
        this.beverageList = beverageList;
        this.noOFOutlets = noOFOutlets;
        this.totalInventory = totalInventory;
    }
}
