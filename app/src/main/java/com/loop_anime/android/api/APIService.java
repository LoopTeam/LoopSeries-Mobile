package com.loop_anime.android.api;

import com.loop_anime.android.model.Anime;
import com.loop_anime.android.model.AuthToken;
import com.loop_anime.android.model.Payload;

import java.util.List;

import retrofit.http.GET;
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
    Observable<Payload<List<Anime>>> getAnimes(
            @Query("access_token") String accessToken,
            @Query("maxr") int limit,
            @Query("page") int page);

}
