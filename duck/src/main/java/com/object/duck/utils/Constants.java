package com.object.duck.utils;

import com.object.duck.behave.ModelInitPosition;
import com.object.duck.behave.impl.RockAppearImpl;
import com.object.duck.model.Pond;
import com.object.duck.model.Rock;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final int DUCK_COUNT = 10;

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


    public static final int DUCK_MOVE_STEP = 30;


    public static final Color LILY_COLOR = Color.blue;

    public static final int JFRAM_WIDTH = 1000;
    public static final int JFRAM_HEIGHT = 600;


    public static final int LILY_SIZE_X = 30;
    public static final int LILY_SIZE_Y = 30;


    public static final int DUCK_THREAD_SLEEP_MILLS = 400;
    public static final int LILY_THREAD_SLEEP_MILLS = 90;

    public static Pond pond = new Pond();

    static {
        pond.setMinX(0);
        pond.setMaxX(600);
        pond.setMinY(0);
        pond.setMaxY(500);
    }

    public static List<Rock> rockList = new ArrayList<>();
    public static final Integer ROCK_COUNT = 3;
    public static final Integer ROCK_SIZE_A = 40;
    public static final Integer ROCK_SIZE_B = 20;
    static {
        for (int i = 0; i < ROCK_COUNT; i++) {
            Rock rock = new Rock();
            ModelInitPosition modelInitPosition = new RockAppearImpl(rock);
            modelInitPosition.initPosition(pond);
            rockList.add(rock);
        }
    }



}
