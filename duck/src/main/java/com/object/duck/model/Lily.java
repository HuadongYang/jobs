package com.object.duck.model;


import java.util.Objects;

/**
 * @description:
 * @author: Yanghd
 * @create: 2020-05-15 23:54
 **/
public class Lily extends BaseModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lily lily = (Lily) o;
        return this.name.equals(lily.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
