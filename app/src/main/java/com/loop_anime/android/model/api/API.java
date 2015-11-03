package com.loop_anime.android.model.api;

import android.content.Context;

import com.loop_anime.android.LoopAnimeAPISettings;
import com.loop_anime.android.model.dao.Anime;
import com.loop_anime.android.model.dao.AuthToken;
import com.loop_anime.android.model.dao.DirectLink;
import com.loop_anime.android.model.dao.Episode;
import com.loop_anime.android.model.dao.Link;
import com.loop_anime.android.model.dao.Payload;

import java.util.ArrayList;

import rx.Observable;
import rx.schedulers.Schedulers;


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
        return APIFactory.instance().getToken(
                CLIENT_ID,
                CLIENT_SECRET, "client_credentials")
                .subscribeOn(Schedulers.io());
    }

    /**
     * @param context context
     * @return return an observable with AuthToken for further API calls,
     * if not in SharedPreferences request from server
     */
    private static Observable<String> getAuthTokenIfAvailable(Context context) {
        if (AuthToken.isExpired(context)) {
            return getAuthTokenFromServer()
                    .map(authToken -> {
                        authToken.save(context);
                        return authToken.getAccessToken();
                    });
        } else {
            return Observable.just(AuthToken.getToken(context))
                    .subscribeOn(Schedulers.io())
                    .map(AuthToken::getAccessToken);
        }
    }

    public static Observable<Payload<ArrayList<Anime>>> getAnimes(
            Context context,
            int limit,
            int page) {
        return getAuthTokenIfAvailable(context)
                .flatMap(token -> APIFactory.instance().getAnimes(token, limit, page));
    }

    public static Observable<Anime> getAnime(Context context, int id) {
        return getAuthTokenIfAvailable(context)
                .flatMap(token -> APIFactory.instance().getAnime(id, token));
    }

    public static Observable<ArrayList<Episode>> getSeasonEpisodes(Context context, int seasonId) {
        return getAuthTokenIfAvailable(context)
                .flatMap(token -> APIFactory.instance().getSeasonEpisodes(seasonId, token));
    }

    public static Observable<ArrayList<Link>> getEpisodeLinks(Context context, int episodeId) {
        return getAuthTokenIfAvailable(context)
                .flatMap(token -> APIFactory.instance().getLinks(episodeId, token));
    }

    public static Observable<DirectLink> getDirectLink(Context context, int linkId) {
        return getAuthTokenIfAvailable(context)
                .flatMap(token -> APIFactory.instance().getDirectLink(linkId, token));
    }

}
