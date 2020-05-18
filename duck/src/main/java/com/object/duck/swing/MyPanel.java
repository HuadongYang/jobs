package com.object.duck.swing;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel implements Runnable{

    int x = 0;
    int y = 0;
    int r = 50;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.red);//设定背景颜色
        /*g.setColor(Color.yellow);//设置画笔颜色
        g.fillOval(x, y+50, 100, 100);//画一个实心圆
        g.setColor(Color.blue);//重新设定画笔颜色
        g.fillOval(x, y, 2*r, 2*r);//画实心圆*/

        g.fillOval(x, y+50, 9, 9);//画一个实心圆
        //g.fillRect(x+20, y+100,10,30);

    }


    public void draw() {
        while(true){//月亮的位置一直向下移动
            x++;
            y++;
            if(x >this.getWidth()){//直到到达窗口边界
                x = 0;
                y = 0;
            }
            try {
                Thread.sleep(30);//暂停三秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();//三秒后重新开始
        }

    }

    //动画过程在线程内实现
    @Override
    public void run() {
        while(true){//月亮的位置一直向下移动
            x++;
            y++;
            if(x >this.getWidth()){//直到到达窗口边界
                x = 0;
                y = 0;
            }
            try {
                Thread.sleep(30);//暂停三秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();//三秒后重新开始
        }

    }




}
