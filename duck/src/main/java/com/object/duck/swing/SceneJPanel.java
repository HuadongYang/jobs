package com.object.duck.swing;

import com.object.duck.model.Duck;
import com.object.duck.model.Lily;
import com.object.duck.model.Rock;
import com.object.duck.pool.DuckPool;
import com.object.duck.pool.LiLyPool;
import com.object.duck.vo.Position;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static com.object.duck.utils.Constants.*;

public class SceneJPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.blue);
        g.drawRect(pond.getMinX(), pond.getMinY(), pond.getMaxX(), pond.getMaxY());


        for (Rock rock : rockList) {
            g.setColor(Color.gray);
            g.fillOval(rock.getCurrentPosition().getX(), rock.getCurrentPosition().getY(), ROCK_SIZE_A, ROCK_SIZE_B);
        }

        DuckPool duckPool = DuckPool.getInstance();
        List<Duck> initDuckList = duckPool.getAllDuckList();

        for(Duck duck : initDuckList) {
            drawDuck(g, duck);

        }

        List<Lily> lilyList = LiLyPool.getLilyList();
        for (Lily lily : lilyList) {
            Position currentPosition = lily.getCurrentPosition();
            Integer x = currentPosition.getX();
            Integer y = currentPosition.getY();
            g.setColor(LILY_COLOR);
            g.fillArc(x, y, LILY_SIZE_X, LILY_SIZE_Y, 60, 60);
        }
    }

    private void drawDuck(Graphics g, Duck duck) {
        Position currentPosition = duck.getCurrentPosition();
        Integer x = currentPosition.getX();
        Integer y = currentPosition.getY();
        g.setColor(duck.getColor());
        Integer duckSize = Double.valueOf(Math.sqrt(duck.getWeight())).intValue();
        g.fillOval(x, y, duckSize, duckSize);
        g.setColor(Color.black);

        int eyeAX = x + duckSize/4;
        int eyeBX = x + duckSize*3/4;

        int eyeY = y + duckSize/4;
        ;
        int eyeSize = duckSize/6;
        g.fillOval(eyeAX,eyeY,  eyeSize,eyeSize);
        g.fillOval(eyeBX,eyeY, eyeSize,eyeSize);
    }

    public void pondScene(){
        while (true) {
            repaint();
        }
    }


}
