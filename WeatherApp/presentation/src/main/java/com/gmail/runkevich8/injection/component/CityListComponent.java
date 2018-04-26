package com.gmail.runkevich8.injection.component;

import com.gmail.runkevich8.injection.PerActivity;
import com.gmail.runkevich8.injection.module.ActivityModule;
import com.gmail.runkevich8.injection.module.CityListModule;
import com.gmail.runkevich8.presentation.cityl.CityListFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, CityListModule.class})
public interface  CityListComponent extends ActivityComponent {
    void inject(CityListFragment cityListFragment);
}