package com.gmail.runkevich8.presentation.cityl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gmail.runkevich8.injection.HasComponent;
import com.gmail.runkevich8.injection.component.CityListComponent;
import com.gmail.runkevich8.injection.component.DaggerCityListComponent;
import com.gmail.runkevich8.presentation.base.BaseActivity;
import com.gmail.runkevich8.weatherapp.R;


public class CityListActivity extends BaseActivity implements HasComponent<CityListComponent> {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, CityListActivity.class);
    }

    private CityListComponent cityListComponent;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        this.initializeInjector();

        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new CityListFragment());
        }
    }

    private void initializeInjector() {
        this.cityListComponent = DaggerCityListComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override public CityListComponent getComponent() {
        return cityListComponent;
    }
}
