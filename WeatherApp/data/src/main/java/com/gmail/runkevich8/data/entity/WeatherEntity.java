package com.gmail.runkevich8.data.entity;


import com.gmail.runkevich8.data.entity.weather.Clouds;
import com.gmail.runkevich8.data.entity.weather.Coord;
import com.gmail.runkevich8.data.entity.weather.Main;
import com.gmail.runkevich8.data.entity.weather.Sys;
import com.gmail.runkevich8.data.entity.weather.WeatherEntityInernal;
import com.gmail.runkevich8.data.entity.weather.Wind;

import java.util.List;

public class WeatherEntity {
    public Coord coord;
    private List<WeatherEntityInernal> weather;
    private String base;
    private Main main;
    public float visibility;
    public Wind wind;
    public Clouds clouds;
    public float dt;
    public Sys sys;
    private Integer id;
    private String name;
    public Integer cod;

    public WeatherEntity() {
        weather = null;
    }

    public List<WeatherEntityInernal> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherEntityInernal> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
