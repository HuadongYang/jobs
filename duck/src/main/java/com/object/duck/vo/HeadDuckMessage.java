package com.object.duck.vo;

import com.object.duck.model.Duck;

public class HeadDuckMessage {

    private Duck head;

    private Duck preDuck;

    public HeadDuckMessage(Duck head, Duck preDuck) {
        this.head = head;
        this.preDuck = preDuck;
    }

    /* private Integer index;

        private Integer queueSize;
    */
    public Duck getHead() {
        return head;
    }

    public void setHead(Duck head) {
        this.head = head;
    }

    public Duck getPreDuck() {
        return preDuck;
    }

    public void setPreDuck(Duck preDuck) {
        this.preDuck = preDuck;
    }
}
