package com.gmail.runkevich8.injection.module;


import android.content.Context;
import android.content.res.AssetManager;

import com.gmail.runkevich8.app.AndroidApplication;
import com.gmail.runkevich8.data.database.AssetsReaderImpl;
import com.gmail.runkevich8.data.database.DiskApi;
import com.gmail.runkevich8.data.database.DiskApiImpl;
import com.gmail.runkevich8.data.database.StreamReader;
import com.gmail.runkevich8.data.database.StreamReaderImpl;
import com.gmail.runkevich8.data.entity.citydata.CityEntityJsonMapper;
import com.gmail.runkevich8.data.executor.JobExecutor;
import com.gmail.runkevich8.data.net.WeatherRestApi;
import com.gmail.runkevich8.data.net.WeatherRestApiImpl;
import com.gmail.runkevich8.data.net.retrofit.Config;
import com.gmail.runkevich8.data.net.retrofit.WeatherRestApiFactory;
import com.gmail.runkevich8.data.net.retrofit.WeatherRestApiI;
import com.gmail.runkevich8.data.repository.CityDataRepository;
import com.gmail.runkevich8.data.repository.WeatherDataRepository;
import com.gmail.runkevich8.domain.executor.PostExecutionThread;
import com.gmail.runkevich8.domain.executor.ThreadExecutor;
import com.gmail.runkevich8.domain.interactor.GetCityList;
import com.gmail.runkevich8.domain.interactor.modify.CitySorting;
import com.gmail.runkevich8.domain.interactor.modify.CitySortingImpl;
import com.gmail.runkevich8.domain.interactor.modify.TempConverter;
import com.gmail.runkevich8.domain.interactor.modify.TempConverterImpl;
import com.gmail.runkevich8.domain.interactor.modify.WeatherTransformer;
import com.gmail.runkevich8.domain.interactor.modify.WeatherTransformerImpl;
import com.gmail.runkevich8.domain.repository.CityRepository;
import com.gmail.runkevich8.domain.repository.WeatherRepository;
import com.gmail.runkevich8.executor.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
@Module
public class ApplicationModule {
    private static final String CITIES_FILE_NAME = "cities.txt";
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    CitySorting provideCitySorting(CitySortingImpl citySorter) {
        return citySorter;
    }

    @Provides
    TempConverter provideTempConverter(TempConverterImpl tempConverter) {
        return tempConverter;
    }

    @Provides
    WeatherTransformer provideWeatherTempCalc(WeatherTransformerImpl weatherTransformer) {
        return weatherTransformer;
    }

    @Provides
    GetCityList provideGetCityList(GetCityList getCityList) {
        return getCityList;
    }

    @Provides
    @Singleton
    WeatherRepository provideWeatherRepository(
            WeatherDataRepository weatherDataRepository) {
        return weatherDataRepository;
    }

    @Provides
    @Singleton
    CityRepository provideCityRepository(CityDataRepository cityDataRepository) {
        return cityDataRepository;
    }

    @Provides
    @Singleton
    WeatherRestApiI provideWeatherRestApiI() {
        return new WeatherRestApiFactory(Config.API_BASE_URL).get();
    }

    @Provides
    @Singleton
    WeatherRestApi provideWeatherRestApi(WeatherRestApiImpl weatherRestApi) {
        return weatherRestApi;
    }

    @Provides
    @Singleton
    DiskApi provideDiskApi(AssetsReaderImpl assetsReader,
                           CityEntityJsonMapper cityEntityJsonMapper) {
        return new DiskApiImpl(CITIES_FILE_NAME, assetsReader, cityEntityJsonMapper);
    }

    @Provides
    @Singleton
    StreamReader provideStreamReader(StreamReaderImpl streamReader) {
        return streamReader;
    }

    @Provides
    @Singleton
    AssetManager provideAssetManager() {
        return application.getAssets();
    }
}
