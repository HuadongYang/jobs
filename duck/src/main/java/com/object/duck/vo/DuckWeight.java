package com.object.duck.vo;

public class DuckWeight {
    private Integer upperLimit;
    private Integer lowerLimit;

    public DuckWeight(Integer lowerLimit, Integer upperLimit) {
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Integer getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Integer lowerLimit) {
        this.lowerLimit = lowerLimit;
    }
}
