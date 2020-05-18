package com.object.duck.behave;

import com.object.duck.model.BaseModel;
import com.object.duck.model.Pond;

/**
 * todo: 池塘边绕行
 *
 * todo: 遇到岩石绕行
 */
public abstract class DuckMove extends ModelInitPosition {

    public DuckMove(BaseModel baseModel) {
        super(baseModel);
    }

    public abstract void move(Pond pond, Integer step, double angle);


}
