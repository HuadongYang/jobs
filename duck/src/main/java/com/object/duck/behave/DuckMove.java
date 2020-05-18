package com.object.duck.behave;

import com.object.duck.model.Duck;
import com.object.duck.model.Pond;
import com.object.duck.vo.Position;

/**
 * todo: 池塘边绕行
 *
 * todo: 遇到岩石绕行
 */
public interface DuckMove {

    void initPosition(Pond pond);

    void move(Pond pond, Integer step, double angle);


}
