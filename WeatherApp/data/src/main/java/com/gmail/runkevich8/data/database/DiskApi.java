package com.gmail.runkevich8.data.database;

import com.gmail.runkevich8.data.entity.CityEntity;

import io.reactivex.Observable;


public interface DiskApi {
    Observable<CityEntity> cityEntityList();
}