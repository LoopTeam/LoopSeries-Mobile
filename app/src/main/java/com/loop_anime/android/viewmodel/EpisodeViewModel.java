package com.loop_anime.android.viewmodel;

import android.content.Context;
import android.view.View;

import com.loop_anime.android.model.dao.Episode;
import com.loop_anime.android.ui.activity.LinksActivity;

/**
 * User: Yilun Chen
 * Date: 15/11/2
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class EpisodeViewModel {

    private Context mContext;

    private Episode mEpisode;

    public EpisodeViewModel(Context context, Episode episode) {
        mContext = context;
        mEpisode = episode;
    }

    public Episode getEpisode() {
        return mEpisode;
    }

    public void setEpisode(Episode episode) {
        mEpisode = episode;
    }

    public void onClickEpisode(View view) {
        LinksActivity.startActivity(mContext, mEpisode.getId());
    }
}
