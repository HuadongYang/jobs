package com.object.duck;

import com.object.duck.model.Pond;
import com.object.duck.pool.DuckPool;
import com.object.duck.scene.LifeTimeForDuck;
import com.object.duck.scene.LifeTimeForLily;

import java.util.UUID;

/**
 * todo : step : 小于pond宽的一半
 *
 * @description:
 * @author: Yanghd
 * @create: 2020-05-16 00:29
 **/
public class Main {


    public static void main(String[] args) {
        Pond pond = new Pond();
        pond.setMinX(0);
        pond.setMaxX(100);
        pond.setMinY(0);
        pond.setMaxY(100);

        lilyThread(pond);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        duckThread(pond);
        duckPoolListenerThread();
    }

    private static void duckThread(Pond pond) {
        for (int i = 0; i < 30; i++) {
            Runnable duck = () -> {
                LifeTimeForDuck lifeTimeForDuck = new LifeTimeForDuck();
                lifeTimeForDuck.lifeTime(Thread.currentThread().getName(), pond);
            };
            new Thread(duck).start();
        }
    }

    private static void duckPoolListenerThread() {
        Runnable duckPoolThread = () -> {
            while (true) {
                DuckPool.run();
            }
        };
        new Thread(duckPoolThread).start();
    }

    private static void lilyThread(Pond pond) {
        Runnable lilyThread = () -> {
            while (true) {
                LifeTimeForLily lifeTimeForLily = new LifeTimeForLily();
                String name = String.valueOf(UUID.randomUUID().getLeastSignificantBits());
                lifeTimeForLily.lifeTime(name, pond);

            }
        };
        new Thread(lilyThread).start();
    }


}
