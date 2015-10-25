package com.loop_anime.android.viewmodel;

import android.databinding.DataBindingComponent;

import com.loop_anime.android.viewmodel.adapter.GridLayoutAdapter;
import com.loop_anime.android.viewmodel.adapter.ImageAdapter;
import com.loop_anime.android.viewmodel.adapter.ImageAdapterImpl;
import com.loop_anime.android.viewmodel.adapter.SeasonsGridLayoutAdapterImpl;

/**
 * User: Yilun Chen
 * Date: 15/10/17
 */
public class DataBindingComponentImpl implements DataBindingComponent {

    private static ImageAdapter sImageAdapter = new ImageAdapterImpl();

    private static GridLayoutAdapter sGridAdapter = new SeasonsGridLayoutAdapterImpl();

    @Override
    public GridLayoutAdapter getGridLayoutAdapter() {
        return sGridAdapter;
    }

    public ImageAdapter getImageAdapter() {
        return sImageAdapter;
    }

}
