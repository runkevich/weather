//package com.gmail.runkevich8.presentation.base;
//
//
//import android.databinding.DataBindingUtil;
//import android.databinding.ViewDataBinding;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//
//import com.gmail.runkevich8.weatherapp.BR;
//
//
//public abstract class BaseMvvmActivity <Binding extends ViewDataBinding,
//        ViewModel extends BaseViewModel >
//        extends AppCompatActivity {
//
//    protected ViewModel viewModel;
//    protected Binding binding;
//
//
//
//    public abstract int provideLayoutId();        //для того,чтобы найти Layout
//    public abstract ViewModel provideViewModel(); //нужен для поиска модели
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        viewModel = provideViewModel();
//        binding = DataBindingUtil.setContentView(this, provideLayoutId());
//        binding.setVariable(BR.viewModel,viewModel);
//
//    }
//
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        viewModel.onStart();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        viewModel.onPause();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        viewModel.onResume();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        viewModel.onStop();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
//}