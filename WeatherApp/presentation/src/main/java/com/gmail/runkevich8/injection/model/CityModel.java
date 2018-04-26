package com.gmail.runkevich8.injection.model;



public class CityModel {
    private String name;
    private String id;

    public CityModel(String name, String id) {
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
