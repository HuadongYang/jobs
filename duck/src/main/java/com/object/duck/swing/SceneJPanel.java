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
public class SceneJPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        DuckPool duckPool = DuckPool.getInstance();
        List<Duck> initDuckList = duckPool.getFreeDuckList();

        for(Duck duck : initDuckList) {
            Position currentPosition = duck.getCurrentPosition();
            Integer x = currentPosition.getX();
            Integer y = currentPosition.getY();
            g.setColor(duck.getColor());//重新设定画笔颜色
            Integer duckSize = Double.valueOf(Math.sqrt(duck.getWeight())).intValue();
            g.fillOval(x, y, duckSize, duckSize);//画一个实心圆
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
