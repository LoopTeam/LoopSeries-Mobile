package com.loop_anime.android.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loop_anime.android.R;
import com.loop_anime.android.databinding.FragmentAnimesBinding;
import com.loop_anime.android.model.api.API;
import com.loop_anime.android.model.dao.Anime;
import com.loop_anime.android.model.db.Table;
import com.loop_anime.android.model.db.TypeMapping;
import com.loop_anime.android.ui.adapter.AnimesAdapter;
import com.loop_anime.android.ui.listener.RecyclerPaginationListener;
import com.loop_anime.android.utils.StorIOUtils;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.operations.put.PutResults;
import com.pushtorefresh.storio.sqlite.queries.DeleteQuery;
import com.pushtorefresh.storio.sqlite.queries.Query;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * User: Yilun Chen
 * Date: 15/10/15
 */
public class AnimesFragment extends BaseFragment {

    private static final int ITEM_PER_PAGE = 20;

    private FragmentAnimesBinding mBinding;

    private AnimesAdapter mAdapter;

    private StorIOSQLite mStorIOSQLite;

    private boolean initialized = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStorIOSQLite = StorIOUtils.getStorIOLite(getActivity(), TypeMapping.MAPPING.ANIME);
        mAdapter = new AnimesAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mBinding != null) {
            initialized = true;
            return mBinding.getRoot();
        } else {
            initialized = false;
        }
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(getContext()),
                R.layout.fragment_animes,
                container,
                false);
        return mBinding.getRoot();
    }

    private RecyclerPaginationListener mPaginationListener = new RecyclerPaginationListener(1) {
        @Override
        public void onLoadMore(int page) {
            loadAnimes(page);
        }
    };

    private void loadAnimes(int page) {
        Subscription subscription = API.getAnimes(getActivity(), ITEM_PER_PAGE, page)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(arrayListPayload -> {
                    if (arrayListPayload.getPayload().size() == 0) {
                        mPaginationListener.reachEnd();
                        return Observable.just(null);
                    }
                    Observable<PutResults<Anime>> saveObservable = mStorIOSQLite
                            .put()
                            .objects(arrayListPayload.getPayload())
                            .prepare()
                            .createObservable();
                    if (page == 1) {
                        //delete the db for a brand new refresh
                        return mStorIOSQLite.delete().byQuery(
                                DeleteQuery.builder()
                                        .table(Table.Anime.TABLE_NAME)
                                        .build()
                        ).prepare().createObservable().flatMap(deleteResult -> saveObservable);
                    } else {
                        return saveObservable;
                    }
                }).subscribe(
                        result -> {
                            mPaginationListener.loadFinished(true);
                            mBinding.swipeLayoutAnimes.post(
                                    () -> mBinding.swipeLayoutAnimes.setRefreshing(false)
                            );
                        },
                        throwable -> {
                            mPaginationListener.loadFinished(false);
                            mBinding.swipeLayoutAnimes.post(
                                    () -> mBinding.swipeLayoutAnimes.setRefreshing(false)
                            );
                            Log.v("ANIME_FRAGMENT", throwable.getMessage());
                        }
                );
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.recyclerAnimes.setHasFixedSize(true);
        mBinding.recyclerAnimes.setAdapter(mAdapter);
        mBinding.swipeLayoutAnimes.setOnRefreshListener(
                () -> mPaginationListener.setUpWithRecyclerView(mBinding.recyclerAnimes));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!initialized) {
            updateFromDB();
            mPaginationListener.setUpWithRecyclerView(mBinding.recyclerAnimes);
        }
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
