package com.loop_anime.android.viewmodel.adapter;

import android.databinding.DataBindingComponent;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.loop_anime.android.utils.ImageUtils;

/**
 * User: Yilun Chen
 * Date: 15/10/17
 */
public class ImageAdapterImpl implements ImageAdapter {

    @Override
    public void loadImage(DataBindingComponent component,
                          ImageView imageView,
                          String imageURL,
                          Drawable drawable,
                          boolean noAnimation,
                          int colorFilter) {
        DrawableRequestBuilder<String> builder = Glide.with(imageView.getContext())
                .load(ImageUtils.getImageURL(imageURL))
                .placeholder(drawable)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();
        if (noAnimation) {
            builder.dontAnimate();
        } else {
            DrawableRequestBuilder<String> preLoaderBuilder = Glide.with(imageView.getContext())
                    .load(ImageUtils.getImagePreloadURL(imageURL)).centerCrop();
            builder.thumbnail(preLoaderBuilder);
            builder.crossFade(600);
        }
        builder.into(imageView);
        if (colorFilter != 0) {
            imageView.setColorFilter(colorFilter);
        } else {
            imageView.setColorFilter(null);
        }
    }

}
