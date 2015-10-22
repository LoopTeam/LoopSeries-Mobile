package com.loop_anime.android.viewmodel.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.databinding.DataBindingComponent;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.widget.GridLayout;
import android.widget.TextView;

import com.loop_anime.android.R;

import java.util.List;

/**
 * User: Yilun Chen
 * Date: 15/10/22
 */
public class GridLayoutAdapterImpl implements GridLayoutAdapter {

    @SuppressLint("SetTextI18n")
    @Override
    public void setGrid(DataBindingComponent component,
                        GridLayout gridLayout,
                        @Nullable List<Integer> ids) {
        if (ids != null && ids.size() > 0) {
            for (int i = 0; i < ids.size(); i++) {
                Context context = gridLayout.getContext();
                TextView textView = (TextView) LayoutInflater.from(context)
                        .inflate(R.layout.view_item_season, gridLayout, false);
                textView.setText("" + (i + 1));
                gridLayout.addView(textView);
            }
        }
    }

}
