package com.loop_anime.android.model.api;

import com.facebook.stetho.okhttp.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loop_anime.android.LoopAnimeAPISettings;
import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * User: Yilun Chen
 * Date: 01/10/15
 */
public class APIFactory {

    private static APIService sAPIServiceInstance;

    public static APIService instance() {
        synchronized (APIFactory.class) {
            if (sAPIServiceInstance == null) {
                Gson gson = new GsonBuilder()
                        .create();
                OkHttpClient client = new OkHttpClient();
                client.networkInterceptors().add(new StethoInterceptor());
                /**
                 * please see http://git.io/vcure to setup your own server
                 * or PM @joshlopes to ask for our domain/clientId/secret
                 */
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(LoopAnimeAPISettings.BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
                sAPIServiceInstance = retrofit.create(APIService.class);
            }
        }
        return sAPIServiceInstance;
    }


}
