package com.loop_anime.android.viewmodel;

import android.databinding.DataBindingComponent;

/**
 * User: Yilun Chen
 * Date: 15/10/17
 */
public class DataBindingComponentImpl implements DataBindingComponent {

    private static ImageAdapter mImageAdapter = new ImageAdapterImpl();

    public ImageAdapter getImageAdapter() {
        return mImageAdapter;
    }

}
