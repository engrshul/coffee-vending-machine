package com.anshul.coffeevendingmachine.dbDao;
/*
* Defined here some generic standard actions that can be performed
* on DB
* */
public interface IDao<T> {
    void create(T value);
}
