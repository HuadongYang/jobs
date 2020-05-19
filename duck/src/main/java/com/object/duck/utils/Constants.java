package com.object.duck.utils;

import com.object.duck.model.Pond;

import java.awt.*;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-18 22:27
 **/
public class Constants {
    public static final int DUCK_COUNT = 30;

    public static final Integer DUCK_INIT_WEIGHT = 50;
    public static final Integer DUCK_THIN_WEIGHT = 25;
    public static final Integer WEIGHT_THRESHOLD_OF_DEATH = 5;
    public static final Integer WEIGHT_THRESHOLD_OF_HEAD = 80;
    public static final int DUCK_LOSE_WEIGHT = 1;

    public static final int DEATH_INTERVAL = 10;

    public static final Color DUCK_INIT_COLOR = Color.yellow;
    public static final Color DUCK_HEAD_COLOR = Color.green;
    public static final Color DUCK_THIN_COLOR = Color.red;
    public static final Color LILY_COLOR = Color.blue;


    public static final int DUCK_STEP = 10;

    public static final int DUCK_SIZE_X = 10;
    public static final int DUCK_SIZE_Y = 10;

    public static final int LILY_SIZE_X = 1;
    public static final int LILY_SIZE_Y = 1;


    public static final int DUCK_THREAD_SLEEP_MILLS = 400;
    public static final int LILY_THREAD_SLEEP_MILLS = 2;

    public static Pond pond = new Pond();
    static {
        pond.setMinX(0);
        pond.setMaxX(500);
        pond.setMinY(0);
        pond.setMaxY(500);

    }



}
