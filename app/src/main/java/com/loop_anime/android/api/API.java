package com.loop_anime.android.api;

import android.content.Context;

import com.loop_anime.android.LoopAnimeAPISettings;
import com.loop_anime.android.model.AuthToken;

import rx.Observable;


/**
 * User: Yilun Chen
 * Date: 01/10/15
 */
public class API {

    /**
     * please see http://git.io/vcure to setup your own server
     * or PM @joshlopes to ask for our domain/clientId/secret
     */
    private static final String CLIENT_ID = LoopAnimeAPISettings.CLIENT_ID;

    private static final String CLIENT_SECRET = LoopAnimeAPISettings.CLIENT_SECRET;

    public static Observable<AuthToken> getAuthTokenFromServer() {
        return APIFactory.instance().getToken(CLIENT_ID,
                CLIENT_SECRET,
                "client_credentials");
    }

    public static Observable<AuthToken> getAuthTokenIfAvailable(Context context) {
        if (AuthToken.isExpired(context)) {
            return getAuthTokenFromServer();
        } else {
            return Observable.just(AuthToken.getToken(context));
        }
    }

}
