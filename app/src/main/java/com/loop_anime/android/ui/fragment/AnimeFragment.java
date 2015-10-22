package com.loop_anime.android.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loop_anime.android.databinding.FragmentAnimeBinding;
import com.loop_anime.android.model.dao.Anime;
import com.loop_anime.android.viewmodel.AnimeViewModel;
import com.loop_anime.android.viewmodel.DataBindingComponentImpl;

/**
 * User: Yilun Chen
 * Date: 15/10/21
 */
public class AnimeFragment extends BaseFragment {


    private static final String ARGUMENT_ANIME = "ARGUMENT_ANIME";

    private FragmentAnimeBinding mBinding;

    private Anime mAnime;

    public void setArguments(Anime anime) {
        Bundle arguments = new Bundle();
        arguments.putSerializable(ARGUMENT_ANIME, anime);
        super.setArguments(arguments);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentAnimeBinding.inflate(inflater, container, false, new DataBindingComponentImpl());
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mAnime = (Anime) getArguments().getSerializable(ARGUMENT_ANIME);
        if (mBinding != null) {
            mBinding.setViewModel(new AnimeViewModel(getActivity(), mAnime));
        }
        super.onViewCreated(view, savedInstanceState);
    }
}
