package com.loop_anime.android.ui.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.loop_anime.android.R;

/**
 * User: Yilun Chen
 * Date: 15/10/15
 */
@SuppressWarnings("unused")
public class AspectRatioFrameLayout extends FrameLayout {

    private float mAspectRatio = 1;

    public AspectRatioFrameLayout(Context context, float aspectRatio) {
        super(context);
        mAspectRatio = aspectRatio;
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAttributes(context, attrs);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setAttributes(context, attrs);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setAttributes(context, attrs);
    }

    private void setAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AspectRatioFrameLayout);
        try {
            mAspectRatio = a.getFloat(R.styleable.AspectRatioFrameLayout_aspect_ratio, 1);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int originalWidth = MeasureSpec.getSize(widthMeasureSpec);
        int desiredHeight = (int) (originalWidth * mAspectRatio);
        super.onMeasure(
                MeasureSpec.makeMeasureSpec(originalWidth, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(desiredHeight, MeasureSpec.EXACTLY)
        );
    }
}
