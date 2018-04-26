package com.gmail.runkevich8.injection.component;


import com.gmail.runkevich8.injection.PerActivity;
import com.gmail.runkevich8.injection.module.ActivityModule;
import com.gmail.runkevich8.injection.module.WeatherModule;
import com.gmail.runkevich8.presentation.weather.WeatherFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, WeatherModule.class})
public interface WeatherComponent extends ActivityComponent {

    void inject(WeatherFragment weatherFragment);
}
