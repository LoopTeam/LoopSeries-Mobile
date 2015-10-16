package com.loop_anime.android.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loop_anime.android.R;
import com.loop_anime.android.api.API;
import com.loop_anime.android.databinding.FragmentAnimesBinding;
import com.loop_anime.android.db.TypeMapping;
import com.loop_anime.android.ui.adapter.AnimesAdapter;
import com.loop_anime.android.utils.StorIOUtils;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import rx.android.schedulers.AndroidSchedulers;

/**
 * User: Yilun Chen
 * Date: 15/10/15
 */
public class AnimesFragment extends BaseFragment {

    private FragmentAnimesBinding mBinding;

    private AnimesAdapter mAdapter;

    private StorIOSQLite mStorIOSQLite;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(getContext()),
                R.layout.fragment_animes,
                container,
                false);
        mStorIOSQLite = StorIOUtils.getStorIOLite(getActivity(), TypeMapping.MAPPING.ANIME);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.recyclerAnimes.setHasFixedSize(true);
        mAdapter = new AnimesAdapter();
        mBinding.recyclerAnimes.setAdapter(mAdapter);
        API.getAnimes(getActivity(), 20, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .map(arrayListPayload -> {
                    mStorIOSQLite.put().objects(arrayListPayload.getPayload()).prepare().executeAsBlocking();
                    return arrayListPayload.getPayload();
                })
                .subscribe(mAdapter::setAnimes, throwable -> {
                    Log.v("ANIME_FRAGMENT", throwable.getMessage());
                });
    }
}
