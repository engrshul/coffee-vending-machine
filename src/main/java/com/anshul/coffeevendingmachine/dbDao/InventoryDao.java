package com.anshul.coffeevendingmachine.dbDao;

import com.anshul.coffeevendingmachine.model.*;
import java.util.*;

public class InventoryDao implements IDao<Ingredient>{


    @Override
    public void create(Ingredient value) {

    }

    @Override
    public Optional<Ingredient> get(String id) {
        return Optional.empty();
    }

    @Override
    public Collection<Ingredient> getAll() {
        return null;
    }

    @Override
    public List<Optional<Ingredient>> getBatch(String id) {
        return null;
    }

    @Override
    public void update(Ingredient value) {

    }

    @Override
    public void delete(String id) {

    }
}
