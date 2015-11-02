package com.loop_anime.android.model.api;

import com.loop_anime.android.model.dao.Anime;
import com.loop_anime.android.model.dao.AuthToken;
import com.loop_anime.android.model.dao.Episode;
import com.loop_anime.android.model.dao.Payload;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * User: Yilun Chen
 * Date: 01/10/15
 */
public interface APIService {

    @GET("/oauth/v2/token")
    Observable<AuthToken> getToken(
            @Query("client_id") String clientId,
            @Query("client_secret") String clientSecret,
            @Query("grant_type") String grantType);

    @GET("/api/v1/animes.json")
    Observable<Payload<ArrayList<Anime>>> getAnimes(
            @Query("access_token") String accessToken,
            @Query("maxr") int limit,
            @Query("page") int page);

    @GET("/api/v1/animes/{anime}.json")
    Observable<Anime> getAnime(
            @Path("anime") int animeId,
            @Query("access_token") String accessToken
    );

    @GET("/api/v1/episodes.json")
    Observable<ArrayList<Episode>> getSeasonEpisodes(
            @Query("season") int seasonId,
            @Query("access_token") String accessToken
    );

    @GET("/api/v1/episodes.json")
    Observable<ArrayList<Episode>> getAnimeEpisodes(
            @Query("anime") int seasonId,
            @Query("access_token") String accessToken
    );
}
