package com.gmail.runkevich8.data.entity;



public class CityEntity {
    private String city;
    private String id;

    public CityEntity(String city, String id) {
        this.city = city;
        this.id = id;
    }

    public CityEntity() {
    }

    public String getCity() {
        return city;
    }

    public String getId() {
        return id;
    }
}
