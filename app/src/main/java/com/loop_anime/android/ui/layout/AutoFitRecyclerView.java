package com.loop_anime.android.ui.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.loop_anime.android.utils.MathUtils;

/**
 * User: Yilun Chen
 * Date: 15/10/15
 */
@SuppressWarnings("unused")
public class AutoFitRecyclerView extends RecyclerView {

    private int columnWidth;

    private GridLayoutManager manager;

    private int mSpanCount = 1;

    private boolean hasHeader = false;

    private GridLayoutManager.SpanSizeLookup gridLayoutManager;

    private int maxColumnCount;

    public AutoFitRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AutoFitRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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

        manager = new GridLayoutManager(getContext(), 1);
        setLayoutManager(manager);
        this.gridLayoutManager = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return mSpanCount;
                }
                return 1;
            }
        };
    }

    public int getSpanCount() {
        return mSpanCount;
    }

    public void setHasHeader(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (columnWidth > 0) {
            mSpanCount = MathUtils.constrains(getMeasuredWidth() / columnWidth, 1, maxColumnCount);
            manager.setSpanCount(mSpanCount);
        }
        if (hasHeader) {
            manager.setSpanSizeLookup(gridLayoutManager);
        }
    }
}
