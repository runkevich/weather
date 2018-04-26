package com.gmail.runkevich8.data.entity.citydata;


import com.gmail.runkevich8.data.entity.CityEntity;
import com.gmail.runkevich8.data.entity.CityListEntity;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.annotations.NonNull;

@Singleton
public class CityEntityJsonMapper {
    private final Gson gson;

    @Inject
    public CityEntityJsonMapper() {
        this.gson = new Gson();
    }

    public List<CityEntity> transformCitiesEntity(@NonNull String citiesJson) throws JsonSyntaxException {
        final Type citiesEntityType = new TypeToken<CityListEntity>() {
        }.getType();
        CityListEntity cityListEntity = this.gson.fromJson(citiesJson, citiesEntityType);
        return mapCitiesEntityToCityEntityList(cityListEntity);
    }

    public List<CityEntity> mapCitiesEntityToCityEntityList(@NonNull CityListEntity cityListEntity) {
        return cityListEntity.getCities();
    }
}
