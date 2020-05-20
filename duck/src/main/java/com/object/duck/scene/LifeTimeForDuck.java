package com.object.duck.scene;

import com.object.duck.behave.DuckMove;
import com.object.duck.behave.Whistle;
import com.object.duck.behave.impl.DuckMoveImpl;
import com.object.duck.behave.impl.WhistleImpl;
import com.object.duck.factory.DuckFactory;
import com.object.duck.model.Duck;
import com.object.duck.model.Lily;
import com.object.duck.model.Pond;
import com.object.duck.pool.DuckPool;
import com.object.duck.pool.LiLyPool;
import com.object.duck.vo.DuckWeight;
import com.object.duck.vo.Position;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.object.duck.utils.Constants.*;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-16 13:25
 **/
public class LifeTimeForDuck {

    public void lifeTime(String name, Pond pond) {

        DuckPool duckPool = DuckPool.getInstance();

        Duck duck = DuckFactory.born(name);
        System.out.println("小鸭子出生，name:" + name);
        duckPool.registerDuckInPool(duck);
        System.out.println("鸭子：" + name + "注册");

        DuckMove duckMove = new DuckMoveImpl(duck);
        Whistle whistle = new WhistleImpl();

        duckMove.initPosition(pond);

        int day = 0;

        while (true) {

            Integer weight = duck.getWeight();
            if (weight < DUCK_DEATH_WEIGHT) {
                System.out.println("鸭子：" + name + " 要死了");
                duckPool.releaseDuckFromPool(duck);
                return;
            }

            if (weight > DUCK_THIN_WEIGHT && weight < DUCK_HEAD_WEIGHT) {
                duck.setColor(DUCK_INIT_COLOR);
            }

            if (weight > DUCK_HEAD_WEIGHT && !duck.getType().equals(Duck.DuckType.HEAD)) {
                System.out.println("鸭子：" + name + " 成为头鸭了");
                toBeHeadDuck(duck, whistle);
            }

            if (weight < DUCK_HEAD_WEIGHT && duck.getType().equals(Duck.DuckType.HEAD)) {
                System.out.println("头鸭：" + name + " 变为普通鸭子");
                headToBeNormal(duck, duckPool);
            }

            if ((day - duck.getLatestEatDay()) > DUCK_LOSE_WEIGHT_INTERVAL_DAY) {
                duck.loseWeight();
                duck.setLatestEatDay(day);

            }
            if (weight < DUCK_THIN_WEIGHT && !duck.getColor().equals(DUCK_THIN_COLOR)) {
                toBeThinDuck(duck, duckPool);
            }

            eatLily(duck, day);
            duckMove.move(pond, DUCK_MOVE_STEP);
            try {
                Thread.sleep(DUCK_THREAD_SLEEP_MILLS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            day++;

        }

    }

    private void toBeThinDuck(Duck duck, DuckPool duckPool) {
        randomAngle(duck);
        duck.setColor(DUCK_THIN_COLOR);

        if(duck.getDuckQueue() != null && duck.getDuckQueue().getHead() != null) {
            duckPool.queueToFree(duck);
        }

    }

    private void randomAngle(Duck duck) {
        Random rand = new Random();
        Position currentPosition = duck.getCurrentPosition();
        currentPosition.setAngle(rand.nextInt(360));
    }

    private void setColor(Duck duck) {
        Integer weight = duck.getWeight();
        for (Map.Entry<DuckWeight, Color> entry : weightColorMap.entrySet()) {
            DuckWeight key = entry.getKey();
            if (weight > key.getLowerLimit() && weight <= key.getUpperLimit()) {
                duck.setColor(entry.getValue());
                break;
            }
        }
    }

    private void toBeHeadDuck(Duck duck, Whistle whistle){
        duck.setType(Duck.DuckType.HEAD);
        duck.setColor(DUCK_HEAD_COLOR);

        randomAngle(duck);

        whistle.whistle();
    }

    private void headToBeNormal(Duck duck, DuckPool duckPool) {
        duck.setType(Duck.DuckType.HEAD);
        duck.setColor(DUCK_INIT_COLOR);
        duckPool.dismissAndJoinOtherLine(duck);
    }

    private void eatLily(Duck duck, int day) {
        List<Lily> lilies = LiLyPool.getLilyPool(duck);

        for (Lily lily : lilies) {
            boolean release = LiLyPool.release(lily);
            if (release) {
                duck.grow();
                duck.setLatestEatDay(day);
            }
        }
    }




}
