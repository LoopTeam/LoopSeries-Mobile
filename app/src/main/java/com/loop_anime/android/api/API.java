package com.loop_anime.android.api;

import android.content.Context;

import com.loop_anime.android.LoopAnimeAPISettings;
import com.loop_anime.android.model.Anime;
import com.loop_anime.android.model.AuthToken;
import com.loop_anime.android.model.Payload;

import java.util.List;

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

    private static Observable<String> getAuthTokenFromServer() {
        return APIFactory.instance().getToken(CLIENT_ID,
                CLIENT_SECRET,
                "client_credentials").map(AuthToken::getAccessToken);
    }

    /**
     * @param context context
     * @return return an observable with AuthToken for further API calls,
     * if not in SharedPreferences request from server
     */
    private static Observable<String> getAuthTokenIfAvailable(Context context) {
        if (AuthToken.isExpired(context)) {
            return getAuthTokenFromServer();
        } else {
            return Observable.just(AuthToken.getToken(context))
                    .map(AuthToken::getAccessToken);
        }
    }

    public static Observable<Payload<List<Anime>>> getAnimes(Context context, int limit, int page) {
        return getAuthTokenIfAvailable(context)
                .flatMap(token -> APIFactory.instance().getAnimes(token, limit, page));
    }

}
