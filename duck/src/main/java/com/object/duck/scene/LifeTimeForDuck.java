package com.object.duck.scene;

import com.object.duck.behave.DuckMove;
import com.object.duck.behave.impl.DuckMoveImpl;
import com.object.duck.factory.DuckFactory;
import com.object.duck.model.Duck;
import com.object.duck.model.Lily;
import com.object.duck.model.Pond;
import com.object.duck.pool.DuckPool;
import com.object.duck.pool.LiLyPool;

import java.util.List;
import java.util.Random;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-16 13:25
 **/
public class LifeTimeForDuck {

    private static final Integer weightThresholdOfDeath = 5;
    private static final Integer weightThresholdOfHead = 50;

    private static final int deathInterval = 4;

    public void lifeTime(Pond pond) {

        Duck duck = DuckFactory.born(Thread.currentThread().getName(), pond);
        DuckPool.registerDuckPool(duck);

        DuckMove duckMove = new DuckMoveImpl(duck);

        duckMove.initPosition(pond);

        int day = 0;

        while (true) {

            if ((day - duck.getLatestEatDay()) > deathInterval) {
                duck.loseWeight();
            }

            List<Lily> lilies = LiLyPool.getLilyPool(duck.getCurrentPosition());

            for (Lily lily : lilies) {
                boolean release = LiLyPool.release(lily.getName());
                if (release) {
                    duck.grow();
                    duck.setLatestEatDay(day);
                }
            }

            duckMove.move(pond, 1, getRandomAngle());


            day ++;
        }

    }

    private Integer getRandomAngle() {
        Random rand = new Random();
        return rand.nextInt(360);
    }

}
