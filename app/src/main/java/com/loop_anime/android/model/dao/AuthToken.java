package com.loop_anime.android.model.dao;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * User: Yilun Chen
 * Date: 01/10/15
 */
@SuppressWarnings("unused")
public class AuthToken implements Serializable {

    private static final String PREFERENCES_TOKEN = "PREFERENCES_TOKEN";

    private static final String PREF_TOKEN = "PREF_TOKEN";

    private static final String PREF_EXPIRE = "PREF_EXPIRE";

    /**
     * access_token : MTU3Y2MxOWQ5OTVlMTg3NGIyMTk2Yzc0Y2M3ZjUyZjRlOGIzOWUzMDcyY2EyMGI1YzQwNjlmYTczOWIwM2Q5ZA
     * expires_in : 3600
     * token_type : bearer
     * scope : user
     */

    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("expires_in")
    private int expiresIn;
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("scope")
    private String scope;

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getScope() {
        return scope;
    }

    public void save(Context context) {
        getTokenSharedPreferences(context).edit()
                .putString(PREF_TOKEN, accessToken)
                .putLong(PREF_EXPIRE, System.currentTimeMillis() / 1000 + expiresIn)
                .apply();
    }

    private static SharedPreferences getTokenSharedPreferences(Context context) {
        return context.getSharedPreferences(
                context.getApplicationContext().getPackageName() + "." + PREFERENCES_TOKEN,
                Context.MODE_PRIVATE);
    }

    public static AuthToken getToken(Context context) {
        AuthToken authToken = new AuthToken();
        String token = getTokenSharedPreferences(context).getString(PREF_TOKEN, null);
        if (TextUtils.isEmpty(token)) {
            return null;
        }
        authToken.setAccessToken(token);
        return authToken;
    }

    public static boolean isExpired(Context context) {
        SharedPreferences pref = getTokenSharedPreferences(context);
        return !(pref.getLong(PREF_EXPIRE, -1l) >= System.currentTimeMillis() / 1000)
                || TextUtils.isEmpty(pref.getString(PREF_TOKEN, null));
    }

}
