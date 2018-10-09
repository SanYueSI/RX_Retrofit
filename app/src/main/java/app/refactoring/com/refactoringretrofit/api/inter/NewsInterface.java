package app.refactoring.com.refactoringretrofit.api.inter;

import android.app.Activity;

import java.util.Map;

import app.refactoring.com.refactoringretrofit.bean.FoodDataIn;

/**
 * unknown at 2018/6/15
 */

public interface NewsInterface {
    void getNewsDatas(Activity activity, Map<String, String> map);

    void getFoodsDatas(Activity activity,Object activityOrFragment, String key, String menu);
}
