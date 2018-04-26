//package com.gmail.runkevich8.data.net;
//
//
//import android.util.Log;
//
//import com.gmail.runkevich8.domain.entity.WeatherInfo;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.LinkedList;
//
//import javax.inject.Inject;
//import javax.inject.Singleton;
//
//import io.reactivex.Observable;
//
//import static android.content.ContentValues.TAG;
//
//@Singleton
//public class RestService {
//    public enum TempUnit {
//        CENTIGRADE,
//        FAHRENHEIT
//    }
//    private static final String FORECAST_DAYS = "15";
//    private RestApi restApi;
//    private LinkedList<WeatherInfo> weatherDataList;
//    private String mWeatherLocationName;
//    private TempUnit lastTempUnit;
//    private String lastPayload;
//
//
//    @Inject
//    public RestService(RestApi restApi) {
//        this.restApi = restApi;
//
//    }
//
//        public Observable<LinkedList<WeatherInfo>> getWeatherData(final String payload, final TempUnit tempUnit) {
//        return restApi
//                .getCurrentWeather(payload + ",us", translateTempUnit(tempUnit))
//                .flatMap(todayResponse -> {
//
//                    weatherDataList.clear();
//                    Log.d(TAG, "Received today weather: " + todayResponse);
//
//                    parseTodayData(todayResponse, weatherDataList);
//                    return restApi.getForecastWeather(
//                            payload + ",us", translateTempUnit(tempUnit), FORECAST_DAYS);
//                })
//                .map(s -> {
//
//                    parseFutureData(s, weatherDataList);
//
//                    lastPayload = payload;
//                    lastTempUnit = tempUnit;
//
//                    return weatherDataList;
//                });
//
//    }
//    private String translateTempUnit(TempUnit tempUnit) {
//
//        String mode = "imperial";
//
//        switch (tempUnit) {
//
//            case CENTIGRADE:
//                mode = "metric";
//                break;
//        }
//
//        return mode;
//    }
//    public String getWeatherLocationName() {
//        return mWeatherLocationName;
//    }
//    private void parseTodayData(String responsePayload, LinkedList<WeatherInfo> weatherDataList) throws JSONException {
//
//        JSONObject rootObject = new JSONObject(responsePayload);
//
//        //Try to get the friendly name of the place
//        if(null != rootObject.getString("name")) {
//            mWeatherLocationName = rootObject.getString("name");
//        }
//
//        weatherDataList.add(new WeatherInfo(
//                "Today",
//                translateWeatherStatus(((JSONObject)(rootObject.getJSONArray("weather")).get(0)).getString("main")),
//                rootObject.getJSONObject("main").getString("temp_max"),
//                rootObject.getJSONObject("main").getString("temp_min"),
//                rootObject.getJSONObject("main").getString("temp")
//        ));
//    }
//
//    private WeatherInfo.WeatherStatus translateWeatherStatus(String weatherStatus) {
//
//        WeatherInfo.WeatherStatus status = WeatherInfo.WeatherStatus.Clear;
//        switch(weatherStatus.toLowerCase()) {
//            case "rain":
//                status = WeatherInfo.WeatherStatus.Rain;
//                break;
//
//            case "clouds":
//                status = WeatherInfo.WeatherStatus.Cloudy;
//                break;
//
//            case "clear":
//                status = WeatherInfo.WeatherStatus.Clear;
//                break;
//        }
//
//        return status;
//    }
//
//    private void parseFutureData(String responsePayload, LinkedList<WeatherInfo> weatherDataList) {
//
//        try {
//            JSONObject rootObject = new JSONObject(responsePayload);
//
//            //Try to get the friendly name of the place
//            if (null == mWeatherLocationName || mWeatherLocationName.isEmpty()) {
//                mWeatherLocationName = rootObject.getJSONObject("city").getString("name");
//            }
//
//            JSONArray weatherArray = rootObject.getJSONArray("list");
//            int weatherArrayLength = weatherArray.length();
//
//            for (int weatherIndex = 1; weatherIndex < weatherArrayLength; weatherIndex++) {
//
//                JSONObject weatherObject = (JSONObject) weatherArray.get(weatherIndex);
//
//                weatherDataList.add(new WeatherInfo(
//                        resolveDate(weatherObject.getLong("dt")),
//                        translateWeatherStatus(((JSONObject) weatherObject.getJSONArray("weather").get(0)).getString("main")),
//                        weatherObject.getJSONObject("temp").getString("max"),
//                        weatherObject.getJSONObject("temp").getString("min"),
//                        null
//                ));
//            }
//        } catch (JSONException ex) {
//            //
//        }
//    }
//    private String resolveDate(long longDate) {
//
//        Date date = new Date(longDate * 1000);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        return sdf.format(date);
//    }
//
////    public Observable<List<WeatherResponseData>> getWeatherByCoordinates(double lat, double lon) {
////        return restApi
////                .getWeatherByCoordinates(lat,lon)
////                .map(new Function<WeatherResponseData, List<WeatherResponseData>>() {
////                    @Override
////                    public List<WeatherResponseData> apply(WeatherResponseData weatherResponseData) throws Exception {
////                        return weatherResponseData.getWeather()
////                    }
////                });
////
////
////    }
//
//
//
//}
