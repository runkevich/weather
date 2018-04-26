package com.gmail.runkevich8.presentation.base;


import android.content.Context;
import android.support.annotation.Nullable;

public interface BaseLoadDataView {
    void showLoading(boolean show);

    /**
     * Show an error message
     *
     * @param message A string representing an error.
     */
    void showError(@Nullable String message);

    /**
     * Get a {@link android.content.Context}.
     */
    Context context();
}
