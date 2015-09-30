package com.loop_anime.android.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.loop_anime.android.R;
import com.loop_anime.android.utils.ColorUtils;

import rx.subscriptions.CompositeSubscription;

/**
 * User: Yilun Chen
 * Date: 30/09/2015
 */
public abstract class BaseActivity extends AppCompatActivity {

    //container for batch RxJava unsubscription
    private CompositeSubscription mCompositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(ColorUtils.getColor(this, R.color.colorPrimaryDark));
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeSubscription.unsubscribe();
    }
}
