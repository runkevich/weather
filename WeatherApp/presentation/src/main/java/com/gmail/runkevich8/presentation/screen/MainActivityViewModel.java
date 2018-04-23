package com.gmail.runkevich8.presentation.screen;

import com.gmail.runkevich8.app.App;
import com.gmail.runkevich8.base.BaseViewModel;


public class MainActivityViewModel extends BaseViewModel {

//    @Inject
//    public GetDataUseCase getDataUseCase;

//    protected Location mLastLocation;
//
//    private FusedLocationProviderClient mFusedLocationClient;



    // public final ObservableField<List<Gif>> gifs = new ObservableField<>();

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public MainActivityViewModel() {
        getData();
       // mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

//    public void searchGif(Editable s) {
//        if (s == null || s.length() == 0){
//            getData();
//        }
//        getSearchUseCase.getSearch(s.toString()).subscribe(new Observer<List<Gif>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                compositeDisposable.add(d);
//            }
//
//            @Override
//            public void onNext(List<Gif> gif) {
//                gifs.set(gif);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
//    }

    public void getData() {
//        getDataUseCase
//               .getListWeathers()
//                .subscribe(new Observer<List<WeatherInfo>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                compositeDisposable.add(d);
//            }
//
//            @Override
//            public void onNext(List<WeatherInfo> weatherInfos) {
//                //weatherInfos.set(weatherInfos);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//                //Crashlytics.logException(e); - корректная ошибка(оработка в фабрике)
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }
}
