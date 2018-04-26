package com.gmail.runkevich8.data.repository;

import android.support.annotation.NonNull;

import com.gmail.runkevich8.data.database.DiskApi;
import com.gmail.runkevich8.data.entity.citydata.CityEntityDataMapper;
import com.gmail.runkevich8.domain.entity.City;
import com.gmail.runkevich8.domain.repository.CityRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class CityDataRepository implements CityRepository {
    private final DiskApi diskApi;
    private final CityEntityDataMapper cityEntityDataMapper;

    @Inject
    public CityDataRepository(@NonNull DiskApi diskApi,
                                      @NonNull CityEntityDataMapper cityEntityDataMapper) {
        this.diskApi = diskApi;
        this.cityEntityDataMapper = cityEntityDataMapper;
    }

    @Override
    public Observable<City> cites() {
        return diskApi.cityEntityList().map(cityEntityDataMapper::transform);
    }
}