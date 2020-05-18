package com.object.duck.factory;

import com.object.duck.model.Lily;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-16 13:36
 **/
public class LiLyFactory {

    public static Lily born(String name){
        Lily lily = new Lily();
        lily.setName(name);
        return lily;
    }

}
