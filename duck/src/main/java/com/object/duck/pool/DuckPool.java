package com.object.duck.pool;

import com.object.duck.model.Duck;
import com.object.duck.vo.ModelPool;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-17 22:22
 **/
public class DuckPool {
    private static List<Duck> duckList = new CopyOnWriteArrayList<Duck>();

    private DuckPool() {
    }

    public static void registerDuckPool(Duck duck) {
        duckList.add(duck);
    }

    public List<Duck> getDuckPool() {
        return duckList;
    }

}
