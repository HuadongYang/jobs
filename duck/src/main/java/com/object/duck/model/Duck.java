package com.object.duck.model;

import com.object.duck.vo.DuckQueue;
import com.object.duck.vo.HeadDuckMessage;
import com.object.duck.vo.Position;

import java.awt.*;
import java.util.Objects;

import static com.object.duck.utils.Constants.*;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-15 23:23
 **/
public class Duck extends BaseModel{

    private String name;

    private Color color;

    private Integer weight;

    private Integer latestEatDay;

    private DuckType type;

    private Position prePosition;

    private DuckQueue duckQueue;


    public void receiveHeadMessage(HeadDuckMessage headDuckMessage) {

        this.duckQueue.setHead(headDuckMessage.getHead());

        this.duckQueue.setPreDuck(headDuckMessage.getPreDuck());
    }

    public void setDuckQueue(DuckQueue duckQueue) {
        this.duckQueue = duckQueue;
    }

    public void grow() {
        if (this.weight >= DUCK_LIMIT_WEIGHT) {
            return;
        }
        this.weight += DUCK_GROW_WEIGHT;
    }

    public DuckQueue getDuckQueue() {
        return duckQueue;
    }


    public Position getPrePosition() {
        return prePosition;
    }

    public void setPrePosition(Position prePosition) {
        this.prePosition = prePosition;
    }


    public void loseWeight() {
        this.weight -= DUCK_LOSE_WEIGHT;

    }

    public void die() {

    }

    public void whistles() {

    }

    public enum DuckType {
        HEAD,
        NORMAL;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Duck duck = (Duck) o;
        return this.name.equals(duck.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
