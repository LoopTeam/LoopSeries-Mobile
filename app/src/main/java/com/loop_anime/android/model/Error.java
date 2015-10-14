package com.loop_anime.android.model;

import com.google.gson.annotations.SerializedName;

/**
 * User: Yilun Chen
 * Date: 15/10/14
 */
public class Error {

    /**
     * error : invalid_grant
     * error_description : The access token provided is invalid.
     */

    @SerializedName("error")
    private String error;

    @SerializedName("error_description")
    private String errorDescription;

    public void setError(String error) {
        this.error = error;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getError() {
        return error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
