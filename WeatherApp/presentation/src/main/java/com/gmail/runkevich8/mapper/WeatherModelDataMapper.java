package com.gmail.runkevich8.mapper;


import com.gmail.runkevich8.domain.entity.Weather;
import com.gmail.runkevich8.injection.PerActivity;
import com.gmail.runkevich8.injection.model.WeatherModel;
import com.gmail.runkevich8.presentation.weather.WeatherViewModel;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

@PerActivity
public class WeatherModelDataMapper {
    private static final String DEGREES = "°";
    public static final String CURRENTLY = "Currently ";
    public static final String TODAY = "Today ";
    public static final String HYPHEN = "-";
    public static final String ICON_URL = "http://openweathermap.org/img/w/";

    @Inject
    public WeatherModelDataMapper() {
    }

    public WeatherModel transform(@NonNull Weather weather) {
        final WeatherModel weatherModel = new WeatherModel();
        weatherModel.setCityName(weather.getName());
        weatherModel.setDescription(weather.getDescription());
        weatherModel.setIconUrl(prepareIconUrl(weather.getIcon()));
        weatherModel.setCurrentTempCelsius(prepareCurrentlyTemp(weather.getTempCelsius()));
        weatherModel.setCurrentTempFahrenheit(prepareCurrentlyTemp(weather.getTempFahrenheit()));
        weatherModel.setTodayTempRangeCelsius(
                prepareTempRange(weather.getTempCelsiusLow(), weather.getTempCelsiusHigh()));
        weatherModel.setTodayTempRangeFahrenheit(
                prepareTempRange(weather.getTempFahrenheitLow(), weather.getTempFahrenheitHigh()));
        return weatherModel;
    }

    public WeatherViewModel transform(boolean celsius, @NonNull final WeatherModel wm) {
        final WeatherViewModel wvm = new WeatherViewModel();
        wvm.setCityName(wm.getCityName());
        wvm.setDescription(wm.getDescription());
        wvm.setIconUrl(wm.getIconUrl());
        wvm.setCurrentTemp(celsius ? wm.getCurrentTempCelsius() : wm.getCurrentTempFahrenheit());
        wvm.setTodayTempRange(
                celsius ? wm.getTodayTempRangeCelsius() : wm.getTodayTempRangeFahrenheit());
        return wvm;
    }

    private String prepareIconUrl(String icon) {
        return ICON_URL + icon + ".png";
    }

    private String prepareCurrentlyTemp(float temp) {
        return CURRENTLY + String.valueOf(temp) + DEGREES;
    }

    private String prepareTempRange(float low, float high) {
        return TODAY + String.valueOf(low) + DEGREES + HYPHEN + String.valueOf(high) + DEGREES;
    }
}
