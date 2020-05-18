package com.object.duck.model;

import com.object.duck.vo.Position;

public class BaseModel {
    private Position currentPosition;

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
}
