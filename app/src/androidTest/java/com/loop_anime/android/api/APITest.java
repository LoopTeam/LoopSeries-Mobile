package com.loop_anime.android.api;

import android.text.TextUtils;
import android.util.Log;

import com.loop_anime.android.model.AuthToken;

import junit.framework.Assert;
import junit.framework.TestCase;

import rx.observers.TestSubscriber;

/**
 * User: Yilun Chen
 * Date: 01/10/15
 */
public class APITest extends TestCase {

    public void testGetAuthToken() throws Exception {
        TestSubscriber<AuthToken> testSubscriber = new TestSubscriber<>();
        API.getAuthTokenFromServer().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        String accessToken = testSubscriber.getOnNextEvents().get(0).getAccessToken();
        Log.v("ACCESS_TOKEN", accessToken);
        Assert.assertFalse(TextUtils.isEmpty(accessToken));
    }
}