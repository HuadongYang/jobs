package com.object.duck.behave.impl;

import com.object.duck.behave.Whistle;

import java.awt.*;

public class WhistleImpl implements Whistle {
    @Override
    public void whistle() {
        Frame f = new Frame();
        Toolkit kit = f.getToolkit();
        kit.beep();
    }
}
