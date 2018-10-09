package app.refactoring.com.refactoringretrofit.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

import app.refactoring.com.refactoringretrofit.bean.TitleModel;

/**
 * unknown at 2018/6/15
 */

public class NewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment>         fragmentList;
    private List<TitleModel.Title> mTitleList;

    public NewPagerAdapter(FragmentManager fm,
                           List<Fragment> fragmentList, List<TitleModel.Title> mTitleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.mTitleList = mTitleList;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position).getTitle();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public int getCount() {
        return mTitleList.size();
    }
}
