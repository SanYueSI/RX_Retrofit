package app.refactoring.com.refactoringretrofit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.refactoring.com.refactoringretrofit.R;
import app.refactoring.com.refactoringretrofit.adapter.MyPagerAdapter;
import app.refactoring.com.refactoringretrofit.base.BaseFragment;

/**
 * unknown at 2018/6/28
 */

public class CarTaskFragment extends BaseFragment {
    private static final String[] TITLE_DATA = new String[]{"土豆", "牛肉", "西红柿", "青菜", "胡萝卜"};
    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_task, null);
        mTabLayout = mView.findViewById(R.id.tablayout);
        mViewPager = mView.findViewById(R.id.viewpager);
        return mView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTabTitle();
    }

    private void setTabTitle() {
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.addTab(mTabLayout.newTab().setText("土豆"), 0);
        for (String str : TITLE_DATA) {
            mTabLayout.addTab(mTabLayout.newTab().setText(str), 1);
        }
        mViewPager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager(),
                TITLE_DATA));
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
