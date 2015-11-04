package com.loop_anime.android.viewmodel;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.loop_anime.android.R;
import com.loop_anime.android.model.api.API;
import com.loop_anime.android.model.dao.DirectLink;
import com.loop_anime.android.model.dao.Link;
import com.loop_anime.android.ui.activity.BaseActivity;
import com.loop_anime.android.utils.VideoUtils;

import java.util.concurrent.TimeUnit;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * User: Yilun Chen
 * Date: 15/11/2
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class LinkViewModel {

    private static final String LOG_TAG = LinkViewModel.class.getSimpleName();

    private Context mContext;

    private Link mLink;

    public LinkViewModel(Context context, Link link) {
        mContext = context;
        mLink = link;
    }

    public Link getLink() {
        return mLink;
    }

    public void setLink(Link link) {
        mLink = link;
    }

    public void onClickLink(View view) {
        if (mContext instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) mContext;
            Subscription subscription = API.getDirectLink(activity, mLink.getId())
                    .observeOn(AndroidSchedulers.mainThread())
                    .timeout(5, TimeUnit.SECONDS)
                    .subscribe(directLink -> {
                        //launch with external player
                        DirectLink.DirectLinkEntity dl = directLink.getDirectLink();
                        if (dl != null && dl.getDq() != null && dl.getDq().size() > 0) {
                            VideoUtils.launchVideoURLWithExternalPlayer(view.getContext(), dl.getDq().get(0));
                        } else {
                            Snackbar.make(view, R.string.error_no_link, Snackbar.LENGTH_SHORT).show();
                        }
                    }, throwable -> {
                        Log.e(LOG_TAG, throwable.getMessage());
                        Toast.makeText(view.getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    });
            activity.mCompositeSubscription.add(subscription);
        }
    }
}

