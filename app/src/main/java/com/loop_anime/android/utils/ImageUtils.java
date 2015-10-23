package com.loop_anime.android.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.loop_anime.android.LoopAnimeAPISettings;

/**
 * User: Yilun Chen
 * Date: 15/10/15
 */
public class ImageUtils {

    public static String getImageURL(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return getThumborImageURL(getOriginalImageURL(url));
    }

    public static String getImageURL(String url, int width, int height) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return getThumborImageURL(getOriginalImageURL(url), width, height);
    }

    public static String getImageURL(String url, int maxSize) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return getThumborImageURL(getOriginalImageURL(url), maxSize);
    }

    public static String getImagePreloadURL(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return getThumborPreloadImageURL(getOriginalImageURL(url));
    }

    @NonNull
    private static String getOriginalImageURL(String url) {
        if (url.startsWith(LoopAnimeAPISettings.IMAGE_BASE_URL)) {
            return url;
        } else {
            return LoopAnimeAPISettings.IMAGE_BASE_URL + url;
        }
    }

    @NonNull
    private static String getThumborImageURL(String url, int width, int height) {
        return LoopAnimeAPISettings.THUMBOR_BASE_URL + "/" + width + "x" + height + "/" + url;
    }

    @NonNull
    private static String getThumborImageURL(String url) {
        return LoopAnimeAPISettings.THUMBOR_BASE_URL + "/" + url;
    }

    @NonNull
    private static String getThumborImageURL(String url, int maxSize) {
        return LoopAnimeAPISettings.THUMBOR_BASE_URL
                + "/full-fit-in/" + maxSize + "x" + maxSize + "/" + url;
    }

    @NonNull
    private static String getThumborPreloadImageURL(String url) {
        return LoopAnimeAPISettings.THUMBOR_BASE_URL
                + "/full-fit-in/" + 300 + "x" + 300
                + "/filters:saturation(0):brightness(60)/" + url;
    }
}
