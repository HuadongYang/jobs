package com.object.duck.vo;

public class Position {
    private Integer x;

    private Integer y;

    private Integer angle;

    public Position(int x, int y, int angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public Integer getAngle() {
        return angle;
    }

    public void setAngle(Integer angle) {
        this.angle = angle;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        String json = "x:[" + x + "], y:[" + y + "]";
        return json;
    }
}
