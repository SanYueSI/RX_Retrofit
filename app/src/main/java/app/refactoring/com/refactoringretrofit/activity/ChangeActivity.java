package app.refactoring.com.refactoringretrofit.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import app.refactoring.com.refactoringretrofit.R;
import app.refactoring.com.refactoringretrofit.base.BaseActivity;
import app.refactoring.com.refactoringretrofit.fragment.ChangeFragment;
import butterknife.BindView;

/**
 * unknown at 2018/7/24
 */

public class ChangeActivity extends BaseActivity implements ChangeFragment.OnItemClick {
    private static final String TAG = "ChangeActivity";
    @BindView(R.id.change_pager)
    ViewPager mViewPager;
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void initView() {
        ChangeFragment.setmOnItemClick(this);
        addFragment(0);
        MyPageAdater myPageAdater = new MyPageAdater(getSupportFragmentManager());
        mViewPager.setAdapter(myPageAdater);
    }

    private void addFragment(int position) {
        ChangeFragment changeFragment = ChangeFragment.newInstance(position);
        mFragmentList.add(changeFragment);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_change;
    }

    @Override
    public void itemClick(int position) {
        addFragment(position + 1);
    }


    class MyPageAdater extends FragmentPagerAdapter {

        public MyPageAdater(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
