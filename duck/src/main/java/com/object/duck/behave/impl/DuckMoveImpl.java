package com.object.duck.behave.impl;

import com.object.duck.behave.DuckMove;
import com.object.duck.model.Duck;
import com.object.duck.model.Rock;
import com.object.duck.vo.Position;

import java.util.ArrayList;
import java.util.List;

import static com.object.duck.utils.Constants.*;


public class DuckMoveImpl extends DuckMove {

    private Duck duck;
    private static List<Integer> spinAngles = new ArrayList<>();
    static {
        spinAngles.add(0);
        spinAngles.add(90);
        spinAngles.add(90);
        spinAngles.add(90);
    }

    public DuckMoveImpl(Duck duck) {
        super(duck);
        this.duck = duck;
    }

    @Override
    public void move(Integer step) {
        if (duck.getDuckQueue() == null || duck.getDuckQueue().getPreDuck() == null || duck.getType().equals(Duck.DuckType.HEAD)) {
            moveToNextPosition(step);
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

    private void moveToNextPosition(Integer step) {
        Position currentPosition = duck.getCurrentPosition();
        for (Integer spinAngle : spinAngles) {
            int ajustAngle = currentPosition.getAngle() + spinAngle;
            if (ajustAngle > 360) {
                ajustAngle -= 360;
            }
            currentPosition.setAngle(ajustAngle);
            
            Position newPosition = calNewPosition(currentPosition, step);
            boolean exceedPond = isExceed(newPosition);
            if (exceedPond) {
                continue;
            }
            duck.setPrePosition(duck.getCurrentPosition());
            duck.setCurrentPosition(newPosition);
            break;
        }
    }

    private boolean isExceed(Position position) {
        return  isExceedPond(position) || isStruckRock(position);
    }

    private boolean isExceedPond(Position position) {
        Integer duckSize = Double.valueOf(Math.sqrt(duck.getWeight())).intValue();

        if ((position.getX() - duckSize) < pond.getMinX() || (position.getX() + duckSize) >= pond.getMaxX()) {
            return true;
        }

        if ((position.getY() - duckSize) < pond.getMinY() || (position.getY() + duckSize) >= pond.getMaxY()) {
            return true;
        }

        return false;
    }
    private boolean isStruckRock(Position currentPosition) {
        Integer xDuck = currentPosition.getX();
        Integer yDuck = currentPosition.getY();
        for (Rock rock : rockList) {
            Integer xRock = rock.getCurrentPosition().getX();
            Integer yRock = rock.getCurrentPosition().getY();

            int value = (xDuck - xRock) * (xDuck - xRock) / (ROCK_SIZE_A * ROCK_SIZE_A) + (yDuck - yRock) * (yDuck - yRock) / (ROCK_SIZE_B * ROCK_SIZE_B);
            if (value < 1) {
                return true;
            }
        }
        return false;
    }
    public Position calNewPosition(Position currentPosition, Integer step) {
        Integer angle = currentPosition.getAngle();
        Integer addX = Double.valueOf(step*Math.cos(angle)).intValue();
        if (addX < 0 ) {
            addX = 0 - addX;
        }
        Integer addY = Double.valueOf(step*Math.sin(angle)).intValue();
        if (addY < 0 ){
            addY = 0-addY;
        }

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
