package com.loop_anime.android.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loop_anime.android.R;
import com.loop_anime.android.databinding.FragmentEpisodesBinding;
import com.loop_anime.android.model.api.API;
import com.loop_anime.android.ui.adapter.EpisodesAdapter;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * User: Yilun Chen
 * Date: 15/11/2
 */
public class EpisodesFragment extends BaseFragment {

    private static final String LOG_TAG = BaseFragment.class.getSimpleName();

    private static final String ARGUMENT_SEASON_ID = "ARGUMENT_SEASON_ID";

    private FragmentEpisodesBinding mBinding;

    private int mSeasonId;

    private EpisodesAdapter mAdapter;

    public void setSeason(int seasonId) {
        Bundle args = new Bundle();
        args.putInt(ARGUMENT_SEASON_ID, seasonId);
        setArguments(args);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mBinding == null) {
            mBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(getActivity()),
                    R.layout.fragment_episodes,
                    container,
                    false);
        }
        mSeasonId = getArguments().getInt(ARGUMENT_SEASON_ID);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBinding.recyclerEpisodes.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mBinding.recyclerEpisodes.setLayoutManager(layoutManager);
        mAdapter = new EpisodesAdapter();
        mBinding.recyclerEpisodes.setAdapter(mAdapter);
        Subscription subscription = API.getSeasonEpisodes(getActivity(), mSeasonId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mAdapter::setEpisodes,
                        throwable -> {
                            Log.e(LOG_TAG, throwable.getMessage());
                        });
        mCompositeSubscription.add(subscription);
    }

}
