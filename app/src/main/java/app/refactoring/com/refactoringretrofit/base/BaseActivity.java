package app.refactoring.com.refactoringretrofit.base;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.UiThread;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import app.refactoring.com.refactoringretrofit.R;
import app.refactoring.com.refactoringretrofit.util.ViewUtil;
import app.refactoring.com.refactoringretrofit.widget.MyDiglog;
import butterknife.ButterKnife;

/**
 * unknown at 2018/6/13
 */

public abstract class BaseActivity extends AppCompatActivity {
    /*左边返回箭头*/
    private ImageView mImageBack;
    /*左边图标*/
    private ImageView mImageLeft;
    /*左边文字*/
    private TextView  mTitleTvLeft;
    /*中间标题*/
    private TextView  mTitleTvCenter;
    /*右边图标*/
    private ImageView mTitleImgRight;
    /*右边文字*/
    private TextView  mTitleTvRight;
    private Toast     mToast;
    private Dialog    progressDlg;
    private TextView  tvCar;
    private TextView  tvDriver;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        String simpleName = getClass().getSimpleName();
        if (simpleName.equals("SplashActivity")) {
            ViewUtil.initSystemBar(this, Color.TRANSPARENT);
        } else {
            ViewUtil.initSystemBar(this, R.color.colorPrimary);
            setActionBarLayout();
        }
        initView();
    }

    @SuppressLint("ShowToast")
    public void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    /**
     * 显示左边带返回图标 中间标题 右边图标
     */
    public void showLeftBackRightImgAndTitle(String title, int rightIcon) {
        showLeft();
        mTitleTvCenter.setVisibility(View.VISIBLE);
        mTitleTvCenter.setText(title);
        mTitleImgRight.setVisibility(View.VISIBLE);
        mTitleImgRight.setImageResource(rightIcon);
    }

    /**
     * 显示左边内容
     */
    private void showLeft() {
        mImageBack.setVisibility(View.VISIBLE);
        mTitleTvLeft.setVisibility(View.VISIBLE);
        mTitleTvLeft.setText(R.string.title_back);
    }

    /**
     * 显示左边文字 右边文字 中间标题
     */
    public void showLeftTvRightTvAndTitle(String leftStr, String rightStr, String title) {
    }

    /**
     * 显示左边图标 右边图标 中间标题
     */
    public void showLeftImgRightImgAndTitle(int leftIcon, int rightIcon, String title) {
    }

    /**
     * 显示左边带返回 右边图标 不显示中间标题
     */
    public void showLeftBackAndRightImg(int rightIcon) {
    }

    /**
     * 只显示中间标题
     *
     * @param title
     */
    public void showTtile(String title) {
        hideOther();
        mTitleTvCenter.setVisibility(View.VISIBLE);
        mTitleTvCenter.setText(title);

    }

    private void hideOther() {
        mImageBack.setVisibility(View.GONE);
        mImageLeft.setVisibility(View.GONE);
        mTitleTvLeft.setVisibility(View.GONE);
        mTitleImgRight.setVisibility(View.GONE);
        mTitleTvRight.setVisibility(View.GONE);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("InflateParams,RtlHardcoded")
    private void setActionBarLayout() {
        View mTileView = getLayoutInflater().inflate(R.layout.activity_title, null);
        mImageBack = mTileView.findViewById(R.id.title_backImg_left);
        mImageLeft = mTileView.findViewById(R.id.title_img_left);
        mTitleTvLeft = mTileView.findViewById(R.id.title_tv_left);
        mTitleTvCenter = mTileView.findViewById(R.id.title_tv_center);
        mTitleImgRight = mTileView.findViewById(R.id.title_img_right);
        mTitleTvRight = mTileView.findViewById(R.id.title_tv_right);
        tvCar = mTileView.findViewById(R.id.tv_car);
        tvDriver = mTileView.findViewById(R.id.tv_driver);

        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT, Gravity.LEFT);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(mTileView, params);
        }
        tvCar.setOnClickListener(view -> {
            isOne = true;
            isTwo = false;
            setBackGround();
            mTitleOnClick.leftOnClick();
        });

        tvDriver.setOnClickListener(view -> {
            isTwo = true;
            isOne = false;
            setBackGround();
            mTitleOnClick.rightOnClick();
        });


    }

    private boolean isOne, isTwo;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setBackGround() {
        if (isOne) {
            tvCar.setBackground(getDrawable(R.drawable.draw_lin_one));
            tvCar.setTextColor(Color.parseColor("#3F51B5"));
        } else {
            tvCar.setBackground(getDrawable(R.drawable.draw_lin_three));
            tvCar.setTextColor(Color.parseColor("#d6d6d6"));
        }

        if (isTwo) {
            tvDriver.setBackground(getDrawable(R.drawable.draw_lin_two));
            tvDriver.setTextColor(Color.parseColor("#3F51B5"));
        } else {
            tvDriver.setBackground(getDrawable(R.drawable.draw_lin_four));
            tvDriver.setTextColor(Color.parseColor("#d6d6d6"));
        }
    }


    /**
     * 初始化
     */
    protected abstract void initView();

    /**
     * 获取布局
     */
    protected abstract int setLayoutId();

    /**
     * 显示loading
     *
     * @param msg 自定义消息
     */
    public void showProgress(String msg) {
        if (!BaseActivity.this.isFinishing()) {
            progressDlg = MyDiglog.createLoadingDialog(BaseActivity.this, msg, false);
        }
    }

    /**
     * 隐藏loading
     */
    @UiThread
    public void hideProgress() {
        if (!BaseActivity.this.isFinishing()) {
            if (progressDlg != null && progressDlg.isShowing()) {
                progressDlg.dismiss();
            }
        }
    }

    private TitleOnClick mTitleOnClick;

    public void setTitleOnClick(TitleOnClick titleOnClick) {
        mTitleOnClick = titleOnClick;
    }

    public interface TitleOnClick {
        void leftOnClick();

        void rightOnClick();
    }
}
