package com.object.duck.scene;

import com.object.duck.behave.DuckMove;
import com.object.duck.behave.impl.DuckMoveImpl;
import com.object.duck.factory.DuckFactory;
import com.object.duck.model.Duck;
import com.object.duck.model.Lily;
import com.object.duck.model.Pond;
import com.object.duck.pool.DuckPool;
import com.object.duck.pool.LiLyPool;
import com.object.duck.vo.Position;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

import static com.object.duck.utils.Constants.*;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-16 13:25
 **/
public class LifeTimeForDuck {

    public void lifeTime(String name, Pond pond) {

        Duck duck = DuckFactory.born(name);
        System.out.println("小鸭子出生，name:" + name);
        DuckPool.registerDuckInPool(duck);
        System.out.println("鸭子：" + name + "注册");

        DuckMove duckMove = new DuckMoveImpl(duck);

        duckMove.initPosition(pond);

        int day = 0;

        while (true) {

            if (duck.getWeight() < WEIGHT_THRESHOLD_OF_DEATH) {
                System.out.println("鸭子：" + name + " 要死了");
                DuckPool.releaseDuckFromPool(duck);
                return;
            }

            if (duck.getWeight() > WEIGHT_THRESHOLD_OF_HEAD && !duck.getType().equals(Duck.DuckType.HEAD)) {
                System.out.println("鸭子：" + name + " 成为头鸭了");
                toBeHeadDuck(duck, duckMove);
            }

           /* if (duck.getName().equals("Thread-6") && !duck.getType().equals(Duck.DuckType.HEAD)){
                System.out.println("鸭子：" + name + " 成为头鸭了");
                toBeHeadDuck(duck, duckMove);
            }*/

            if ((day - duck.getLatestEatDay()) > DEATH_INTERVAL) {
                System.out.println("鸭子：" + name + " 好几天没吃东西，要瘦了");
                duck.loseWeight();
            }

            if (duck.getWeight() < DUCK_THIN_WEIGHT && !duck.getColor().equals(DUCK_THIN_COLOR)) {
                System.out.println("鸭子：" + name + " 已经很瘦了");
                duck.setColor(DUCK_THIN_COLOR);
            }

            eatLily(duck, day);

            duckMove.move(pond, DUCK_STEP);
            try {
                Thread.sleep(DUCK_THREAD_SLEEP_MILLS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            day++;

        }

    }

    private void toBeHeadDuck(Duck duck, DuckMove duckMove){
        duck.setType(Duck.DuckType.HEAD);
        duck.setColor(DUCK_HEAD_COLOR);
        duckMove.initPosition(pond);
    }

    private void eatLily(Duck duck, int day) {
        List<Lily> lilies = LiLyPool.getLilyPool(duck.getCurrentPosition());

        for (Lily lily : lilies) {
            boolean release = LiLyPool.release(lily.getName());
            if (release) {
                duck.grow();
                duck.setLatestEatDay(day);
            }
        }
    }




}
