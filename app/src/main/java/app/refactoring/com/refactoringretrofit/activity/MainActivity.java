package app.refactoring.com.refactoringretrofit.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import app.refactoring.com.refactoringretrofit.R;
import app.refactoring.com.refactoringretrofit.base.BaseActivity;
import app.refactoring.com.refactoringretrofit.fragment.CarTaskFragment;
import app.refactoring.com.refactoringretrofit.fragment.DriverTaskFragment;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements BaseActivity.TitleOnClick {
    private static final int FRAGMENT_CAR    = 0;
    private static final int FRAGMENT_DRIVER = 1;
    @BindView(R.id.frag_layout)
    FrameLayout mFrameLayout;
    private FragmentManager    mFragmentManager;
    private CarTaskFragment    mCarTaskFragment;
    private DriverTaskFragment mDriverTaskFragment;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void initView() {
        setTitleOnClick(this);
        mFragmentManager = getSupportFragmentManager();
        showOrHideFragment(FRAGMENT_CAR);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_task;
    }

    @Override
    public void leftOnClick() {
        showOrHideFragment(FRAGMENT_CAR);
    }

    @Override
    public void rightOnClick() {
        showOrHideFragment(FRAGMENT_DRIVER);
    }

    private void showOrHideFragment(int type) {
        //开启事务
        mFragmentTransaction = mFragmentManager.beginTransaction();
        //显示之前将所有的fragment都隐藏起来,在去显示我们想要显示的fragment
        hideFragment(mFragmentTransaction);
        switch (type) {
            case FRAGMENT_CAR:
                if (mCarTaskFragment == null) {
                    mCarTaskFragment = new CarTaskFragment();
                    //加入事务
                    mFragmentTransaction.add(R.id.frag_layout, mCarTaskFragment);
                } else {
                    mFragmentTransaction.show(mCarTaskFragment);
                }
                break;
            case FRAGMENT_DRIVER:
                if (mDriverTaskFragment == null) {
                    mDriverTaskFragment = new DriverTaskFragment();
                    //加入事务
                    mFragmentTransaction.add(R.id.frag_layout, mDriverTaskFragment);
                } else {
                    mFragmentTransaction.show(mDriverTaskFragment);
                }
                break;
        }
        //提交事务
        mFragmentTransaction.commit();
    }

    /**
     * 隐藏fragment的方法
     *
     * @param fragmentTransaction
     */
    private void hideFragment(FragmentTransaction fragmentTransaction) {
        //如果此fragment不为空的话就隐藏起来
        if (mCarTaskFragment != null) {
            fragmentTransaction.hide(mCarTaskFragment);
        }
        if (mDriverTaskFragment != null) {
            fragmentTransaction.hide(mDriverTaskFragment);
        }
    }
}
