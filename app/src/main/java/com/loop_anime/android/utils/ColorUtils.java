package com.loop_anime.android.utils;

import android.content.Context;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.M;

/**
 * User: Yilun Chen
 * Date: 01/10/2015
 */
public class ColorUtils {

    public static int getColor(Context context, int colorResId) {
        int color;
        if (SDK_INT >= M) {
            color = context.getColor(colorResId);
        } else {
            //noinspection deprecation
            color = context.getResources().getColor(colorResId);
        }
        return color;
    }
}
