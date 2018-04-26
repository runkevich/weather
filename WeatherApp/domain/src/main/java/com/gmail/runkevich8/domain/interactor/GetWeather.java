package com.gmail.runkevich8.domain.interactor;


import com.gmail.runkevich8.domain.entity.Weather;
import com.gmail.runkevich8.domain.executor.PostExecutionThread;
import com.gmail.runkevich8.domain.executor.ThreadExecutor;
import com.gmail.runkevich8.domain.interactor.modify.WeatherTransformer;
import com.gmail.runkevich8.domain.repository.WeatherRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetWeather extends  UseCase<Weather, GetWeather.Params> {

    private final WeatherRepository weatherRepository;
    private final WeatherTransformer weatherTransformer;

        @Inject
        GetWeather(WeatherRepository weatherRepository, ThreadExecutor threadExecutor,
           PostExecutionThread postExecutionThread, WeatherTransformer weatherTransformer) {
        super(threadExecutor, postExecutionThread);
       // Preconditions.checkNotNull(weatherRepository);
      //  Preconditions.checkNotNull(threadExecutor);
       // Preconditions.checkNotNull(postExecutionThread);
      //  Preconditions.checkNotNull(weatherTransformer);
        this.weatherTransformer = weatherTransformer;
        this.weatherRepository = weatherRepository;
        }

    @Override
    Observable<Weather> buildUseCaseObservable(Params params) {
        //Preconditions.checkNotNull(params);
        return weatherRepository.weather(params.cityId).compose(weatherTransformer.apply());
        }

        public static final class Params {
            private final String cityId;

         private Params(String cityId) {
        this.cityId = cityId;
    }

    public static Params forCity(String cityId) {
        return new Params(cityId);
    }
    }
}