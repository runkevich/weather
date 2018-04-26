package com.gmail.runkevich8.mapper;


import com.gmail.runkevich8.domain.entity.City;
import com.gmail.runkevich8.injection.PerActivity;
import com.gmail.runkevich8.injection.model.CityModel;

import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

@PerActivity
public class CityModelDataMapper {
    @Inject
    public CityModelDataMapper() {
    }

    public CityModel transform(@NonNull City city) {
        return new CityModel(city.getName(), city.getId());
    }

    public Collection<CityModel> transform(Collection<City> citysCollection) {
        Collection<CityModel> cityModelsCollection;

        if (citysCollection != null && !citysCollection.isEmpty()) {
            cityModelsCollection =
                    Observable.fromIterable(citysCollection).map(this::transform).toList().blockingGet();
        } else {
            cityModelsCollection = Collections.emptyList();
        }

        return cityModelsCollection;
    }
}
