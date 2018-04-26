package com.gmail.runkevich8.data.repository;

import android.support.annotation.NonNull;

import com.gmail.runkevich8.data.entity.citydata.WeatherEntityDataMapper;
import com.gmail.runkevich8.data.net.WeatherRestApi;
import com.gmail.runkevich8.domain.entity.WeatherRaw;
import com.gmail.runkevich8.domain.repository.WeatherRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class WeatherDataRepository implements WeatherRepository {

    private final WeatherRestApi weatherRestApi;
    private final WeatherEntityDataMapper weatherEntityDataMapper;

    @Inject
    public WeatherDataRepository(@NonNull WeatherRestApi weatherRestApi,
                                 @NonNull WeatherEntityDataMapper weatherEntityDataMapper) {
        this.weatherRestApi = weatherRestApi;
        this.weatherEntityDataMapper = weatherEntityDataMapper;
    }

    @Override
    public Observable<WeatherRaw> weather(String cityId) {
        return weatherRestApi.weatherEntityByCityId(cityId).map(weatherEntityDataMapper::transform);
    }
}