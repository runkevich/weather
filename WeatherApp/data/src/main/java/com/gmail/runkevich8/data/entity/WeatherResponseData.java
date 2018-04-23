package com.gmail.runkevich8.data.entity;



public final class WeatherResponseData {

    private WeatherData[] weather;
    private MainData main;

    public WeatherData[] getWeather() {
        return weather;
    }

    public MainData getMain() {
        return main;
    }



    public final class WeatherData {
        String main;

        public String getMain() {
            return main;
        }
    }

    public final class MainData {
        double temp;

        public double getTemp() {
            return temp;
        }
    }
}
