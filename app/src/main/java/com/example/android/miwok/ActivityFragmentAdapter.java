package com.example.android.miwok;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by richard on 3/14/17.
 */

public class ActivityFragmentAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public ActivityFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        ActivityFragment fragment = new ActivityFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 1:
                return mContext.getString(R.string.category_family);
            case 2:
                return mContext.getString(R.string.category_colors);
            case 3:
                return mContext.getString(R.string.category_phrases);
            default:
                return mContext.getString(R.string.category_numbers);
        }

    }
}
