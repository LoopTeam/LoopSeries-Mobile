package com.loop_anime.android.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * User: Yilun Chen
 * Date: 15/10/14
 */
public class Payload<T> implements Serializable {

    @SerializedName("payload")
    private T payload;

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
