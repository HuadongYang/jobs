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

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-16 13:25
 **/
public class LifeTimeForDuck extends JPanel {

    private static final Integer weightThresholdOfDeath = 5;
    private static final Integer weightThresholdOfHead = 80;

    private static final int deathInterval = 10;

    private Duck duck;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Position currentPosition = duck.getCurrentPosition();
        Integer x = currentPosition.getX();
        Integer y = currentPosition.getY();
        g.setColor(Color.blue);//重新设定画笔颜色
        g.fillOval(x, y, 50, 50);//画一个实心圆
        //g.fillRect(x+20, y+100,10,30);
    }

    public void lifeTime(String name, Pond pond) {

        Duck duck = DuckFactory.born(name);
        this.duck = duck;
        System.out.println("小鸭子出生，name:" + name);
        DuckPool.registerDuckInPool(duck);
        System.out.println("鸭子：" + name + "注册");

        DuckMove duckMove = new DuckMoveImpl(duck);

        duckMove.initPosition(pond);

        int day = 0;

        while (true) {
            //System.out.println("鸭子：" + name + " 位置:" + duck.getCurrentPosition());

            if (duck.getWeight() < weightThresholdOfDeath) {
                System.out.println("鸭子：" + name + " 要死了");
                DuckPool.releaseDuckFromPool(duck);
                return;
            }

            if (duck.getWeight() > weightThresholdOfHead && !duck.getType().equals(Duck.DuckType.HEAD)) {
                System.out.println("鸭子：" + name + " 成为头鸭了");
                duck.setType(Duck.DuckType.HEAD);
            }

            if ((day - duck.getLatestEatDay()) > deathInterval) {
                System.out.println("鸭子：" + name + " 好几天没吃东西，要瘦了");
                duck.loseWeight();
            }

            eatLily(duck, day);

            duckMove.move(pond, 5, getRandomAngle());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            day++;

            repaint();
        }

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

    private Integer getRandomAngle() {
        Random rand = new Random();
        return rand.nextInt(360);
    }




}
