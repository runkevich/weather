package com.gmail.runkevich8.domain.entity;

public class WeatherInfo {

  //  private Status status;

    private String cityName;
    private String description;
    private String temperature;

//    /* package */
//    public WeatherInfo(Status status, Weather weather) {
//        if (weather != null && weather.description != null) {
//            this.status = status;
//            this.cityName = weather.cityName;
//            this.description = weather.description;
//            this.temperature = Double.toString(weather.temperature);
//        }
//        else {
//            this.status = Status.NODATA;
//            this.description = "No data loaded";
//        }
//    }

   // public Status getStatus() {
    //    return status;
  //  }

    public String getCityName() {
        return cityName;
    }

    public String getDescription() {
        return description;
    }

    public String getTemperature() {
        return temperature;
    }
}
