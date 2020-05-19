package com.object.duck.behave.impl;

import com.object.duck.behave.DuckMove;
import com.object.duck.model.Duck;
import com.object.duck.model.Pond;
import com.object.duck.vo.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-16 13:39
 **/
public class DuckMoveImpl extends DuckMove {

    private Duck duck;
    private static List<Integer> spinAngles = new ArrayList<>();
    static {
        spinAngles.add(0);
        spinAngles.add(90);
        spinAngles.add(180);
        spinAngles.add(270);
    }

    public DuckMoveImpl(Duck duck) {
        super(duck);
        this.duck = duck;
    }

    @Override
    public void move(Pond pond, Integer step) {
        if (duck.getDuckQueue() == null || duck.getDuckQueue().getPreDuck() == null || duck.getType().equals(Duck.DuckType.HEAD)) {
            moveToNextPosition(pond, step);
        }else {
            followPreDuck(duck.getDuckQueue().getPreDuck());
        }
    }

    private void followPreDuck(Duck preDuck) {

        if (preDuck.getPrePosition() == null) {
            return;
        }
        duck.setPrePosition(duck.getCurrentPosition());
        duck.setCurrentPosition(preDuck.getPrePosition());
    }

    private void moveToNextPosition(Pond pond, Integer step) {
        Position currentPosition = duck.getCurrentPosition();
        for (Integer spinAngle : spinAngles) {
            int ajustAngle = currentPosition.getAngle() + spinAngle;
            if (ajustAngle > 360) {
                ajustAngle -= 360;
            }
            currentPosition.setAngle(ajustAngle);
            
            Position newPosition = calNewPosition(currentPosition, step);
            boolean exceedPond = isExceedPond(newPosition, pond);
            if (exceedPond) {
                continue;
            }
            duck.setPrePosition(duck.getCurrentPosition());
            duck.setCurrentPosition(newPosition);
        }
    }

    private boolean isExceedPond(Position position, Pond pond) {
        if (position.getX() <= pond.getMinX() || position.getX() >= pond.getMaxX()) {
            return true;
        }

        if (position.getY() <= pond.getMinY() || position.getY() >= pond.getMaxY()) {
            return true;
        }

        return false;
    }

    public Position calNewPosition(Position currentPosition, Integer step) {
        Integer angle = currentPosition.getAngle();
        Integer addX = Double.valueOf(step*Math.cos(angle)).intValue();
        Integer addY = Double.valueOf(step*Math.sin(angle)).intValue();

        Position newPosition = new Position(currentPosition.getX(), currentPosition.getY(), currentPosition.getAngle());
        if (angle > 90 && angle < 270) {
            Integer newX = currentPosition.getX() - addX;
            newPosition.setX(newX);
        }else {
            Integer newX = currentPosition.getX() + addX;
            newPosition.setX(newX);
        }

        if (angle > 0 && angle < 180) {
            Integer newY = currentPosition.getY() + addY;
            newPosition.setY(newY);
        }else {
            Integer newY = currentPosition.getY() - addY;
            newPosition.setY(newY);
        }

        return newPosition;



    }

}
