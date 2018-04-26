package com.gmail.runkevich8.presentation.screen;


import android.os.Bundle;

import com.gmail.runkevich8.presentation.base.BaseActivity;
import com.gmail.runkevich8.weatherapp.R;

public class MainActivity extends BaseActivity {

    //todo to nice welcome screen
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigateToUserList();
        finish();
    }

    private void navigateToUserList() {
        this.navigator.navigateToCityList(this);
    }
}