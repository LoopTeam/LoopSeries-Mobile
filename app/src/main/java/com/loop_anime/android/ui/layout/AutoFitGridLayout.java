package com.loop_anime.android.ui.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;

import com.loop_anime.android.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Yilun Chen
 * Date: 15/10/25
 */
@SuppressWarnings("unused")
public class AutoFitGridLayout extends GridLayout {

    private int columnWidth = -1;

    private int maxColumnCount;

    private int mColumnCount = 1;

    private List<View> childs = new ArrayList<>();

    public AutoFitGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AutoFitGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public AutoFitGridLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] attrsArray = {
                    android.R.attr.columnWidth,
                    android.R.attr.columnCount
            };
            TypedArray array = context.obtainStyledAttributes(
                    attrs, attrsArray);
            columnWidth = array.getDimensionPixelSize(0, -1);
            maxColumnCount = array.getInt(1, 999);
            array.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (columnWidth > 0) {
            mColumnCount = MathUtils.constrains(getMeasuredWidth() / columnWidth, 1, maxColumnCount);
            childs.clear();
            for (int i = 0; i < getChildCount(); i++) {
                childs.add(getChildAt(i));
            }
            removeAllViews();
            setColumnCount(mColumnCount);
            //noinspection Convert2streamapi
            for (View view : childs) {
                addView(view);
            }
        }
    }

    @Override
    public void addView(View child) {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.width = (getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) / mColumnCount;
        layoutParams.height = LayoutParams.WRAP_CONTENT;
        super.addView(child, layoutParams);
    }
}
