package com.gmail.runkevich8.presentation.base;


import android.content.Context;
import android.support.annotation.Nullable;

public interface BaseLoadDataView {
    void showLoading(boolean show);


    void showError(@Nullable String message);


    Context context();
}
