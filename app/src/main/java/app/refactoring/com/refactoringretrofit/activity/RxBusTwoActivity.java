package app.refactoring.com.refactoringretrofit.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import app.refactoring.com.refactoringretrofit.R;
import app.refactoring.com.refactoringretrofit.bean.RxBean;
import app.refactoring.com.refactoringretrofit.util.RxBus;

/**
 * unknown at 2018/8/10
 */

public class RxBusTwoActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxbus_activity);

        String mStrings = "这是rxBus的值";
        RxBus.getInstance().post(RxBusActivity.TAG, mStrings);
    }
}
