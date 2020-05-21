package com.object.duck.scene.impl;

import com.object.duck.behave.LilyAppear;
import com.object.duck.behave.impl.LilyAppearImpl;
import com.object.duck.factory.LiLyFactory;
import com.object.duck.model.Lily;
import com.object.duck.model.Pond;
import com.object.duck.pool.LiLyPool;
import com.object.duck.scene.LifeTime;

import static com.object.duck.utils.Constants.LILY_THREAD_SLEEP_MILLS;
import static com.object.duck.utils.Constants.pond;

public class LifeTimeForLily implements LifeTime {

    @Override
    public void lifeTime(String name) {
        Lily lily = LiLyFactory.born(name);

        LilyAppear lilyAppear = new LilyAppearImpl(lily);
        lilyAppear.initPosition(pond);
        LiLyPool.registerLilyPool(lily);

        try {
            Thread.sleep(LILY_THREAD_SLEEP_MILLS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
