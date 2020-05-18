package com.object.duck.swing;

import javax.swing.*;
import java.awt.*;

public class GUI_Exp extends JFrame {

    private static final int WIDTH = 650;//界面的宽度
    private static final int HEIGHT = 600;//界面的高度


    public static void main(String[] args) {
        GUI_Exp ge = new GUI_Exp();
        ge.ShowMoon();
    }

    private void ShowMoon(){
        MyPanel panel = new MyPanel();//得到面板对象
        this.add(panel);//将面板加载到Frame主窗口里
        panel.draw();
        /*Thread t = new Thread(panel);//启动面板的动画线程
        t.start();*/
    }

    public GUI_Exp(){
        this.setSize(WIDTH, HEIGHT);//设置GUI界面的宽高
        this.setTitle("月夜");//设置标题
        this.setResizable(false);//设置窗口大小不可改变
        this.setLocationRelativeTo(null);//设置窗口位置居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭操作
        this.setVisible(true);//设置窗口可见
    }



}
