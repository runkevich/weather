package com.gmail.runkevich8.presentation.weather;


import com.gmail.runkevich8.domain.entity.Weather;
import com.gmail.runkevich8.domain.exception.DefaultErrorBundle;
import com.gmail.runkevich8.domain.interactor.DefaultObserver;
import com.gmail.runkevich8.domain.interactor.GetWeather;
import com.gmail.runkevich8.injection.PerActivity;
import com.gmail.runkevich8.injection.model.WeatherModel;
import com.gmail.runkevich8.mapper.WeatherModelDataMapper;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

@PerActivity
public class WeatherPresenter implements WeatherMvpContract.Presenter {
    private String cityId;

    private boolean celsius = true;
    private boolean errorState;

    private WeatherMvpContract.View weatherView;
    private WeatherModel weatherModel;
    private CompositeDisposable compositeDisposable;
    private final GetWeather getWeatherUseCase;
    private final WeatherModelDataMapper weatherModelDataMapper;

    @Inject
    public WeatherPresenter(WeatherModelDataMapper weatherModelDataMapper,
                            GetWeather getWeatherUseCase) {
        this.weatherModelDataMapper = weatherModelDataMapper;
        this.getWeatherUseCase = getWeatherUseCase;
        this.compositeDisposable = new CompositeDisposable();
    }

    public void setView(@NonNull WeatherMvpContract.View view) {
        this.weatherView = view;
        this.updateView();
    }

    private void updateView() {
        if (weatherModel != null && !errorState) {
            showWeatherInView(celsius, weatherModel);
            bindViewIntents();
        } else {

            weatherView.showError(null);
        }
    }


    public void initialize(String cityId) {
        this.cityId = cityId;
        this.showViewLoading();
        this.getWeather(cityId);
    }

    private void showViewLoading() {
        this.weatherView.showLoading(true);
    }

    private void getWeather(String cityId) {
        this.getWeatherUseCase.execute(new WeatherObserver(), GetWeather.Params.forCity(cityId));
    }

    @Override
    public void resume() {
        bindViewIntents();
    }

    @Override
    public void pause() {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
    }

    @Override
    public void destroy() {
        this.compositeDisposable.dispose();
        this.getWeatherUseCase.dispose();
        this.weatherView = null;
    }

    private void hideViewLoading() {
        this.weatherView.showLoading(false);
    }

    private void showErrorMessage(DefaultErrorBundle defaultErrorBundle) {
        this.weatherView.showError(null);
    }

    public void showWeatherInView(boolean celsius, WeatherModel weatherModel) {
        if (weatherModel != null) {
            this.weatherView.renderWeather(weatherModelDataMapper.transform(celsius, weatherModel));
        }
    }

    public void setWeatherModel(Weather weather) {
        if (weather != null) {
            this.weatherModel = this.weatherModelDataMapper.transform(weather);
        }
    }

    @Override
    public void onCelsiusClick() {
        if (this.weatherModel != null) {
            showWeatherInView(this.celsius = true, this.weatherModel);
        }
    }

    @Override
    public void onFahrenheitClick() {
        showWeatherInView(this.celsius = false, this.weatherModel);
    }

    @Override
    public void onRefresh() {
        this.getWeather(cityId);
    }

    @Override
    public void bindViewIntents() {
        Disposable fahrenheitClickDisposable =
                this.weatherView.fahrenheitClick().subscribe(o -> onFahrenheitClick());

        Disposable celsiusClickDisposable =
                this.weatherView.celsiusClick().subscribe(o -> onCelsiusClick());

        Disposable refreshDisposabl = this.weatherView.refresh().subscribe(o -> onRefresh());

        compositeDisposable.add(refreshDisposabl);
        compositeDisposable.add(celsiusClickDisposable);
        compositeDisposable.add(fahrenheitClickDisposable);
    }

    private final class WeatherObserver extends DefaultObserver<Weather> {
        @Override
        public void onComplete() {
            WeatherPresenter.this.hideViewLoading();
            weatherView.setRefreshing(false);
        }

        @Override
        public void onError(Throwable e) {
            errorState = true;
            weatherView.setRefreshing(false);
            WeatherPresenter.this.hideViewLoading();
            WeatherPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
        }

        @Override
        public void onNext(Weather weather) {
            errorState = false;
            setWeatherModel(weather);
            updateView();
        }
    }
}