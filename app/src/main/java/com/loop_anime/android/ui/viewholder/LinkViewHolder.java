package com.loop_anime.android.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.loop_anime.android.databinding.ViewItemLinkBinding;
import com.loop_anime.android.model.dao.Link;
import com.loop_anime.android.viewmodel.LinkViewModel;

/**
 * User: Yilun Chen
 * Date: 15/11/3
 */
public class LinkViewHolder extends RecyclerView.ViewHolder {

    private final ViewItemLinkBinding mBinding;

    public static LinkViewHolder create(LayoutInflater inflater, ViewGroup parent) {
        ViewItemLinkBinding binding =
                ViewItemLinkBinding.inflate(inflater, parent, false);
        binding.setViewModel(new LinkViewModel(parent.getContext(), null));
        return new LinkViewHolder(binding);
    }

    public LinkViewHolder(ViewItemLinkBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bindTo(Link link) {
        mBinding.getViewModel().setLink(link);
        mBinding.setViewModel(mBinding.getViewModel());
        mBinding.executePendingBindings();
    }


}
