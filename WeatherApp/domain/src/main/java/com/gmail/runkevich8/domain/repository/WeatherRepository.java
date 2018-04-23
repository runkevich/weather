package com.gmail.runkevich8.domain.repository;

import com.gmail.runkevich8.domain.entity.WeatherInfo;

import java.util.List;

import io.reactivex.Observable;



public interface WeatherRepository {

    Observable<WeatherInfo> getWeather (String id);

    Observable<List<WeatherInfo>> getList();

}
