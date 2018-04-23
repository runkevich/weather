package com.gmail.runkevich8.injection;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.gmail.runkevich8.data.database.AppDatabase;
import com.gmail.runkevich8.data.database.WeatherDAO;
import com.gmail.runkevich8.data.net.RestApi;
import com.gmail.runkevich8.data.net.RestService;
import com.gmail.runkevich8.data.repository.WeatherRepositoryImp;
import com.gmail.runkevich8.domain.executor.PostExecutionThread;
import com.gmail.runkevich8.domain.repository.WeatherRepository;
import com.gmail.runkevich8.executor.UIThread;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    Context context;
    Retrofit retrofit;

    public static final String DATA_BASE_NAME = "database";

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context getContext() {
        return context;
    }

    @Provides
    @Singleton
    public WeatherRepository getWeatherRepository(WeatherDAO weatherDao,
                                                  RestApi restApi) {

        return new WeatherRepositoryImp(weatherDao,restApi);
    }

    @Provides
    @Singleton
    public AppDatabase getAppDatabase(Context context) {

        return Room.databaseBuilder(context,
                AppDatabase.class,
                "database")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    public PostExecutionThread getUiThread() {
        return new UIThread();
    }

    @Provides
    @Singleton
    public RestService getRestService(RestApi restAPI) {
        return new RestService(restAPI);
    }

    @Provides
    @Singleton//будет создан объект ретрофит на базен нашего интерфейса(т.е. с нашей реализацией)
    public RestApi getRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                //.client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public Gson getGson() {
        return new GsonBuilder()
                .create();
    }

}