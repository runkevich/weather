package com.gmail.runkevich8.data.entity.citydata;


import com.gmail.runkevich8.data.entity.CityEntity;
import com.gmail.runkevich8.domain.entity.City;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

@Singleton
public class CityEntityDataMapper {
    @Inject
    CityEntityDataMapper() {
    }

    @NonNull
    public City transform(@NonNull CityEntity cityEntity) {
        return new City(cityEntity.getCity(), cityEntity.getId());
    }

    public List<City> transform(@NonNull Collection<CityEntity> cityEntityCollection) {
        return Observable.fromIterable(cityEntityCollection)
                .map(this::transform)
                .toList()
                .blockingGet();
    }
}
