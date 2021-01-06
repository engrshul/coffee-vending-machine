package com.anshul.coffeevendingmachine.dbDao;

import com.anshul.coffeevendingmachine.db.*;
import com.anshul.coffeevendingmachine.model.*;

public class InventoryDao implements IDao<Ingredient>{

    @Override
    public void create(Ingredient ingredient) {
        InMemoryDB.inventoryDB.put(ingredient,ingredient.getQuantity());
    }
}
