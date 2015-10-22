package com.loop_anime.android.viewmodel.adapter;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingComponent;
import android.support.annotation.Nullable;
import android.widget.GridLayout;

import java.util.List;

/**
 * User: Yilun Chen
 * Date: 15/10/22
 */
public interface GridLayoutAdapter {

    @BindingAdapter("grid")
    void setGrid(DataBindingComponent component, GridLayout gridLayout, @Nullable List<Integer> ids);

}
