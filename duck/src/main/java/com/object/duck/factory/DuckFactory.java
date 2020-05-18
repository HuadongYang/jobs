package com.object.duck.factory;

import com.object.duck.model.Duck;
import com.object.duck.vo.DuckQueue;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-16 13:35
 **/
public class DuckFactory {

    public static Duck born(String name) {
        Duck duck = new Duck();
        duck.setName(name);
        duck.setType(Duck.DuckType.NORMAL);
        duck.setColor("#FFFF00");
        duck.setWeight(50);
        duck.setLatestEatDay(0);
        duck.setDuckQueue(new DuckQueue());
        return duck;
    }
}
