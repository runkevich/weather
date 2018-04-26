package com.gmail.runkevich8.exception;


import android.content.Context;

import com.gmail.runkevich8.weatherapp.R;

public class ErrorMessageFactory {
    private ErrorMessageFactory() {
    }

    public static String create(Context context, Exception exception) {
        String message = context.getString(R.string.exception_message_generic);

        return message;
    }
}
