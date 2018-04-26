package com.gmail.runkevich8.domain.interactor;


import com.gmail.runkevich8.domain.entity.City;
import com.gmail.runkevich8.domain.executor.PostExecutionThread;
import com.gmail.runkevich8.domain.executor.ThreadExecutor;
import com.gmail.runkevich8.domain.interactor.modify.CitySorting;
import com.gmail.runkevich8.domain.repository.CityRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetCityList extends UseCase<City, Void> {

    private final CityRepository cityRepository;
    private final CitySorting citySorting;

    @Inject
    public GetCityList(CityRepository cityRepository, ThreadExecutor threadExecutor,
                PostExecutionThread postExecutionThread, CitySorting citySorting) {
        super(threadExecutor, postExecutionThread);
       // Preconditions.checkNotNull(cityRepository);
       // Preconditions.checkNotNull(threadExecutor);
       // Preconditions.checkNotNull(postExecutionThread);
        this.citySorting = citySorting;
        this.cityRepository = cityRepository;
    }

    @Override
    Observable<City> buildUseCaseObservable(Void unused) {
        return this.cityRepository.cites().compose(citySorting.apply());
    }
}