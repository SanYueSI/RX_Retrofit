package app.refactoring.com.refactoringretrofit.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import app.refactoring.com.refactoringretrofit.fragment.NewDataFragment;

/**
 * unknown at 2018/6/15
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private NewDataFragment mNewDataFragment;
    private String[]        titleData;

    public MyPagerAdapter(FragmentManager fm, String[] titleData) {
        super(fm);
        this.titleData = titleData;
    }


    @Override
    public Fragment getItem(int position) {
        mNewDataFragment = NewDataFragment.newInstance(titleData[position]);
        return mNewDataFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleData[position];
    }

    @Override
    public int getCount() {
        return titleData.length;
    }
}
