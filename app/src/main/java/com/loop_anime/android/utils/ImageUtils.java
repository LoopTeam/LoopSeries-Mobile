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
        return new ThumborURLBuilder().baseURL(LoopAnimeAPISettings.THUMBOR_BASE_URL)
                .imageURL(url)
                .fit(width, height)
                .build();
    }

    @NonNull
    private static String getThumborImageURL(String url) {
        return new ThumborURLBuilder().baseURL(LoopAnimeAPISettings.THUMBOR_BASE_URL)
                .imageURL(url)
                .build();
    }

    @NonNull
    private static String getThumborImageURL(String url, int maxSize) {
        return new ThumborURLBuilder().baseURL(LoopAnimeAPISettings.THUMBOR_BASE_URL)
                .imageURL(url)
                .maxSize(maxSize)
                .build();
    }

    @NonNull
    private static String getThumborPreloadImageURL(String url) {
        return new ThumborURLBuilder().baseURL(LoopAnimeAPISettings.THUMBOR_BASE_URL)
                .imageURL(url)
                .fit(300, 300)
                .thumbnail()
                .build();
    }

    @SuppressWarnings("unused")
    public static class ThumborURLBuilder {

        private static final int DEFAULT_MAX_SIZE = 640;

        private String mBaseURL;

        private String mImageURL;

        private int mWidth = -1;

        private int mHeight = -1;

        private boolean isMaterialThumbnailImage = false;

        public ThumborURLBuilder() {
        }

        public ThumborURLBuilder baseURL(String baseURL) {
            mBaseURL = baseURL;
            return this;
        }

        public ThumborURLBuilder maxSize(int maxSize) {
            mHeight = maxSize;
            mWidth = maxSize;
            return this;
        }

        public ThumborURLBuilder fit() {
            mWidth = DEFAULT_MAX_SIZE;
            mHeight = DEFAULT_MAX_SIZE;
            return this;
        }

        public ThumborURLBuilder fit(int width, int height) {
            mHeight = height;
            mWidth = width;
            return this;
        }

        public ThumborURLBuilder thumbnail() {
            isMaterialThumbnailImage = true;
            return this;
        }

        public ThumborURLBuilder imageURL(String imageURL) {
            mImageURL = imageURL;
            return this;
        }

        public String build() {
            StringBuilder builder = new StringBuilder();
            if (TextUtils.isEmpty(mBaseURL.trim()) || TextUtils.isEmpty(mImageURL.trim())) {
                throw new RuntimeException("You must provide BaseURL");
            }
            builder.append(mBaseURL.trim());
            if (mHeight > 0 && mWidth > 0) {
                builder.append("/full-fit-in/").append(mWidth).append("x").append(mHeight);
            }
            if (isMaterialThumbnailImage) {
                builder.append("/filters:saturation(0):brightness(60)");
            }
            builder.append("/").append(mImageURL.trim());
            return builder.toString();
        }
    }
}
