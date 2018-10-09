package app.refactoring.com.refactoringretrofit.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.refactoring.com.refactoringretrofit.R;
import app.refactoring.com.refactoringretrofit.base.BaseActivity;
import app.refactoring.com.refactoringretrofit.util.RxBus;
import butterknife.BindView;
import io.reactivex.Observable;

/**
 * unknown at 2018/8/10
 */

public class RxBusActivity extends BaseActivity {
    public static final String TAG = "RX";
    @BindView(R.id.btn_register)
    Button   mBtnRegister;
    @BindView(R.id.tv_show_rx)
    TextView mTvShowRx;

    Observable<String> mStringObservable;


    @Override
    protected void initView() {
        mStringObservable = RxBus.getInstance().register(TAG);
        findViewById(R.id.btn_register).setOnClickListener(v ->
                startActivity(new Intent(RxBusActivity.this, RxBusTwoActivity.class)));
        mStringObservable.subscribe(str -> mTvShowRx.setText(str));
    }

    @Override
    protected int setLayoutId() {
        return R.layout.rxbus_activity;
    }
}
