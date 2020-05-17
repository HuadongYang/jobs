package com.object.duck.vo;

import com.object.duck.model.Duck;
import com.object.duck.model.Lily;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-16 13:26
 **/
public class ModelPool {

    private static ModelPool modelPool = new ModelPool();

    private List<Duck> duckPool;

    private List<Lily> lilyPool;


    private ModelPool() {

        this.duckPool = new CopyOnWriteArrayList<Duck>();
        this.lilyPool = new CopyOnWriteArrayList<Lily>();

    }

    public static ModelPool getModelPool() {
        return modelPool;
    }

    public void registerDuckPool(Duck duck) {
        duckPool.add(duck);
    }

    public void registerLilyPool(Lily lily) {
        lilyPool.add(lily);
    }



    public List<Lily> getLilyPool() {
        return lilyPool;
    }

}
