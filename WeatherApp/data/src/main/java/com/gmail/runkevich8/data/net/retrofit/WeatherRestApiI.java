package com.gmail.runkevich8.data.net.retrofit;

import com.gmail.runkevich8.data.entity.WeatherEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface WeatherRestApiI {
    String ID = "id";
    String UNITS = "units";
    String APPID = "APPID";

    @GET(Config.GET_WEATHER_PATH)
    Observable<WeatherEntity> weatherEntityByCityId(
            @Query(ID) String cityId, @Query(UNITS) String units, @Query(APPID) String appId);
}
