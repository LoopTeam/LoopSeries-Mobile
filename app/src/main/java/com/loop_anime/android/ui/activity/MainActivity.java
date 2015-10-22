package com.loop_anime.android.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.loop_anime.android.R;
import com.loop_anime.android.databinding.ActivityMainBinding;
import com.loop_anime.android.ui.fragment.AnimesFragment;
import com.loop_anime.android.viewmodel.DataBindingComponentImpl;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main,
                new DataBindingComponentImpl());
        launchFragment(new AnimesFragment());
        setSupportActionBar(mBinding.toolbar);
    }

    public void launchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}
