package com.gmail.runkevich8.data.entity.citydata;


import android.support.annotation.Nullable;

import com.gmail.runkevich8.data.entity.WeatherEntity;
import com.gmail.runkevich8.data.entity.weather.WeatherEntityInernal;
import com.gmail.runkevich8.domain.entity.WeatherRaw;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.annotations.NonNull;

@Singleton
public class WeatherEntityDataMapper {
    @Inject
    public WeatherEntityDataMapper() {
    }

    @Nullable
    public WeatherRaw transform(@NonNull WeatherEntity weatherEntity) {
        WeatherRaw weather = new WeatherRaw();
        weather.setName(weatherEntity.getName());
        weather.setTempCelsius(weatherEntity.getMain().getTemp());
        weather.setTempCelsiusHigh(weatherEntity.getMain().getTempMax());
        weather.setTempCelsiusLow(weatherEntity.getMain().getTempMin());

        List<WeatherEntityInernal> weathers = weatherEntity.getWeather();

        if (weathers != null && weathers.size() > 0) {
            WeatherEntityInernal firstWeather = weathers.get(0);
            weather.setMain(firstWeather.getMain());
            weather.setDescription(firstWeather.getDescription());
            weather.setIcon(firstWeather.getIcon());
        }

        return weather;
    }
}
