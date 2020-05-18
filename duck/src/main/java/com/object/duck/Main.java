package com.object.duck;

import com.object.duck.model.Pond;
import com.object.duck.pool.DuckPool;
import com.object.duck.scene.LifeTimeForDuck;
import com.object.duck.scene.LifeTimeForLily;

import javax.swing.*;
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
public class Main extends JFrame {
    private static final int WIDTH = 650;//界面的宽度
    private static final int HEIGHT = 600;//界面的高度

    public Main(){
        this.setSize(WIDTH, HEIGHT);//设置GUI界面的宽高
        this.setTitle("月夜");//设置标题
        this.setResizable(false);//设置窗口大小不可改变
        this.setLocationRelativeTo(null);//设置窗口位置居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭操作
        this.setVisible(true);//设置窗口可见
    }




    public static void main(String[] args) {
        Main main = new Main();

        main.lilyThread(pond);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        main.duckThread(pond);
        main.duckPoolListenerThread();
    }

    private void duckThread(Pond pond) {
        for (int i = 0; i < DUCK_COUNT; i++) {
            LifeTimeForDuck lifeTimeForDuck = new LifeTimeForDuck();
            this.add(lifeTimeForDuck);
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
