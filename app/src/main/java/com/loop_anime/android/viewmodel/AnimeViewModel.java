package com.loop_anime.android.viewmodel;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.loop_anime.android.model.Anime;
import com.loop_anime.android.utils.ImageUtils;

/**
 * User: Yilun Chen
 * Date: 15/10/15
 */
public class AnimeViewModel {

    private Anime anime;

    public AnimeViewModel(Anime anime) {
        this.anime = anime;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    @BindingAdapter("binder:imageURL")
    public static void loadImage(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext()).load(ImageUtils.getImageURL(imageURL))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }

    public void onClickCard(View view) {

    }

}
