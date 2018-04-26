package com.gmail.runkevich8.presentation.base;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;

import com.gmail.runkevich8.app.AndroidApplication;
import com.gmail.runkevich8.injection.component.ApplicationComponent;
import com.gmail.runkevich8.injection.module.ActivityModule;
import com.gmail.runkevich8.navigation.Navigator;

import javax.inject.Inject;

public abstract  class BaseActivity extends Activity {

    @Inject
    protected Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected void addFragment(int containerViewId, Fragment fragment) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(containerViewId, fragment);
        ft.commit();
    }


    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}