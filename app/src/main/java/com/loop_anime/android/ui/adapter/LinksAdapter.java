package com.loop_anime.android.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.loop_anime.android.model.dao.Link;
import com.loop_anime.android.ui.viewholder.LinkViewHolder;

import java.util.ArrayList;

/**
 * User: Yilun Chen
 * Date: 15/11/3
 */
public class LinksAdapter extends RecyclerView.Adapter<LinkViewHolder> {

    private ArrayList<Link> mLinks;

    @Override
    public LinkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return LinkViewHolder.create(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(LinkViewHolder holder, int position) {
        holder.bindTo(mLinks.get(position));
    }

    @Override
    public int getItemCount() {
        return mLinks == null ? 0 : mLinks.size();
    }

    public void setLinks(ArrayList<Link> links) {
        mLinks = links;
        notifyDataSetChanged();
    }
}
