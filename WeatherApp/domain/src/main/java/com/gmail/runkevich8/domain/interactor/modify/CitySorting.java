package com.gmail.runkevich8.domain.interactor.modify;


import com.gmail.runkevich8.domain.entity.City;

import java.util.List;

import io.reactivex.ObservableTransformer;

public interface CitySorting {
    ObservableTransformer<City, City> apply();

    ObservableTransformer<List<City>, List<City>> applyList();
}
