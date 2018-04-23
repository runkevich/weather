package com.gmail.runkevich8.injection;

import com.gmail.runkevich8.presentation.screen.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivityViewModel mainActivityViewModel);

}
