package com.example.something_new;

public class Class {
    private String name;
    private String tName;

    public Class(String name, String tName) {
        this.name = name;
        this.tName = tName;
    }

    public String getName() {
        return name;
    }

    public String gettName() {
        return tName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}
