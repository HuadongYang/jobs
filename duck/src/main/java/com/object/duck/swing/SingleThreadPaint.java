package com.object.duck.swing;

import com.object.duck.model.Pond;
import com.object.duck.scene.LifeTimeForDuck;

import javax.swing.*;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-18 23:27
 **/
public class SingleThreadPaint {

    private static final int WIDTH = 650;//界面的宽度
    private static final int HEIGHT = 600;//界面的高度

    public  void paint() {
        JFrame jFrame = new JFrame();
        jFrame.setSize(WIDTH, HEIGHT);//设置GUI界面的宽高
        jFrame.setTitle("月夜");//设置标题
        jFrame.setResizable(false);//设置窗口大小不可改变
        jFrame.setLocationRelativeTo(null);//设置窗口位置居中
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭操作
        jFrame.setVisible(true);//设置窗口可见

        JPanelTest jPanelTest = new JPanelTest();
        jFrame.add(jPanelTest);
        jPanelTest.showW();

    }


}
