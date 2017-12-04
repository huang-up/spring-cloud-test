package com.domain;

/**
 * Created by admin on 2017/11/22.
 */
public class Hotel {

    private int id;
    private String name;

    public Hotel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
