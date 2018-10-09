package app.refactoring.com.refactoringretrofit.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.Toast;

import javax.security.auth.login.LoginException;

import app.refactoring.com.refactoringretrofit.R;
import app.refactoring.com.refactoringretrofit.base.BaseActivity;
import app.refactoring.com.refactoringretrofit.fragment.FrourFragment;
import app.refactoring.com.refactoringretrofit.fragment.OneFragment;
import app.refactoring.com.refactoringretrofit.fragment.ThreeFragment;
import app.refactoring.com.refactoringretrofit.fragment.TwoFragment;
import app.refactoring.com.refactoringretrofit.helper.BottomNavigationViewHelper;
import butterknife.BindView;

/**
 * unknown at 2018/7/25
 */

public class TitleChangeActivity extends BaseActivity {
    private static final int FRAGMENT_NEWS  = 0;
    private static final int FRAGMENT_PHOTO = 1;
    private static final int FRAGMENT_VIDEO = 2;
    private static final int FRAGMENT_MEDIA = 3;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.frame_layout)
    FrameLayout          mFrameLayout;
    private OneFragment   mOneFragment;
    private TwoFragment   mTwoFragment;
    private ThreeFragment mThreeFragment;
    private FrourFragment mFrourFragment;
    private long exitTime = 0;

    @Override
    protected void initView() {
        //        titleList = Utils.getTitles().getTitleList();
        //        for (TitleModel.Title title : titleList) {
        //            mTabLayout.addTab(mTabLayout.newTab().setText(title.getTitle()));
        //        }
        //
        //        mImageView.setOnClickListener(v -> showDialog());
        showFragment(FRAGMENT_NEWS);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener((MenuItem item) -> {
            switch (item.getItemId()) {
                case R.id.action_news:
                    showFragment(FRAGMENT_NEWS);
                    break;
                case R.id.action_photo:
                    showFragment(FRAGMENT_PHOTO);
                    break;
                case R.id.action_video:
                    showFragment(FRAGMENT_VIDEO);
                    break;
                case R.id.action_media:
                    showFragment(FRAGMENT_MEDIA);
                    break;
            }
            return true;
        });
    }

    private void showFragment(int index) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);
        switch (index) {
            case FRAGMENT_NEWS:
                if (mOneFragment == null) {
                    mOneFragment = OneFragment.newInstance();
                    fragmentTransaction.add(R.id.frame_layout, mOneFragment);
                } else {
                    fragmentTransaction.show(mOneFragment);
                }
                break;
            case FRAGMENT_PHOTO:
                if (mTwoFragment == null) {
                    mTwoFragment = TwoFragment.newInstance();
                    fragmentTransaction.add(R.id.frame_layout, mTwoFragment);
                } else {
                    fragmentTransaction.show(mTwoFragment);
                }
                break;
            case FRAGMENT_VIDEO:
                if (mThreeFragment == null) {
                    mThreeFragment = ThreeFragment.newInstance();
                    fragmentTransaction.add(R.id.frame_layout, mThreeFragment);
                } else {
                    fragmentTransaction.show(mThreeFragment);
                }
                break;
            case FRAGMENT_MEDIA:
                if (mFrourFragment == null) {
                    mFrourFragment = FrourFragment.newInstance();
                    fragmentTransaction.add(R.id.frame_layout, mFrourFragment);
                } else {
                    fragmentTransaction.show(mFrourFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction ft) {
        // 如果不为空，就先隐藏起来
        if (mOneFragment != null) {
            ft.hide(mOneFragment);
        }
        if (mTwoFragment != null) {
            ft.hide(mTwoFragment);
        }
        if (mThreeFragment != null) {
            ft.hide(mThreeFragment);
        }
        if (mFrourFragment != null) {
            ft.hide(mFrourFragment);
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_change_title;
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.dialog_item, null);
        Button button = v.findViewById(R.id.btn_q);
        GridView gridView = v.findViewById(R.id.grid_dialog);
        //builer.setView(v);//这里如果使用builer.setView(v)，自定义布局只会覆盖title和button之间的那部分
        final Dialog dialog = builder.create();
        dialog.show();
        android.view.WindowManager.LayoutParams p = dialog.getWindow().getAttributes();  //获取对话框当前的参数值
        p.height = 800;   //高度设置为屏幕的0.3
        dialog.getWindow().setAttributes(p);     //设置生效
        dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后面
        //        dialog.getWindow().setGravity(Gravity.BOTTOM);//可以设置显示的位置
        //        DialogAdapter dialogAdapter = news DialogAdapter();
        //        gridView.setAdapter(dialogAdapter);

        //        gridView.setOnItemClickListener((parent, view, position, id) -> {
        //            if (titleList.get(position).isShow()) {
        //                titleList.get(position).setShow(false);
        //            } else {
        //                titleList.get(position).setShow(true);
        //            }
        //            dialogAdapter.notifyDataSetChanged();
        //        });
        //        button.setOnClickListener(v1 -> {
        //            titleList1 = news ArrayList<>();
        //            for (int i = 0; i < titleList.size(); i++) {
        //                if (titleList.get(i).isShow()) {
        //                    titleList1.add(titleList.get(i).getTitle());
        //                }
        //            }
        //            if (titleList1.size() == titleList.size()) {
        //                for (int i = 0; i < titleList1.size(); i++) {
        //                    titleList.get(i).setShow(false);
        //                    dialogAdapter.notifyDataSetChanged();
        //                }
        //            } else {
        //                mTabLayout.removeAllTabs();
        //                for (int i = 0; i < titleList.size(); i++) {
        //                    if (!titleList.get(i).isShow()) {
        //                        mTabLayout.addTab(mTabLayout.newTab()
        //                                .setText(titleList.get(i).getTitle()));
        //                    }
        //                }
        //                dialog.dismiss();
        //            }
        //        });
    }

    //    class DialogAdapter extends BaseAdapter {
    //
    //        @Override
    //        public int getCount() {
    //            return titleList.size();
    //        }
    //
    //        @Override
    //        public Object getItem(int position) {
    //            return titleList.get(position);
    //        }
    //
    //        @Override
    //        public long getItemId(int position) {
    //            return position;
    //        }
    //
    //        @Override
    //        public View getView(int position, View convertView, ViewGroup parent) {
    //            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.title_item, null);
    //            TextView textView = convertView.findViewById(R.id.tv_title);
    //            textView.setText(titleList.get(position).getTitle());
    //            if (titleList.get(position).isShow()) {
    //                textView.setBackgroundResource(R.drawable.shap);
    //            } else {
    //                textView.setBackgroundResource(R.drawable.shap1);
    //            }
    //            return convertView;
    //        }
    //    }


    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - exitTime) < 2000) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_LONG).show();
            exitTime = currentTime;
        }
    }
}
