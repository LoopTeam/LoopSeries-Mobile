package com.loop_anime.android.viewmodel;

import android.content.Context;
import android.view.View;

import com.loop_anime.android.R;
import com.loop_anime.android.model.dao.Anime;

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
