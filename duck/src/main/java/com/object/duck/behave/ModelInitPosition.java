package com.object.duck.behave;

import com.object.duck.model.BaseModel;
import com.object.duck.model.Pond;
import com.object.duck.vo.Position;

import java.util.Random;

public abstract class ModelInitPosition {

    protected BaseModel model;

    public ModelInitPosition(BaseModel baseModel){
        this.model = baseModel;
    }

    public void initPosition(Pond pond) {
        Random rand = new Random();
        Integer nextX = rand.nextInt(pond.getMaxX() - pond.getMinX()) + pond.getMinX();
        Integer nextY = rand.nextInt(pond.getMaxY() - pond.getMinY()) + pond.getMinY();

        model.setCurrentPosition(new Position(nextX, nextY));
    }
}
