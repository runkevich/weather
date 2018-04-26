package com.gmail.runkevich8.domain.repository;


import com.gmail.runkevich8.domain.entity.WeatherRaw;

import io.reactivex.Observable;

public interface WeatherRepository {
    Observable<WeatherRaw> weather(final String cityId);
}
