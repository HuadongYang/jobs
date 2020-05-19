package com.object.duck.pool;

import com.object.duck.model.Lily;
import com.object.duck.vo.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-17 22:25
 **/
public class LiLyPool {

    private static volatile List<Lily> lilyList = new CopyOnWriteArrayList<Lily>();

    private LiLyPool(){}

    public static void registerLilyPool(Lily lily) {
        lilyList.add(lily);
    }

    public static List<Lily> getLilyList() {
        return lilyList;
    }

    public static List<Lily> getLilyPool(Position position) {
        List<Lily> lilies = new ArrayList<>();

        for(Lily lily : lilyList) {
            if (lily.getCurrentPosition().isEquals(position)) {
                lilies.add(lily);
            }
        }
        return lilies;
    }

    public static synchronized boolean release(String name) {
        Integer index = getIndexFromListByName(name);

        if (index == -1) {
            return false;
        }

        lilyList.remove(index);
        return true;
    }

    private static Integer getIndexFromListByName(String name) {
        for (int i = 0; i < lilyList.size(); i++) {
            Lily lily = lilyList.get(i);
            if (lily.getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }


}
