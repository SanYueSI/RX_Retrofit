package app.refactoring.com.refactoringretrofit.api.imp;

import android.app.Activity;

import java.util.Map;

import app.refactoring.com.refactoringretrofit.api.inter.NewsInterface;
import app.refactoring.com.refactoringretrofit.api.ApiService;
import app.refactoring.com.refactoringretrofit.base.BaseObserver;
import app.refactoring.com.refactoringretrofit.bean.FoodDataOut;
import app.refactoring.com.refactoringretrofit.fragment.NewDataFragment;
import app.refactoring.com.refactoringretrofit.net.HttpUtils;

/**
 * unknown at 2018/6/15
 */

public class NewInterfaceImp implements NewsInterface {
    @Override
    public void getNewsDatas(Activity activity, Map<String, String> map) {
    }

    @Override
    public void getFoodsDatas(Activity activity, Object activityOrFragment, String key, String menu) {
        HttpUtils.getApiService(ApiService.class)
                .getFoodDatas(key, menu)
                .compose(HttpUtils.applySchedulers())
                .subscribe(new BaseObserver<FoodDataOut>(activity) {
                    @Override
                    protected void success(FoodDataOut foodDataOut) {
                        ((NewDataFragment) activityOrFragment).requestSuccess(foodDataOut);
                    }
                });
    }

}
