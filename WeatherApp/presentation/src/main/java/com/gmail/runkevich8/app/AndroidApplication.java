package com.gmail.runkevich8.app;


import android.app.Application;

import com.gmail.runkevich8.injection.component.ApplicationComponent;
import com.gmail.runkevich8.injection.component.DaggerApplicationComponent;
import com.gmail.runkevich8.injection.module.ApplicationModule;

import com.squareup.leakcanary.LeakCanary;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
       // if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
      //  }
    }
}