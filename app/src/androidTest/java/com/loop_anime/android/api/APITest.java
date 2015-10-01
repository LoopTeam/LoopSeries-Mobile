package com.loop_anime.android.api;

import com.loop_anime.android.model.AuthToken;

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
    }
}