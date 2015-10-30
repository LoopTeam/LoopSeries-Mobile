package com.loop_anime.android.ui.listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * User: Yilun Chen
 * Date: 15/10/29
 */
public class RecyclerPaginationListener extends RecyclerView.OnScrollListener {

    private static int THRESHOLD_LOADING_MORE = 3;

    private boolean mIsLoading = false;

    private boolean mIsEndReached = false;

    private int mCurrentPage;

    private final int mStartPage;

    public RecyclerPaginationListener() {
        this(0);
    }

    public RecyclerPaginationListener(int initialPage) {
        mCurrentPage = initialPage;
        mStartPage = initialPage;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        int lastItem = ((LinearLayoutManager) recyclerView.getLayoutManager())
                .findLastVisibleItemPosition();
        int totalItem = recyclerView.getAdapter().getItemCount();
        if (lastItem > totalItem - THRESHOLD_LOADING_MORE && !mIsLoading && !mIsEndReached) {
            onLoadMore(++mCurrentPage);
            mIsLoading = true;
        }
    }

    public void onLoadMore(int page) {
    }

    public void loadFinished(boolean isSuccess) {
        mIsLoading = false;
        if (!isSuccess) {
            mCurrentPage--;
        }
    }

    public void reachEnd() {
        mIsLoading = false;
        mIsEndReached = true;
    }

    public void setUpWithRecyclerView(RecyclerView recyclerView) {
        reset();
        recyclerView.addOnScrollListener(this);
        onLoadMore(1);
    }

    public void reset() {
        mCurrentPage = mStartPage;
        mIsLoading = false;
        mIsEndReached = false;
    }

}
