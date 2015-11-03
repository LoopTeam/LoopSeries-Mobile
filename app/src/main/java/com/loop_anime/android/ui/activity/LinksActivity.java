package com.loop_anime.android.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.loop_anime.android.R;
import com.loop_anime.android.databinding.ActivityLinkBinding;
import com.loop_anime.android.model.api.API;
import com.loop_anime.android.ui.adapter.LinksAdapter;

import rx.android.schedulers.AndroidSchedulers;

/**
 * User: Yilun Chen
 * Date: 15/11/2
 */
public class LinksActivity extends BaseActivity {

    private static final String LOG_TAG = LinksActivity.class.getSimpleName();

    private static final String EXTRA_EPISODE_ID = "EXTRA_EPISODE_ID";

    @SuppressWarnings("FieldCanBeLocal")
    private ActivityLinkBinding mBinding;

    @SuppressWarnings("FieldCanBeLocal")
    private int mEpisodeId;

    private LinksAdapter mAdapter;

    public static void startActivity(Context context, int episodeId) {
        Intent intent = new Intent(context, LinksActivity.class);
        intent.putExtra(EXTRA_EPISODE_ID, episodeId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_link);
        mBinding.recyclerLinks.setHasFixedSize(true);
        mBinding.recyclerLinks.setLayoutManager(new LinearLayoutManager(this));
        mEpisodeId = getIntent().getIntExtra(EXTRA_EPISODE_ID, -1);

        mAdapter = new LinksAdapter();
        mBinding.recyclerLinks.setAdapter(mAdapter);

        API.getEpisodeLinks(this, mEpisodeId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((links) -> {
                    mAdapter.setLinks(links);
                    mBinding.progressLoading.setVisibility(View.GONE);
                }, throwable -> {
                    Log.e(LOG_TAG, throwable.getMessage());
                });
    }
}
