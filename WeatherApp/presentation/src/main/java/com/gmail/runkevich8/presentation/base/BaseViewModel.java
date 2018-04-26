//package com.gmail.runkevich8.presentation.base;
//
//
//import android.arch.lifecycle.ViewModel;
//
//import io.reactivex.disposables.CompositeDisposable;
//
//public abstract class BaseViewModel  extends ViewModel {
//
//
//    protected CompositeDisposable compositeDisposable = new CompositeDisposable();
//
//    public BaseViewModel(){
//        super();
//        createInject();
//    }
//
//    public abstract void createInject();
//
//
//    public void onStart(){
//
//    }
//    public void onResume() {
//
//    }
//
//    public void onPause(){
//
//    }
//    public void onStop(){
//
//    }
//
//    public void onDestroy(){
//
//    }
//
//    @Override
//    protected void onCleared() {
//        super.onCleared();
//        if(!compositeDisposable.isDisposed()){
//            compositeDisposable.dispose();
//        }
//    }
//}