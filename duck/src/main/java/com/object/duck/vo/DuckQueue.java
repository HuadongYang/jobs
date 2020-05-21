package com.object.duck.vo;

import com.object.duck.model.Duck;

public class DuckQueue {
    private Duck Head;

    private Duck preDuck;

    public Duck getHead() {
        return Head;
    }

    public void setHead(Duck head) {
        Head = head;
    }

    public Duck getPreDuck() {
        return preDuck;
    }

    public void setPreDuck(Duck preDuck) {
        this.preDuck = preDuck;
    }
}
