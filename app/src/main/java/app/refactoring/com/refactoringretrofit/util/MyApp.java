package app.refactoring.com.refactoringretrofit.util;

import android.app.Application;
import android.content.Context;


/**
 * Created by edianzu on 2017/4/18.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
