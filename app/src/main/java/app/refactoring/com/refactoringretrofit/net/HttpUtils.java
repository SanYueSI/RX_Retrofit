package app.refactoring.com.refactoringretrofit.net;

import app.refactoring.com.refactoringretrofit.helper.RetrofitHelper;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * unknown at 2018/6/25
 */

public class HttpUtils {
    public static <T> T getApiService(Class<T> cls) {
        return RetrofitHelper.getInstance().createService(cls);
    }


    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
