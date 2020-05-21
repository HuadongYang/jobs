package com.object.duck.pool;

import com.object.duck.model.Duck;
import com.object.duck.model.Lily;
import com.object.duck.vo.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LiLyPool {

    private static volatile List<Lily> lilyList = new CopyOnWriteArrayList<Lily>();

    private LiLyPool(){}

    public static void registerLilyPool(Lily lily) {
        lilyList.add(lily);
    }

    public static List<Lily> getLilyList() {
        return lilyList;
    }

    public static List<Lily> getLilyPool(Duck duck) {
        Position position = duck.getCurrentPosition();
        Integer weight = duck.getWeight();

        List<Lily> lilies = new ArrayList<>();

        for(Lily lily : lilyList) {
            Position lilyPosition = lily.getCurrentPosition();
            int differenceX = lilyPosition.getX() - position.getX();
            int differenceY = lilyPosition.getY() - position.getY();
            if ((differenceX*differenceX + differenceY*differenceY) < weight) {
                lilies.add(lily);
            }
        }
        return lilies;
    }

    public static synchronized boolean release(Lily lily) {

        return lilyList.remove(lily);
    }



}
