package app.refactoring.com.refactoringretrofit.api;

import java.util.Map;

import app.refactoring.com.refactoringretrofit.bean.BaseEntity;
import app.refactoring.com.refactoringretrofit.bean.FoodDataIn;
import app.refactoring.com.refactoringretrofit.bean.FoodDataOut;
import app.refactoring.com.refactoringretrofit.bean.NewDataOut;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * unknown at 2018/6/14
 */

public interface ApiService {
    @GET("toutiao/index?")
    Observable<NewDataOut> getJuheDatas(@QueryMap Map<String, String> map);

    @GET("cook/query?")
    Observable<FoodDataOut> getFoodDatas(@Query("key") String key, @Query("menu") String menu);
}
