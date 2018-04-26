package com.gmail.runkevich8.data.net;

import com.gmail.runkevich8.data.entity.WeatherEntity;

import io.reactivex.Observable;



public interface WeatherRestApi {
    Observable<WeatherEntity> weatherEntityByCityId(final String cityId);
}
