package com.loop_anime.android.model.api;

import android.text.TextUtils;
import android.util.Log;

import com.loop_anime.android.model.dao.AuthToken;

import junit.framework.Assert;
import junit.framework.TestCase;

import rx.observers.TestSubscriber;

/**
 * User: Yilun Chen
 * Date: 01/10/15
 */
public class APITest extends TestCase {

    public void testGetAuthToken() throws Exception {
        TestSubscriber<String> testSubscriber = new TestSubscriber<>();
        API.getAuthTokenFromServer()
                .map(AuthToken::getAccessToken)
                .subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        String accessToken = testSubscriber.getOnNextEvents().get(0);
        Log.v("ACCESS_TOKEN", accessToken);
        Assert.assertFalse(TextUtils.isEmpty(accessToken));
    }
}