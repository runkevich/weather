//package com.gmail.runkevich8.data.repository;
//
//
//import com.gmail.runkevich8.data.database.WeatherDAO;
//import com.gmail.runkevich8.data.net.RestService;
//import com.gmail.runkevich8.domain.entity.WeatherInfo;
//import com.gmail.runkevich8.domain.repository.WeatherRepository;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import javax.inject.Inject;
//
//import io.reactivex.Observable;
//
//public class WeatherRepositoryImp implements WeatherRepository {
//
//    //private final String API_KEY = "d1ddc45b485931b4c239c07b04844991";
//
//
//    private final WeatherDAO weatherDao;
//    private RestService restServise;
//
//    //private final ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//    @Inject
//    public WeatherRepositoryImp(WeatherDAO weatherDao, RestService restServise) {
//        this.weatherDao = weatherDao;
//        this.restServise = restServise;
//    }
//
//
//    @Override
//    public Observable<LinkedList<WeatherInfo>> getWeather(String payload, com.gmail.runkevich8.domain.entity.TempUnit tempUnit) {
//        return restServise.getWeatherData(payload,RestService.TempUnit.CENTIGRADE);
//
//    }
//
//
//
//    @Override
//    public Observable<List<WeatherInfo>> getList() {
//        return null;
//    }
//
//}
