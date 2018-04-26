package com.gmail.runkevich8.domain.repository;


import com.gmail.runkevich8.domain.entity.City;

import io.reactivex.Observable;

public interface CityRepository {
    Observable<City> cites();
}
