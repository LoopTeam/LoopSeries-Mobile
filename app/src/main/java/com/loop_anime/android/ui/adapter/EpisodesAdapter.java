package com.loop_anime.android.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.loop_anime.android.model.dao.Episode;
import com.loop_anime.android.ui.viewholder.EpisodeViewHolder;

import java.util.ArrayList;

/**
 * User: Yilun Chen
 * Date: 15/11/2
 */
public class EpisodesAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {

    ArrayList<Episode> mEpisodes;

    @Override
    public EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return EpisodeViewHolder.create(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(EpisodeViewHolder holder, int position) {
        holder.bindTo(mEpisodes.get(position));
    }

    @Override
    public int getItemCount() {
        return mEpisodes == null ? 0 : mEpisodes.size();
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        mEpisodes = episodes;
        notifyDataSetChanged();
    }
}
