package com.object.duck.factory;

import com.object.duck.behave.DuckMove;
import com.object.duck.behave.impl.DuckMoveImpl;
import com.object.duck.model.Duck;
import com.object.duck.model.Pond;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-16 13:35
 **/
public class DuckFactory {

    public static Duck born(String name, Pond pond) {
        Duck duck = new Duck();
        duck.setName(name);
        duck.setType(Duck.DuckType.NORMAL);
        duck.setColor("#FFFF00");
        duck.setWeight(10);
        duck.setLatestEatDay(0);
        return duck;
    }
}
