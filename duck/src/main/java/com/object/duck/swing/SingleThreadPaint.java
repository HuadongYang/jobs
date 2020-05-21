package com.object.duck.swing;

import javax.swing.*;

import static com.object.duck.utils.Constants.JFRAM_HEIGHT;
import static com.object.duck.utils.Constants.JFRAM_WIDTH;


public class SingleThreadPaint {


    public  void paint() {
        JFrame jFrame = new JFrame();
        jFrame.setSize(JFRAM_WIDTH, JFRAM_HEIGHT);//设置GUI界面的宽高
        jFrame.setTitle("pond");//设置标题
        jFrame.setResizable(false);//设置窗口大小不可改变
        jFrame.setLocationRelativeTo(null);//设置窗口位置居中
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭操作
        jFrame.setVisible(true);//设置窗口可见

        SceneJPanel sceneJPanel = new SceneJPanel();
        jFrame.add(sceneJPanel);
        sceneJPanel.pondScene();

    }
}
