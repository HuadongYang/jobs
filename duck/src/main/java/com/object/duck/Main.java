package com.object.duck;

import com.object.duck.model.Pond;
import com.object.duck.pool.DuckPool;
import com.object.duck.scene.LifeTimeForDuck;
import com.object.duck.scene.LifeTimeForLily;
import com.object.duck.swing.SingleThreadPaint;

import java.util.UUID;

import static com.object.duck.utils.Constants.DUCK_COUNT;
import static com.object.duck.utils.Constants.pond;

/**
 * todo : step : 小于pond宽的一半
 *
 * @description:
 * @author: Yanghd
 * @create: 2020-05-16 00:29
 **/
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        main.lilyThread(pond);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        main.duckThread(pond);
        main.duckPoolListenerThread();
        main.swingThread();
    }

    private void swingThread() {
        SingleThreadPaint singleThreadPaint = new SingleThreadPaint();
        Runnable swing = () -> {
            singleThreadPaint.paint();
        };
        new Thread(swing).start();
    }

    private void duckThread(Pond pond) {
        for (int i = 0; i < DUCK_COUNT; i++) {
            LifeTimeForDuck lifeTimeForDuck = new LifeTimeForDuck();
            Runnable duck = () -> {
                lifeTimeForDuck.lifeTime(Thread.currentThread().getName(), pond);
            };
            new Thread(duck).start();
        }
    }

    private void duckPoolListenerThread() {
        Runnable duckPoolThread = () -> {
            while (true) {
                DuckPool.run();
            }
        };
        new Thread(duckPoolThread).start();
    }

    private void lilyThread(Pond pond) {
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
