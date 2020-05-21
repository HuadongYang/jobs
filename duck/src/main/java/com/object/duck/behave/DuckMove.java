package com.object.duck.behave;

import com.object.duck.model.BaseModel;
import com.object.duck.model.Pond;


public abstract class DuckMove extends ModelInitPosition {

    public DuckMove(BaseModel baseModel) {
        super(baseModel);
    }

    public abstract void move(Integer step);


}
