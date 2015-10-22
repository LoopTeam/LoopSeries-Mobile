package com.loop_anime.android.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loop_anime.android.databinding.FragmentAnimeBinding;
import com.loop_anime.android.model.api.API;
import com.loop_anime.android.model.dao.Anime;
import com.loop_anime.android.viewmodel.AnimeViewModel;
import com.loop_anime.android.viewmodel.DataBindingComponentImpl;

import rx.android.schedulers.AndroidSchedulers;

/**
 * User: Yilun Chen
 * Date: 15/10/21
 */
public class AnimeFragment extends BaseFragment {


    private static final String ARGUMENT_ANIME = "ARGUMENT_ANIME";

    private FragmentAnimeBinding mBinding;

    private Anime mAnime;

    private AnimeViewModel mAnimeViewModel;

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
        super.onViewCreated(view, savedInstanceState);
        mAnime = (Anime) getArguments().getSerializable(ARGUMENT_ANIME);
        mAnimeViewModel = new AnimeViewModel(getActivity(), mAnime);
        mBinding.setViewModel(mAnimeViewModel);
        API.getAnime(getActivity(), mAnime.getId())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        anime -> {
                            mAnimeViewModel.setAnime(anime);
                            mBinding.setViewModel(mAnimeViewModel);
                        },
                        throwable -> Log.v("ANIME_FRAGMENT", throwable.getMessage())
                );
    }
}
