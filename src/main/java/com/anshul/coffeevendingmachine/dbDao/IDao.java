package com.anshul.coffeevendingmachine.dbDao;

import java.util.*;

/*
* Defined here some generic standard actions that can be performed
* on DB
* */
public interface IDao<T> {
    void create(T value);
    Optional<T> get(String id);
    public Collection<T> getAll();
    List<Optional<T>> getBatch(String id);
    void update(T value);
    void delete(String id);
}
