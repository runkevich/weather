package com.gmail.runkevich8.domain.entity;

public class WeatherInfo {

    public enum WeatherStatus {
        Clear,
        Cloudy,
        Rain,
        Snow
    }

    private String weatherDay;
    private WeatherStatus weatherStatus;
    private String maxTemp;
    private String minTemp;
    private String curTemp;

    public WeatherInfo(String weatherDay, WeatherStatus weatherStatus, String maxTemp, String minTemp, String curTemp) {

        this.weatherDay = weatherDay;
        this.weatherStatus = weatherStatus;
        this.maxTemp = roundOff(maxTemp);
        this.minTemp = roundOff(minTemp);
        this.curTemp = roundOff(curTemp);
    }

    private String roundOff(String decimalData) {

        if(null == decimalData || decimalData.isEmpty()) {
            return decimalData;
        }

        Double d = Double.parseDouble(decimalData);
        return ((Integer) (int) Math.ceil(d)).toString() + "\u00B0";
    }

    public String getWeatherDay() {
        return weatherDay;
    }

    public WeatherStatus getWeatherStatus() {
        return weatherStatus;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public String getCurTemp() {
        return curTemp;
    }

}
