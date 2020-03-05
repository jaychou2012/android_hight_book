package com.td.tvsuitdemo.entity;

import java.io.Serializable;

public class CardItem implements Serializable {
    private int id;
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
