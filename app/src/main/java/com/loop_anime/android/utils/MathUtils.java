package com.loop_anime.android.utils;

/**
 * User: Yilun Chen
 * Date: 15/10/15
 */
@SuppressWarnings("unused")
public class MathUtils {

    public static int constrains(int input, int a, int b) {
        int result = input;
        final int min = Math.min(a, b);
        final int max = Math.max(a, b);
        result = result > min ? result : min;
        result = result < max ? result : max;
        return result;
    }

    public static float constrains(float input, float a, float b) {
        float result = input;
        final float min = Math.min(a, b);
        final float max = Math.max(a, b);
        result = result > min ? result : min;
        result = result < max ? result : max;
        return result;
    }

    public static boolean approximatelyEquals(float input, float target, float tolerance) {
        tolerance = Math.abs(tolerance);
        return input <= target + tolerance && input >= target - tolerance;
    }

    public static boolean approximatelyEquals(int input, int target, int tolerance) {
        tolerance = Math.abs(tolerance);
        return input <= target + tolerance && input >= target - tolerance;
    }

    public static boolean approximatelyEquals(long input, long target, long tolerance) {
        tolerance = Math.abs(tolerance);
        return input <= target + tolerance && input >= target - tolerance;
    }
}
