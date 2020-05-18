package com.object.duck.behave.impl;

import com.object.duck.behave.DuckMove;
import com.object.duck.model.Duck;
import com.object.duck.model.Pond;
import com.object.duck.vo.Position;

import java.util.Random;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-16 13:39
 **/
public class DuckMoveImpl extends DuckMove {

    private Duck duck;

    public DuckMoveImpl(Duck duck) {
        super(duck);
        this.duck = duck;
    }

    @Override
    public void initPosition(Pond pond) {
        Random rand = new Random();
        Integer nextX = rand.nextInt(pond.getMaxX() - pond.getMinX()) + pond.getMinX();
        Integer nextY = rand.nextInt(pond.getMaxY() - pond.getMinY()) + pond.getMinY();

        duck.setCurrentPosition(new Position(nextX, nextY));
        //duck.setPrePosition(new Position(nextX, nextY));
    }

    @Override
    public void move(Pond pond, Integer step, double angle) {
        if (duck.getDuckQueue() == null || duck.getDuckQueue().getPreDuck() == null || duck.getType().equals(Duck.DuckType.HEAD)) {
            moveToNextPosition(pond, step, angle);
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

    private void moveToNextPosition(Pond pond, Integer step, double angle) {
        Position currentPosition = duck.getCurrentPosition();

        Position newPosition = calNewPosition(currentPosition, step, angle);

        boolean exceedPond = isExceedPond(newPosition, pond);

        if (exceedPond) {
            angle += 180;
            if (angle > 360) {
                angle -= 360;
            }
            newPosition = calNewPosition(currentPosition, step, angle);
            exceedPond = isExceedPond(newPosition, pond);
            if (!exceedPond) {
                duck.setPrePosition(duck.getCurrentPosition());
                duck.setCurrentPosition(newPosition);
            }


        }else {
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

    public Position calNewPosition(Position currentPosition, Integer step, double angle) {
        Integer addX = Double.valueOf(step*Math.cos(angle)).intValue();
        Integer addY = Double.valueOf(step*Math.sin(angle)).intValue();

        Position newPosition = new Position(currentPosition.getX(), currentPosition.getY());
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
