package com.gmail.runkevich8.data.net;


import com.gmail.runkevich8.data.entity.WeatherResponseData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface  RestApi {

//    @GET("/data/2.5/weather")
//    Call<WeatherModel> getWeatherDataByCityCode(@Query("q") String q, @Query("appid") String appId);

//    @GET("data/2.5/weather")
//    Observable<String> getCurrentWeather(@Query("zip") String zipCode,
//                                         @Query("units") String tempUnit);

    @GET("/data/2.5/weather")
    public Call<WeatherResponseData> getWeather(@Query("q") String cityName, @Query("APPID") String apiKey, @Query("units") String units);
}
