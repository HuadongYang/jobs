package com.object.duck.swing;

import com.object.duck.model.Pond;
import com.object.duck.scene.LifeTimeForDuck;

import javax.swing.*;

public class Test extends JFrame {
    private static final int WIDTH = 650;//界面的宽度
    private static final int HEIGHT = 600;//界面的高度
    public Test(){
        this.setSize(WIDTH, HEIGHT);//设置GUI界面的宽高
        this.setTitle("月夜");//设置标题
        this.setResizable(false);//设置窗口大小不可改变
        this.setLocationRelativeTo(null);//设置窗口位置居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭操作
        this.setVisible(true);//设置窗口可见
    }

    public static void main(String[] args) {
        Test test = new Test();

        test.ShowMoon();
    }

    private void ShowMoon(){
        LifeTimeForDuck lifeTimeForDuck = new LifeTimeForDuck();
        this.add(lifeTimeForDuck);
        Pond pond = new Pond();
        pond.setMinX(0);
        pond.setMaxX(100);
        pond.setMinY(0);
        pond.setMaxY(100);
        lifeTimeForDuck.lifeTime("aa", pond);
        /*Thread t = new Thread(panel);//启动面板的动画线程
        t.start();*/
    }

}
