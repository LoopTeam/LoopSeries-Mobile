package com.loop_anime.android.ui.viewholder;

import android.databinding.DataBindingComponent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.loop_anime.android.databinding.ViewItemEpisodeBinding;
import com.loop_anime.android.model.dao.Episode;
import com.loop_anime.android.viewmodel.DataBindingComponentImpl;
import com.loop_anime.android.viewmodel.EpisodeViewModel;

/**
 * User: Yilun Chen
 * Date: 15/11/2
 */
public class EpisodeViewHolder extends RecyclerView.ViewHolder {

    static DataBindingComponent sDataBindingComponent = new DataBindingComponentImpl();

    private ViewItemEpisodeBinding mBinding;

    public static EpisodeViewHolder create(LayoutInflater inflater, ViewGroup parent) {
        ViewItemEpisodeBinding binding =
                ViewItemEpisodeBinding.inflate(inflater, parent, false, sDataBindingComponent);
        binding.setViewModel(new EpisodeViewModel(parent.getContext(), null));
        return new EpisodeViewHolder(binding);
    }

    public EpisodeViewHolder(ViewItemEpisodeBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bindTo(Episode episode) {
        mBinding.getViewModel().setEpisode(episode);
        mBinding.setViewModel(mBinding.getViewModel());
        mBinding.executePendingBindings();
    }

}
