package com.loop_anime.android.utils;

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
        if (url.startsWith(LoopAnimeAPISettings.IMAGE_BASE_URL)) {
            return url;
        } else {
            return LoopAnimeAPISettings.IMAGE_BASE_URL + url;
        }
    }
}
