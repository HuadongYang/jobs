package com.object.duck.swing;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VoiceTest {
    /**
     * 蜂鸣声音
     */
    public static void bee() {
        for (int k = 0; k < 5; k++) {
            if (true) {
                Frame f = new Frame();
                Toolkit kit = f.getToolkit();


                kit.beep();
            }
            System.err.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "------------警报...warning....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        bee();
    }
}