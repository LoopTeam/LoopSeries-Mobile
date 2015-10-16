package com.loop_anime.android.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.loop_anime.android.R;
import com.loop_anime.android.model.dao.Anime;
import com.loop_anime.android.utils.ImageUtils;

/**
 * User: Yilun Chen
 * Date: 15/10/15
 */
public class AnimeViewModel {

    private Anime anime;

    private Context mContext;

    public AnimeViewModel(Context context, Anime anime) {
        this.anime = anime;
        mContext = context;
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
                .placeholder(R.color.background)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
                .into(imageView);
    }

    public void onClickCard(View view) {

    }

    public String getRatingString() {
        if (anime == null || anime.getRatingCount() <= 0) {
            return mContext.getString(R.string.anime_no_rating);
        }
        return mContext.getString(R.string.anime_rating, anime.getRating())
                + " "
                + mContext.getResources().getQuantityString(
                R.plurals.anime_rating_user_count,
                anime.getRatingCount(),
                anime.getRatingCount());
    }

}
