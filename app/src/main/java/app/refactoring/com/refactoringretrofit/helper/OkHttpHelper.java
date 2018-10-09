package app.refactoring.com.refactoringretrofit.helper;

import java.util.concurrent.TimeUnit;

import app.refactoring.com.refactoringretrofit.util.Config;
import okhttp3.OkHttpClient;

/**
 * unknown at 2018/6/26
 */

public class OkHttpHelper {
    private static class OkHttpInit {
        private static final OkHttpHelper OK_HTTP_HELPER = new OkHttpHelper();
    }

    static OkHttpHelper getInstance() {
        return OkHttpInit.OK_HTTP_HELPER;
    }

    OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(Config.TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(Config.TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(Config.TIME_OUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                // TODO: 2018/6/26 添加header头
                //                .addInterceptor(chain -> chain.proceed(chain.request()
                //                        .newBuilder()
                //                        .addHeader("", "")
                //                        .build()))
                .build();
    }
}
