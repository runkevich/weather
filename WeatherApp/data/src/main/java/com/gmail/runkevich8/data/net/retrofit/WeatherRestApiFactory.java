package com.gmail.runkevich8.data.net.retrofit;

import javax.inject.Inject;
import javax.inject.Singleton;



@Singleton
public class WeatherRestApiFactory {
    private String baseUrl;

    @Inject
    public WeatherRestApiFactory(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Inject
    public WeatherRestApiI get() {
        return new HttpClient<>(baseUrl, WeatherRestApiI.class).get();
    }
}
