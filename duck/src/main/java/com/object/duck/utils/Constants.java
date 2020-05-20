package com.object.duck.utils;

import com.object.duck.model.Pond;
import com.object.duck.vo.DuckWeight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-18 22:27
 **/
public class Constants {
    public static final int DUCK_COUNT = 30;

    public static final Integer DUCK_INIT_WEIGHT = 200;
    public static final Integer DUCK_THIN_WEIGHT = 150;
    public static final Integer DUCK_DEATH_WEIGHT = 10;
    public static final Integer DUCK_HEAD_WEIGHT = 600;
    public static final Integer DUCK_LOSE_WEIGHT = 30;
    public static final Integer DUCK_GROW_WEIGHT = 30;
    public static final Integer DUCK_LIMIT_WEIGHT = 900;
    public static final Integer DUCK_LOSE_WEIGHT_INTERVAL_DAY = 15;

    public static final Color DUCK_INIT_COLOR = Color.yellow;
    public static final Color DUCK_HEAD_COLOR = Color.green;
    public static final Color DUCK_THIN_COLOR = Color.red;

    public static Map<DuckWeight, Color> weightColorMap = new HashMap<>();
    static {
        weightColorMap.put(new DuckWeight(Integer.MIN_VALUE, DUCK_THIN_WEIGHT), DUCK_THIN_COLOR);
        weightColorMap.put(new DuckWeight(DUCK_THIN_WEIGHT, DUCK_HEAD_WEIGHT), DUCK_INIT_COLOR);
        weightColorMap.put(new DuckWeight(DUCK_HEAD_WEIGHT, Integer.MAX_VALUE), DUCK_HEAD_COLOR);
    }

    public static final int DUCK_MOVE_STEP = 30;

    public static final int DUCK_SIZE_X = 30;
    public static final int DUCK_SIZE_Y = 30;


    public static final Color LILY_COLOR = Color.blue;

    public static final int JFRAM_WIDTH = 1000;//界面的宽度
    public static final int JFRAM_HEIGHT = 600;//界面的高度


    public static final int LILY_SIZE_X = 15;
    public static final int LILY_SIZE_Y = 15;


    public static final int DUCK_THREAD_SLEEP_MILLS = 400;
    public static final int LILY_THREAD_SLEEP_MILLS = 90;

    public static Pond pond = new Pond();

    static {
        pond.setMinX(0);
        pond.setMaxX(600);
        pond.setMinY(0);
        pond.setMaxY(500);

    }



}
