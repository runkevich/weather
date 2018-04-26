package com.gmail.runkevich8.presentation.weather;


import com.gmail.runkevich8.presentation.base.BaseLoadDataView;
import com.gmail.runkevich8.presentation.base.BasePresenterContract;

import io.reactivex.Observable;

public interface  WeatherMvpContract {
    interface View extends BaseLoadDataView {
        void renderWeather(WeatherViewModel weatherViewModel);

        void setRefreshing(boolean refreshing);

        Observable<Object> celsiusClick();

        Observable<Object> fahrenheitClick();

        Observable<Object> refresh();
    }

    interface Presenter extends BasePresenterContract {

        void onCelsiusClick();

        void onFahrenheitClick();

        void onRefresh();
    }
}
