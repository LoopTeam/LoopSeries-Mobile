package com.loop_anime.android.view.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loop_anime.android.R;
import com.loop_anime.android.model.api.API;
import com.loop_anime.android.databinding.FragmentAnimesBinding;
import com.loop_anime.android.model.db.Table;
import com.loop_anime.android.model.db.TypeMapping;
import com.loop_anime.android.model.dao.Anime;
import com.loop_anime.android.view.ui.adapter.AnimesAdapter;
import com.loop_anime.android.utils.StorIOUtils;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.queries.Query;

import java.util.ArrayList;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        updateFromDB();
        Subscription subscription = API.getAnimes(getActivity(), 20, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(arrayListPayload -> mStorIOSQLite
                        .put()
                        .objects(arrayListPayload.getPayload())
                        .prepare()
                        .createObservable())
                .subscribe(
                        result -> {
                        },
                        throwable -> Log.v("ANIME_FRAGMENT", throwable.getMessage())
                );
        mCompositeSubscription.add(subscription);
    }

    private void updateFromDB() {
        Subscription subscription = mStorIOSQLite.get()
                .listOfObjects(Anime.class)
                .withQuery(Query.builder()
                                .table(Table.Anime.TABLE_NAME)
                                .build()
                )
                .prepare()
                .createObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        animes -> mAdapter.setAnimes(new ArrayList<>(animes)),
                        throwable -> Log.v("ANIME_FRAGMENT", throwable.getMessage())
                );
        mCompositeSubscription.add(subscription);
    }
}
