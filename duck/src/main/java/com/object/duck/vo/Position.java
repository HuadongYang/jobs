package com.object.duck.vo;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-16 00:53
 **/
public class Position {
    private Integer x;

    private Integer y;

    public Position(){}

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEquals(Position other) {
        if (this.x != null && this.y != null && other.getX() != null && other.getY() != null
        && this.x.equals(other.getX()) && this.y.equals(other.getY())) {
            return true;
        }
        return false;
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
}
