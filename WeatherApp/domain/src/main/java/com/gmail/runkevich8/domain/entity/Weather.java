package com.gmail.runkevich8.domain.entity;



public class Weather {
    private String name;
    private String main;
    private String description;
    private String icon;
    private float tempCelsius;
    private float tempCelsiusLow;
    private float tempCelsiusHigh;
    private float tempFahrenheit;
    private float tempFahrenheitLow;
    private float tempFahrenheitHigh;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getTempCelsius() {
        return tempCelsius;
    }

    public void setTempCelsius(float tempCelsius) {
        this.tempCelsius = tempCelsius;
    }

    public float getTempCelsiusLow() {
        return tempCelsiusLow;
    }

    public void setTempCelsiusLow(float tempCelsiusLow) {
        this.tempCelsiusLow = tempCelsiusLow;
    }

    public float getTempCelsiusHigh() {
        return tempCelsiusHigh;
    }

    public void setTempCelsiusHigh(float tempCelsiusHigh) {
        this.tempCelsiusHigh = tempCelsiusHigh;
    }

    public float getTempFahrenheit() {
        return tempFahrenheit;
    }

    public void setTempFahrenheit(float tempFahrenheit) {
        this.tempFahrenheit = tempFahrenheit;
    }

    public float getTempFahrenheitLow() {
        return tempFahrenheitLow;
    }

    public void setTempFahrenheitLow(float tempFahrenheitLow) {
        this.tempFahrenheitLow = tempFahrenheitLow;
    }

    public float getTempFahrenheitHigh() {
        return tempFahrenheitHigh;
    }

    public void setTempFahrenheitHigh(float tempFahrenheitHigh) {
        this.tempFahrenheitHigh = tempFahrenheitHigh;
    }
}
