package app.refactoring.com.refactoringretrofit.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.refactoring.com.refactoringretrofit.R;
import app.refactoring.com.refactoringretrofit.base.BaseActivity;
import app.refactoring.com.refactoringretrofit.fragment.SplashFragment;
import butterknife.BindView;

/**
 * unknown at 2018/6/14
 */

@SuppressLint("Registered")
public class SplashActivity extends BaseActivity {
    @BindView(R.id.splash_viewpager)
    ViewPager    mViewPager;
    @BindView(R.id.splash_relative)
    LinearLayout mRelativeLayout;
    @BindView(R.id.btn_go)
    Button       mButton;
    private              List<Fragment> mFragmentList = new ArrayList<>();
    private static final String         IMG_BACK[]
                                                      = new String[]{"http://img5.imgtn.bdimg.com/it/u=3385842121,2880011954&fm=27&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=3385842121,2880011954&fm=27&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=3385842121,2880011954&fm=27&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=3385842121,2880011954&fm=27&gp=0.jpg"};

    @Override
    protected void initView() {
        for (int i = 0; i < IMG_BACK.length; i++) {
            ImageView imageView = new ImageView(this);
            mFragmentList.add(SplashFragment.newInstance(IMG_BACK[i]));
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.yuan_two);
            } else {
                imageView.setBackgroundResource(R.drawable.yuan_one);
            }
            mRelativeLayout.addView(imageView);
        }
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        mButton.setOnClickListener(view -> {
            startActivity(new Intent(SplashActivity.this, RxBusActivity.class));
            finish();
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                int childCount = mRelativeLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = mRelativeLayout.getChildAt(i);
                    if (position == i) {
                        childAt.setBackgroundResource(R.drawable.yuan_two);
                    } else {
                        childAt.setBackgroundResource(R.drawable.yuan_one);
                    }
                }
                if (position == IMG_BACK.length - 1) {
                    mButton.setVisibility(View.VISIBLE);
                } else {
                    mButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected int setLayoutId() {
        return R.layout.app_start;
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        ViewPagerAdapter(FragmentManager fm) {
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
