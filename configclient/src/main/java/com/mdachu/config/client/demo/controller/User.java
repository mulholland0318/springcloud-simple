package com.mdachu.config.client.demo.controller;

import java.io.Serializable;

public class User implements Serializable{

    private int id;

    private String name;

    private short age;

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

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }
}
