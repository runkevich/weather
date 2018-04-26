package com.gmail.runkevich8.domain.interactor.modify;


import com.gmail.runkevich8.domain.entity.Weather;
import com.gmail.runkevich8.domain.entity.WeatherRaw;

import io.reactivex.ObservableTransformer;

public interface WeatherTransformer {
    ObservableTransformer<WeatherRaw, Weather> apply();
}
