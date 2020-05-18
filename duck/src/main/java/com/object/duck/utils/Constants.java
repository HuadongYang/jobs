package com.object.duck.utils;

import com.object.duck.model.Pond;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-18 22:27
 **/
public class Constants {

    public static final Integer DUCK_INIT_WEIGHT = 50;
    public static final String DUCK_INIT_COLOR = "#FFFF00";

    public static final Integer WEIGHT_THRESHOLD_OF_DEATH = 5;
    public static final Integer WEIGHT_THRESHOLD_OF_HEAD = 80;

    public static final int DEATH_INTERVAL = 10;

    public static final int DUCK_STEP = 10;

    public static final int DUCK_THREAD_SLEEP_MILLS = 100;
    public static final int LILY_THREAD_SLEEP_MILLS = 1;

    public static final int DUCK_COUNT = 3;

    public static Pond pond = new Pond();
    {
        pond.setMinX(0);
        pond.setMaxX(100);
        pond.setMinY(0);
        pond.setMaxY(100);

    }



}
