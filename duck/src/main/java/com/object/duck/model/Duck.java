package com.object.duck.model;

import com.object.duck.vo.Position;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-15 23:23
 **/
public class Duck {

    private String name;

    private String color;

    private Integer weight;

    private Integer latestEatDay;

    private DuckType type;

    private Position currentPosition;

    private Position prePosition;

    private Duck preDuck;

    private Duck nextDuck;

    private Duck headDuck;

    public void grow() {
        this.weight += 5;
    }



    public Position getPrePosition() {
        return prePosition;
    }

    public void setPrePosition(Position prePosition) {
        this.prePosition = prePosition;
    }

    public Duck getHeadDuck() {
        return headDuck;
    }

    public void setHeadDuck(Duck headDuck) {
        this.headDuck = headDuck;
    }

    public Duck getPreDuck() {
        return preDuck;
    }

    public void setPreDuck(Duck preDuck) {
        this.preDuck = preDuck;
    }

    public Duck getNextDuck() {
        return nextDuck;
    }

    public void setNextDuck(Duck nextDuck) {
        this.nextDuck = nextDuck;
    }


    public void loseWeight() {
        this.weight -= 3;

    }

    public void die() {

    }

    public void whistles() {

    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position getCurrentPosition() {
        return this.currentPosition;
    }


    public static enum DuckType {
        HEAD,
        NORMAL;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getLatestEatDay() {
        return latestEatDay;
    }

    public void setLatestEatDay(Integer latestEatDay) {
        this.latestEatDay = latestEatDay;
    }

    public DuckType getType() {
        return type;
    }

    public void setType(DuckType type) {
        this.type = type;
    }
}
