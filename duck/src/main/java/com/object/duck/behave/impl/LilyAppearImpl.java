package com.object.duck.behave.impl;

import com.object.duck.behave.LilyAppear;
import com.object.duck.model.Lily;

public class LilyAppearImpl extends LilyAppear {

    private Lily lily;

    public LilyAppearImpl(Lily lily) {
        super(lily);
        this.lily = lily;
    }
}
