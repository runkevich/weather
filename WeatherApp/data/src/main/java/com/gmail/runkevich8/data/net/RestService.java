package com.gmail.runkevich8.data.net;


import com.gmail.runkevich8.data.entity.WeatherResponseData;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;

@Singleton
public class RestService {

    private RestApi restApi;


    @Inject
    public RestService(RestApi restApi) {
        this.restApi = restApi;

    }

    public Call<WeatherResponseData> getWeather(String cityName, String apiKey, String units) {
        return restApi
                .getWeather( cityName, apiKey,  units);

    }



}
