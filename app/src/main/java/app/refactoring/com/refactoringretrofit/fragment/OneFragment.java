package app.refactoring.com.refactoringretrofit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.refactoring.com.refactoringretrofit.R;
import app.refactoring.com.refactoringretrofit.adapter.NewPagerAdapter;
import app.refactoring.com.refactoringretrofit.bean.TitleModel;
import app.refactoring.com.refactoringretrofit.util.Utils;

/**
 * unknown at 2018/6/28
 */

public class OneFragment extends Fragment {
    private TabLayout              mTabLayout;
    private ViewPager              mViewPager;
    private List<TitleModel.Title> mTitleList;
    private List<Fragment>         mFragmentList;
    private NewPagerAdapter        mNewPagerAdapter;

    public static OneFragment newInstance() {
        OneFragment fragment = new OneFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_layout, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        mTabLayout = getView().findViewById(R.id.tablayout);
        mViewPager = getView().findViewById(R.id.view_pager);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mViewPager.setCurrentItem(5);
    }


    private void initData() {
        mTitleList = new ArrayList<>();
        mFragmentList = new ArrayList<>();
        mTitleList = Utils.getTitles().getTitleList();

        for (int i = 0; i < mTitleList.size(); i++) {
            mFragmentList.add(NewDataFragment.newInstance(mTitleList.get(i).getTitle()));
        }

        mNewPagerAdapter = new NewPagerAdapter(getFragmentManager(), mFragmentList, mTitleList);

        mViewPager.setAdapter(mNewPagerAdapter);
    }
}
