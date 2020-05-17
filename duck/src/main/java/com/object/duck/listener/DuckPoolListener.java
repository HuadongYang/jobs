package com.object.duck.listener;

import com.object.duck.model.Duck;

import java.util.List;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-17 22:06
 **/
public class DuckPoolListener {
    private List<Duck> duckPool;
    public DuckPoolListener(List<Duck> duckPool) {
        this.duckPool = duckPool;
    }

    public void listen() {
        while (true) {

        }
    }
}
