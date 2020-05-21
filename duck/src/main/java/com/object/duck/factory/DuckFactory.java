package com.object.duck.factory;

import com.object.duck.model.Duck;
import com.object.duck.vo.DuckQueue;

import static com.object.duck.utils.Constants.DUCK_INIT_COLOR;
import static com.object.duck.utils.Constants.DUCK_INIT_WEIGHT;


public class DuckFactory {

    public static Duck born(String name) {
        Duck duck = new Duck();
        duck.setName(name);
        duck.setType(Duck.DuckType.NORMAL);
        duck.setColor(DUCK_INIT_COLOR);
        duck.setWeight(DUCK_INIT_WEIGHT);
        duck.setLatestEatDay(0);
        duck.setDuckQueue(new DuckQueue());
        return duck;
    }
}
