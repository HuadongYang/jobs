package com.object.duck.swing;

import com.object.duck.model.Duck;
import com.object.duck.model.Lily;
import com.object.duck.pool.DuckPool;
import com.object.duck.pool.LiLyPool;
import com.object.duck.vo.Position;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static com.object.duck.utils.Constants.*;

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
            g.setColor(duck.getColor());//重新设定画笔颜色
            g.fillOval(x, y, DUCK_SIZE_X, DUCK_SIZE_Y);//画一个实心圆
        }

        List<Lily> lilyList = LiLyPool.getLilyList();
        for (Lily lily : lilyList) {
            Position currentPosition = lily.getCurrentPosition();
            Integer x = currentPosition.getX();
            Integer y = currentPosition.getY();
            g.setColor(LILY_COLOR);//重新设定画笔颜色
            g.fillRect(x, y, LILY_SIZE_X, LILY_SIZE_Y);
        }
    }

    public void pondScene(){
        while (true) {
            repaint();
        }
    }
}
