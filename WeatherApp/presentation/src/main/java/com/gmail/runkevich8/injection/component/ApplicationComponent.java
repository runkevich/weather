package com.gmail.runkevich8.injection.component;

import android.content.Context;

import com.gmail.runkevich8.domain.executor.PostExecutionThread;
import com.gmail.runkevich8.domain.executor.ThreadExecutor;
import com.gmail.runkevich8.domain.interactor.modify.CitySorting;
import com.gmail.runkevich8.domain.interactor.modify.TempConverter;
import com.gmail.runkevich8.domain.interactor.modify.WeatherTransformer;
import com.gmail.runkevich8.domain.repository.CityRepository;
import com.gmail.runkevich8.domain.repository.WeatherRepository;
import com.gmail.runkevich8.injection.module.ApplicationModule;
import com.gmail.runkevich8.navigation.Navigator;
import com.gmail.runkevich8.presentation.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);


    Context context();
    ThreadExecutor threadExecutor();
    WeatherRepository weatherRepository();
    PostExecutionThread postExecutionThread();
    CityRepository cityRepository();
    CitySorting citySorting();
    TempConverter tempConverter();
    WeatherTransformer weatherTransformer();
    Navigator navigator();
}
