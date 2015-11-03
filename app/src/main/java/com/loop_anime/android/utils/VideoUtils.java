package com.loop_anime.android.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * User: Yilun Chen
 * Date: 15/11/3
 */
public class VideoUtils {

    private VideoUtils() {
        throw new AssertionError();
    }

    public static void launchVideoURLWithExternalPlayer(@NonNull Context context, @Nullable String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(url), "video/*");
        context.startActivity(intent);
    }

}
