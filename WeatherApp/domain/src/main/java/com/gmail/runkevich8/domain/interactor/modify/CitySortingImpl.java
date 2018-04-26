package com.gmail.runkevich8.domain.interactor.modify;

import com.gmail.runkevich8.domain.entity.City;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;


@Singleton
public class CitySortingImpl  implements CitySorting {
    private final Comparator<City> sortFunction;

    @Inject
    public CitySortingImpl() {
        this.sortFunction = new Comparator<City>() {
            @Override
            public int compare(City t, City t1) {
                return t.getName().compareTo(t1.getName());
            }
        };
    }

    @Override
    public ObservableTransformer<City, City> apply() {
        return new ObservableTransformer<City, City>() {
            @Override
            public ObservableSource<City> apply(@NonNull Observable<City> upstream) {
                return upstream.sorted(sortFunction);
            }
        };
    }

    @Override
    public ObservableTransformer<List<City>, List<City>> applyList() {
        return new ObservableTransformer<List<City>, List<City>>() {
            @Override
            public ObservableSource<List<City>> apply(@NonNull Observable<List<City>> upstream) {
                return upstream.doOnNext(new Consumer<List<City>>() {
                    @Override
                    public void accept(List<City> cities) throws Exception {
                        Collections.sort(cities, sortFunction);
                    }
                });
            }
        };
    }
}