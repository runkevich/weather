package com.gmail.runkevich8.presentation.cityl;


import com.gmail.runkevich8.injection.model.CityModel;
import com.gmail.runkevich8.presentation.base.BaseLoadDataView;
import com.gmail.runkevich8.presentation.base.BasePresenterContract;

import io.reactivex.Observable;

public interface CityListMvpContract {
    interface View extends BaseLoadDataView {

        void renderCity(CityModel cityModel);

        Observable<CityModel> cityClick();
    }

    interface Presenter extends BasePresenterContract {
        void onCityClick(CityModel cityModel);
    }
}
