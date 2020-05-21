package com.object.duck.factory;

import com.object.duck.model.Lily;


public class LiLyFactory {

    public static Lily born(String name){
        Lily lily = new Lily();
        lily.setName(name);
        return lily;
    }

}
