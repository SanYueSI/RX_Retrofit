package app.refactoring.com.refactoringretrofit.helper;

import app.refactoring.com.refactoringretrofit.util.Config;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * unknown at 2018/6/14
 */

public class RetrofitHelper {

    private static class InitRetrofit {
        private static final RetrofitHelper INSTANCE = new RetrofitHelper();
    }

    public static RetrofitHelper getInstance() {
        return InitRetrofit.INSTANCE;
    }

    private Retrofit apiService() {
        return new Retrofit.Builder().baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpHelper.getInstance().okHttpClient())
                .build();
    }

    public <T> T createService(Class<T> tClass) {
        return apiService().create(tClass);
    }
}
