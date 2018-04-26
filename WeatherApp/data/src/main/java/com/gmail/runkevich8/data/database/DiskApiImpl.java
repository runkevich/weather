package com.gmail.runkevich8.data.database;


import com.gmail.runkevich8.data.entity.CityEntity;
import com.gmail.runkevich8.data.entity.citydata.CityEntityJsonMapper;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

@Singleton
public class DiskApiImpl  implements DiskApi {

    private final String fileName;
    private final AssetsReader assetsReader;
    private final CityEntityJsonMapper cityEntityJsonMapper;

    @Inject
    public DiskApiImpl(@NonNull String fileName, @NonNull AssetsReader assetsReader,
                       @NonNull CityEntityJsonMapper cityEntityJsonMapper) {
        this.fileName = fileName;
        this.assetsReader = assetsReader;
        this.cityEntityJsonMapper = cityEntityJsonMapper;
    }

    @NonNull @Override public Observable<CityEntity> cityEntityList() {
        return Observable.create(e -> {
            try {
                String citiesJson = assetsReader.readFromAssets(fileName);
                List<CityEntity> cityEntities = cityEntityJsonMapper.transformCitiesEntity(citiesJson);
                for (CityEntity cityEntity : cityEntities) {
                    e.onNext(cityEntity);
                }
                e.onComplete();
            } catch (IOException exc) {
                e.onError(exc);
            }
        });
    }
}