package com.gmail.runkevich8.domain.entity;



public class City {
    private String name;
    private String id;

    public City(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
