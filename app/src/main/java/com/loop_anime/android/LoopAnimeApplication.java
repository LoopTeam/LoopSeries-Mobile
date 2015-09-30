package com.loop_anime.android;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * User: Yilun Chen
 * Date: 30/09/2015
 */
public class LoopAnimeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
}
