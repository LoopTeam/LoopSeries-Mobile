package com.loop_anime.android.viewmodel;

import android.content.Context;

import com.loop_anime.android.model.dao.Episode;

/**
 * User: Yilun Chen
 * Date: 15/11/2
 */
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

}
