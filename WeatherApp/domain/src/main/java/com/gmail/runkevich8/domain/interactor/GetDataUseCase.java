package com.gmail.runkevich8.domain.interactor;

import com.gmail.runkevich8.domain.entity.WeatherInfo;
import com.gmail.runkevich8.domain.executor.PostExecutionThread;
import com.gmail.runkevich8.domain.executor.ThreadExecutor;
import com.gmail.runkevich8.domain.repository.WeatherRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


public class GetDataUseCase extends BaseUseCase {

    private WeatherRepository weatherRepository;

    @Inject
    public GetDataUseCase(PostExecutionThread postExecutionThread, ThreadExecutor threadExecuteion) {
        super(postExecutionThread, threadExecuteion);
    }

    public Observable<List<WeatherInfo>> getListWeathers() {
        return weatherRepository.getList()
                .subscribeOn(threadExecuteion)
                .observeOn(postExecuteionThread);
    }

}
