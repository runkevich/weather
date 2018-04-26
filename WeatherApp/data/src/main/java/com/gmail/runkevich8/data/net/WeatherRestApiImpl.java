package com.gmail.runkevich8.data.net;

import com.gmail.runkevich8.data.entity.WeatherEntity;
import com.gmail.runkevich8.data.net.retrofit.Config;
import com.gmail.runkevich8.data.net.retrofit.WeatherRestApiI;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class WeatherRestApiImpl  implements WeatherRestApi {

    private final WeatherRestApiI weatherRestApiI;

    @Inject
    public WeatherRestApiImpl(WeatherRestApiI weatherRestApiI) {
        this.weatherRestApiI = weatherRestApiI;
    }

    @Override public Observable<WeatherEntity> weatherEntityByCityId(String cityId) {
        return weatherRestApiI.weatherEntityByCityId(cityId, Config.UNITS, Config.APP_ID);
    }
}