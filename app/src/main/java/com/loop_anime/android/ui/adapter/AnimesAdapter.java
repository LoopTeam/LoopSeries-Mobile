package com.loop_anime.android.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.loop_anime.android.model.Anime;
import com.loop_anime.android.ui.viewholder.AnimeViewHolder;

import java.util.ArrayList;

/**
 * User: Yilun Chen
 * Date: 15/10/15
 */
public class AnimesAdapter extends RecyclerView.Adapter<AnimeViewHolder> {

    ArrayList<Anime> mAnimes;

    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return AnimeViewHolder.create(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(AnimeViewHolder holder, int position) {
        holder.bindTo(mAnimes.get(position));
    }

    @Override
    public int getItemCount() {
        return mAnimes == null ? 0 : mAnimes.size();
    }

    public void setAnimes(ArrayList<Anime> animes) {
        mAnimes = animes;
        notifyDataSetChanged();
    }
}
