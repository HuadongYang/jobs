package com.object.duck.swing;

import com.object.duck.model.Duck;
import com.object.duck.pool.DuckPool;
import com.object.duck.vo.Position;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-18 23:33
 **/
public class JPanelTest extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);


        List<Duck> initDuckList = DuckPool.getInitDuckList();

        for(Duck duck : initDuckList) {
            Position currentPosition = duck.getCurrentPosition();
            Integer x = currentPosition.getX();
            Integer y = currentPosition.getY();
            g.setColor(Color.blue);//重新设定画笔颜色
            g.fillOval(x, y, 50, 50);//画一个实心圆
        }
    }

    public void showW(){
        while (true) {
            repaint();
        }
    }
}
