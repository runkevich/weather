package com.gmail.runkevich8.presentation.utills;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class ImageLoader {
    public static void fromUrl(Context context, ImageView imageView, String url) {
        Glide.with(context).load(url).into(imageView);
    }
}
