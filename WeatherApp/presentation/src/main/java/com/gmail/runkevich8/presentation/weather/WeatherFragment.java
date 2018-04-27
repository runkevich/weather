package com.gmail.runkevich8.presentation.weather;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fernandocejas.arrow.checks.Preconditions;
import com.gmail.runkevich8.injection.component.WeatherComponent;
import com.gmail.runkevich8.presentation.base.BaseFragment;
import com.gmail.runkevich8.presentation.utills.ImageLoader;
import com.gmail.runkevich8.weatherapp.R;
import com.jakewharton.rxbinding2.support.v4.widget.RxSwipeRefreshLayout;
import com.jakewharton.rxbinding2.view.RxView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class WeatherFragment extends BaseFragment implements WeatherMvpContract.View {
    private static final String PARAM_CITY_ID = "param_city_id";

    @Inject
    WeatherPresenter weatherPresenter;

    @BindView(R.id.tv_city_name)
    TextView tvCityName;
    @BindView(R.id.tv_weather_description)
    TextView tvWeatherDescription;
    @BindView(R.id.imv_icon)
    ImageView imvIcon;
    @BindView(R.id.tv_current_temp)
    TextView tvCurrentTemp;
    @BindView(R.id.tv_today_temp_range)
    TextView tvTodayTempRange;
    @BindView(R.id.btn_celsius)
    Button btnCelsius;
    @BindView(R.id.btn_fahrenheit)
    Button btnFahrenheit;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.progress_bar_weather)
    ProgressBar progressBar;
    @BindView(R.id.tv_error_message)
    TextView tvErrorMessage;

    public static WeatherFragment forCity(String cityId) {
        final WeatherFragment weatherFragment = new WeatherFragment();
        final Bundle arguments = new Bundle();
        arguments.putString(PARAM_CITY_ID, cityId);
        weatherFragment.setArguments(arguments);
        return weatherFragment;
    }

    public WeatherFragment() {
        setRetainInstance(true);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(WeatherComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.weather_fragment, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.weatherPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadWeather();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.weatherPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.weatherPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.weatherPresenter.destroy();
    }

    @Override
    public void renderWeather(WeatherViewModel weather) {
        showAllNonErrorViews(true);
        tvErrorMessage.setVisibility(View.GONE);
       if (weather != null) {
            this.tvCityName.setText(weather.getCityName());
            this.tvWeatherDescription.setText(weather.getDescription());
            this.tvCurrentTemp.setText(weather.getCurrentTemp());
            this.tvTodayTempRange.setText(weather.getTodayTempRange());
            this.progressBar.setVisibility(View.GONE);
            ImageLoader.fromUrl(getActivity(), this.imvIcon, weather.getIconUrl());
        }
    }

    @Override
    public void setRefreshing(boolean refreshing) {
        swipeRefresh.setRefreshing(refreshing);
    }

    public void showAllNonErrorViews(boolean show) {
        int visibility = show ? View.VISIBLE : View.GONE;
        btnCelsius.setVisibility(visibility);
        btnFahrenheit.setVisibility(visibility);
        tvCityName.setVisibility(visibility);
        tvWeatherDescription.setVisibility(visibility);
        imvIcon.setVisibility(visibility);
        tvCurrentTemp.setVisibility(visibility);
        tvTodayTempRange.setVisibility(visibility);
        progressBar.setVisibility(visibility);
    }

    @Override
    public Observable<Object> celsiusClick() {
        return RxView.clicks(btnCelsius);
    }

    @Override
    public Observable<Object> fahrenheitClick() {
        return RxView.clicks(btnFahrenheit);
    }

    @Override
    public Observable<Object> refresh() {
        return RxSwipeRefreshLayout.refreshes(swipeRefresh);
    }


    private String currentCityId() {
        final Bundle arguments = getArguments();
        Preconditions.checkNotNull(arguments, getString(R.string.fragment_args_cannot_be_null));
        return arguments.getString(PARAM_CITY_ID);
    }

    private void loadWeather() {
        if (this.weatherPresenter != null) {
            this.weatherPresenter.initialize(currentCityId());
        }
    }

    @Override
    public void showLoading(boolean show) {
        tvErrorMessage.setVisibility(View.GONE);
        showAllNonErrorViews(!show);
        this.progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError(String s) {
        showAllNonErrorViews(false);
        tvErrorMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }
}