package com.gmail.runkevich8.navigation;


import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Navigator {
    @Inject
    public Navigator() {
    }

    public void navigateToCityList(Context context) {
        if (context != null) {
            Intent intentToLaunch = CityListActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }

    public void navigateToWeather(Context context, String cityId) {
        if (context != null) {
            Intent intentToLaunch = WeatherActivity.getCallingIntent(context, cityId);
            context.startActivity(intentToLaunch);
        }
    }
}
