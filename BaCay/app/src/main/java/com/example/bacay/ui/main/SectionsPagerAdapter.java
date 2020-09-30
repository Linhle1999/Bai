package com.example.bacay.ui.main;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.bacay.R;
import com.example.bacay.fragment.ui.frag_1nguoichoi;
import com.example.bacay.fragment.ui.frag_mayvoimay;
import com.example.bacay.fragment.ui.frag_mayvoinguoi;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        Log.d("TYTYTY", String.valueOf(position));
        switch (position) {
            case 0:
                frag = new frag_1nguoichoi();
                break;
            case 1:
                frag = new frag_mayvoinguoi();
                break;
            case 2:
                frag = new frag_mayvoimay();
                break;
        }
        return frag;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}