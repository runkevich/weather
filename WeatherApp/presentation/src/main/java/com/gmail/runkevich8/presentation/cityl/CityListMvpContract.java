package com.gmail.runkevich8.presentation.cityl;


import com.gmail.runkevich8.presentation.base.BaseLoadDataView;
import com.gmail.runkevich8.presentation.base.BasePresenterContract;

public interface CityListMvpContract {
    interface View extends BaseLoadDataView {

        void renderCity(CityModel cityModel);

        Observable<CityModel> cityClick();
    }

    interface Presenter extends BasePresenterContract {
        void onCityClick(CityModel cityModel);
    }
}
