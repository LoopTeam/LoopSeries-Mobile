package com.loop_anime.android.ui.viewholder;

import android.databinding.DataBindingComponent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.loop_anime.android.databinding.ViewItemAnimeBinding;
import com.loop_anime.android.model.dao.Anime;
import com.loop_anime.android.viewmodel.AnimeViewModel;
import com.loop_anime.android.viewmodel.DataBindingComponentImpl;

/**
 * User: Yilun Chen
 * Date: 15/10/15
 */
public class AnimeViewHolder extends RecyclerView.ViewHolder {

    static DataBindingComponent dataBindingComponent = new DataBindingComponentImpl();

    private ViewItemAnimeBinding mBinding;

    public static AnimeViewHolder create(LayoutInflater inflater, ViewGroup parent) {
        ViewItemAnimeBinding binding =
                ViewItemAnimeBinding.inflate(inflater, parent, false, dataBindingComponent);
        binding.setViewModel(new AnimeViewModel(parent.getContext(), null));
        return new AnimeViewHolder(binding);
    }

    public AnimeViewHolder(ViewItemAnimeBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bindTo(Anime anime) {
        mBinding.getViewModel().setAnime(anime);
        mBinding.setViewModel(mBinding.getViewModel());
        mBinding.executePendingBindings();
    }

}
