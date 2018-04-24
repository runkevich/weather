package com.gmail.runkevich8.data.net;


import android.support.annotation.NonNull;

import com.gmail.runkevich8.data.entity.WeatherResponseData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface  RestApi {

//    @GET("/data/2.5/weather")
//    Call<WeatherModel> getWeatherDataByCityCode(@Query("q") String q, @Query("appid") String appId);

//    @GET("data/2.5/weather")
//    Observable<String> getCurrentWeather(@Query("zip") String zipCode,
//                                         @Query("units") String tempUnit);

  //  @GET("/data/2.5/weather")
  @NonNull
  @GET("data/2.5/weather?units=metric")
  @Headers({"Content-Type:application/json"})
  //  public Call<WeatherDataModel> getWeatherByCoordinates(@Query("q") String cityName, @Query("APPID") String apiKey, @Query("units") String units);
  Observable<WeatherResponseData> getWeatherByCoordinates(
          @Query("lat") double lat, @Query("lon") double lon);
}
