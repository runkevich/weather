package com.gmail.runkevich8.domain.interactor;

import com.gmail.runkevich8.domain.entity.WeatherInfo;
import com.gmail.runkevich8.domain.executor.PostExecutionThread;
import com.gmail.runkevich8.domain.executor.ThreadExecutor;
import com.gmail.runkevich8.domain.repository.WeatherRepository;

import javax.inject.Inject;

import io.reactivex.Observable;


public class GetDataUseCase extends BaseUseCase {

    private WeatherRepository weatherRepository;

    @Inject
    public GetDataUseCase(PostExecutionThread postExecutionThread, ThreadExecutor threadExecuteion) {
        super(postExecutionThread, threadExecuteion);
    }

    public Observable<WeatherInfo> getListWeathers(double lat, double lon) {
        return weatherRepository.getWeather(lat,lon)
                .subscribeOn(threadExecuteion)
                .observeOn(postExecuteionThread);
    }

}
