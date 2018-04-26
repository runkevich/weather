package com.gmail.runkevich8.presentation.cityl;

import com.gmail.runkevich8.domain.entity.City;
import com.gmail.runkevich8.domain.exception.DefaultErrorBundle;
import com.gmail.runkevich8.domain.exception.ErrorBundle;
import com.gmail.runkevich8.domain.interactor.DefaultObserver;
import com.gmail.runkevich8.domain.interactor.GetCityList;
import com.gmail.runkevich8.exception.ErrorMessageFactory;
import com.gmail.runkevich8.injection.model.CityModel;
import com.gmail.runkevich8.mapper.CityModelDataMapper;
import com.gmail.runkevich8.navigation.Navigator;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;



public class CityListPresenter implements CityListMvpContract.Presenter {

    private CityListMvpContract.View cityListView;

    private final GetCityList getCityListUseCase;
    private final CityModelDataMapper cityModelDataMapper;
    private final Navigator navigator;

    private Disposable cityClickDisposable;

    @Inject
    public CityListPresenter(GetCityList getCityListUseCase, CityModelDataMapper cityModelDataMapper,
                             Navigator navigator) {
        this.getCityListUseCase = getCityListUseCase;
        this.cityModelDataMapper = cityModelDataMapper;
        this.navigator = navigator;
    }

    public void setView(@NonNull CityListMvpContract.View view) {
        this.cityListView = view;
    }

    @Override
    public void resume() {
        bindViewIntents();
    }

    @Override
    public void pause() {
        this.cityClickDisposable.dispose();
    }

    @Override
    public void destroy() {
        this.getCityListUseCase.dispose();
        this.cityListView = null;
    }

    public void initialize() {
        this.loadCityList();
    }

    private void loadCityList() {
        this.showViewLoading();
        this.getCityList();
    }

    private void showViewLoading() {
        this.cityListView.showLoading(true);
    }

    private void hideViewLoading() {
        this.cityListView.showLoading(false);
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage =
                ErrorMessageFactory.create(this.cityListView.context(), errorBundle.getException());
        this.cityListView.showError(errorMessage);
    }

    private void showCityInView(City city) {
        final CityModel cityModels = this.cityModelDataMapper.transform(city);
        this.cityListView.renderCity(cityModels);
    }

    private void getCityList() {
        this.getCityListUseCase.execute(new CityListObserver(), null);
    }

    @Override
    public void onCityClick(CityModel cityModel) {
        navigator.navigateToWeather(cityListView.context(), cityModel.getId());
    }

    @Override
    public void bindViewIntents() {
        cityClickDisposable = cityListView.cityClick().subscribe(this::onCityClick);
    }

    private final class CityListObserver extends DefaultObserver<City> {

        @Override
        public void onComplete() {
            CityListPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            CityListPresenter.this.hideViewLoading();
            CityListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
        }

        @Override
        public void onNext(City city) {
            CityListPresenter.this.showCityInView(city);
        }
    }
}
