package com.gmail.runkevich8.injection.component;

import android.app.Activity;

import com.gmail.runkevich8.injection.PerActivity;
import com.gmail.runkevich8.injection.module.ActivityModule;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {


        Activity activity();
}
