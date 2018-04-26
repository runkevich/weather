//package com.gmail.runkevich8.app;
//
//import android.app.Application;
//
//import com.gmail.runkevich8.injection.AppComponent;
//import com.gmail.runkevich8.injection.AppModule;
//import com.gmail.runkevich8.injection.DaggerAppComponent;
//
//
//public class App extends Application {
//
//    public static AppComponent getAppComponent() {
//        return appComponent;
//    }
//
//    private static AppComponent appComponent;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//
//        appComponent
//                = DaggerAppComponent.builder()
//                .appModule(new AppModule(this))
//                .build();
//
//    }
//
//}
