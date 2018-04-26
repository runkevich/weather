//package com.gmail.runkevich8.data.net;
//
//
//import io.reactivex.Observable;
//import retrofit2.http.GET;
//import retrofit2.http.Query;
//
//public interface  RestApi {
//
//  @GET("data/2.5/weather")
//  Observable<String> getCurrentWeather(@Query("zip") String zipCode,
//                                       @Query("units") String tempUnit);
//
//  @GET("data/2.5/forecast/daily")
//  Observable<String> getForecastWeather(@Query("zip") String zipCode,
//                                        @Query("units") String tempUnit,
//                                        @Query("cnt") String dayCount);
//}
