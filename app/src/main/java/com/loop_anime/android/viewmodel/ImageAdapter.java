package com.loop_anime.android.viewmodel;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingComponent;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * User: Yilun Chen
 * Date: 15/10/17
 */
public interface ImageAdapter {

    @BindingAdapter(value = {"android:src", "placeHolder", "noAnimation"}, requireAll = false)
    void loadImage(DataBindingComponent component,
                   ImageView imageView,
                   String imageURL,
                   Drawable drawable,
                   boolean noAnimation);

}
