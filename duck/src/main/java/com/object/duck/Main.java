package com.object.duck;

import com.object.duck.listener.DuckPoolListener;
import com.object.duck.pool.DuckPool;
import com.object.duck.scene.LifeTime;
import com.object.duck.scene.impl.LifeTimeForDuck;
import com.object.duck.scene.impl.LifeTimeForLily;
import com.object.duck.swing.SingleThreadPaint;

import java.util.UUID;

import static com.object.duck.utils.Constants.DUCK_COUNT;


public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        main.lilyThread();
        main.duckThread();
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

    private void duckThread() {
        for (int i = 0; i < DUCK_COUNT; i++) {
            LifeTime lifeTimeForDuck = new LifeTimeForDuck();
            Runnable duck = () -> {
                lifeTimeForDuck.lifeTime(Thread.currentThread().getName());
            };
            new Thread(duck).start();
        }
    }

    private void duckPoolListenerThread() {
        DuckPool duckPool = DuckPool.getInstance();
        Runnable duckPoolThread = () -> {
            new DuckPoolListener(duckPool).listen();
        };
        new Thread(duckPoolThread).start();
    }

    private void lilyThread() {
        Runnable lilyThread = () -> {
            while (true) {
                LifeTime lifeTimeForLily = new LifeTimeForLily();
                String name = String.valueOf(UUID.randomUUID().getLeastSignificantBits());
                lifeTimeForLily.lifeTime(name);
            }
        };
        new Thread(lilyThread).start();
    }


}
