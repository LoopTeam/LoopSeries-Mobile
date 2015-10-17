package com.loop_anime.android.viewmodel;

import android.databinding.DataBindingComponent;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.loop_anime.android.utils.ImageUtils;

/**
 * User: Yilun Chen
 * Date: 15/10/17
 */
public class ImageAdapterImpl implements ImageAdapter {

    @Override
    public void loadImage(DataBindingComponent component, ImageView imageView, String imageURL, Drawable drawable) {
        Glide.with(imageView.getContext()).load(ImageUtils.getImageURL(imageURL))
                .placeholder(drawable)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
                .into(imageView);
    }

}
