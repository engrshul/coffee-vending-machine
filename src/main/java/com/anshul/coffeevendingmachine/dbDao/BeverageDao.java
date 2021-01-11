package com.anshul.coffeevendingmachine.dbDao;

import com.anshul.coffeevendingmachine.model.*;
import java.util.*;

public class BeverageDao implements IDao<Beverage>{
    @Override
    public void create(Beverage value) {

    }

    @Override
    public Optional<Beverage> get(String id) {
        return Optional.empty();
    }

    @Override
    public Collection<Beverage> getAll() {
        return null;
    }

    @Override
    public List<Optional<Beverage>> getBatch(String id) {
        return null;
    }

    @Override
    public void update(Beverage value) {

    }

    @Override
    public void delete(String id) {

    }
}
