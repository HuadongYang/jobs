package com.object.duck.scene;

import com.object.duck.behave.LilyAppear;
import com.object.duck.behave.impl.LilyAppearImpl;
import com.object.duck.factory.LiLyFactory;
import com.object.duck.model.Lily;
import com.object.duck.model.Pond;
import com.object.duck.pool.LiLyPool;

public class LifeTimeForLily {

    public void lifeTime(String name, Pond pond) {
        Lily lily = LiLyFactory.born(name);

        //System.out.println("睡莲："+name+" 出生了");
        LilyAppear lilyAppear = new LilyAppearImpl(lily);
        lilyAppear.initPosition(pond);
        LiLyPool.registerLilyPool(lily);

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
