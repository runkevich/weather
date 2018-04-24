package com.gmail.runkevich8.data.net;


import com.gmail.runkevich8.data.entity.WeatherResponseData;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

@Singleton
public class RestService {

    private RestApi restApi;


    @Inject
    public RestService(RestApi restApi) {
        this.restApi = restApi;

    }

    public Observable<List<WeatherResponseData>> getWeatherByCoordinates(double lat, double lon) {
        return restApi
                .getWeatherByCoordinates(lat,lon)
                .map(new Function<WeatherResponseData, List<WeatherResponseData>>() {
                    @Override
                    public List<WeatherResponseData> apply(WeatherResponseData weatherResponseData) throws Exception {
                        return  null;
                               // weatherResponseData.getMain().getTemp();
                    }
                });


    }



}
