package com.gmail.runkevich8.data.repository;


import com.gmail.runkevich8.data.database.WeatherDAO;
import com.gmail.runkevich8.data.net.RestApi;
import com.gmail.runkevich8.domain.entity.WeatherInfo;
import com.gmail.runkevich8.domain.repository.WeatherRepository;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;

public class WeatherRepositoryImp implements WeatherRepository {

    private final String API_KEY = "d1ddc45b485931b4c239c07b04844991";

    private final WeatherDAO weatherDao;
    private final RestApi restApi;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Inject
    public WeatherRepositoryImp(WeatherDAO weatherDao, RestApi restApi) {
        this.weatherDao = weatherDao;
        this.restApi = restApi;
    }

    public Flowable<List<String>> getCityList() {
        return weatherDao.loadCityList();
    }

    public Observable<WeatherInfo> getWeather(final String cityName) {
//        MediatorLiveData<WeatherInfo> result = new MediatorLiveData<>();
//
//        Flowable<Weather> dbSource = weatherDao.load(cityName);
//        result.addSource(dbSource, weather -> result.setValue(new WeatherInfo(com.gmail.runkevich8.data.repository.Status.LOADING, weather)));
//
//        this.restApi.getWeather(cityName, API_KEY, "metric").enqueue(new Callback<WeatherResponseData>() {
//
//            @Override
//            public void onResponse(Call<WeatherResponseData> call, Response<WeatherResponseData> response) {
//                WeatherResponseData body = response.body();
//                Weather newWeather = new Weather(cityName, body.getMain().getTemp(), body.getWeather()[0].getMain());
//
//                result.removeSource(dbSource);
//                executorService.execute(() -> {
//                    weatherDao.save(newWeather);
//                    result.addSource(weatherDao.load(cityName), weather -> result.setValue(new WeatherInfo(Status.SUCCESS, weather)));
//                });
//            }
//
//            @Override
//            public void onFailure(Call<WeatherResponseData> call, Throwable t) {
//                result.removeSource(dbSource);
//                result.addSource(dbSource, weather -> result.setValue(new WeatherInfo(Status.ERROR, weather)));
//            }
//        });
//
        return null;
    }


//    public LiveData<CitiesWeatherModel> getWeathersForCountries() {
//        final MutableLiveData<CitiesWeatherModel> data = new MutableLiveData<>();
//
//        weatherService.getWeatherForAllCountries(Constants.DEFAULT_COUNTRYCODES, Constants.API_KEY).enqueue(new Callback<CitiesWeatherModel>() {
//            @Override
//            public void onResponse(@NonNull Call<CitiesWeatherModel> call, @NonNull Response<CitiesWeatherModel> response) {
//                data.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<CitiesWeatherModel> call, @NonNull Throwable t) {
//
//            }
//        });
//
//        return data;
//    }


    @Override
    public Observable<List<WeatherInfo>> getList() {
        return null;
    }
}
