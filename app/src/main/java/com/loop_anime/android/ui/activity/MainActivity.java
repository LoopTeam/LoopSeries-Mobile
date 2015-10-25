package com.loop_anime.android.ui.activity;

import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import com.loop_anime.android.R;
import com.loop_anime.android.databinding.ActivityMainBinding;
import com.loop_anime.android.ui.fragment.AnimesFragment;
import com.loop_anime.android.viewmodel.DataBindingComponentImpl;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        FragmentManager.OnBackStackChangedListener {

    private ActivityMainBinding mBinding;

    public ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main,
                new DataBindingComponentImpl());

        setSupportActionBar(mBinding.toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this, mBinding.drawerLayout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mBinding.navView.setNavigationItemSelectedListener(this);
        mDrawerToggle.syncState();

        getSupportFragmentManager().addOnBackStackChangedListener(this);
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.fragment_pop_enter, 0)
                .add(R.id.container_fragment, new AnimesFragment())
                .commit();
    }

    public void launchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.fragment_enter,
                        R.anim.fragment_exit,
                        R.anim.fragment_pop_enter,
                        R.anim.fragment_pop_exit)
                .replace(R.id.container_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        mBinding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackStackChanged() {
        FragmentManager fm = getSupportFragmentManager();
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        if (fm.getBackStackEntryCount() == 0) {
            valueAnimator.addUpdateListener(
                    animation -> mDrawerToggle.onDrawerSlide(null, 1 - animation.getAnimatedFraction())
            );
        } else {
            valueAnimator.addUpdateListener(
                    animation -> mDrawerToggle.onDrawerSlide(null, animation.getAnimatedFraction())
            );
        }
        valueAnimator.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                    mBinding.drawerLayout.openDrawer(GravityCompat.START);
                } else {
                    getSupportFragmentManager().popBackStack();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
