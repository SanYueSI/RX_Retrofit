package app.refactoring.com.refactoringretrofit.base;

import android.accounts.NetworkErrorException;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import app.refactoring.com.refactoringretrofit.bean.BaseEntity;
import app.refactoring.com.refactoringretrofit.bean.FoodDataOut;
import app.refactoring.com.refactoringretrofit.util.ToastUtils;
import app.refactoring.com.refactoringretrofit.util.Utils;
import app.refactoring.com.refactoringretrofit.widget.MyDiglog;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * unknown at 2018/6/14
 */

public abstract class BaseObserver<T> implements Observer<T> {
    private Dialog mMyDiglog;

    protected BaseObserver(Activity activity) {
        mMyDiglog = MyDiglog.createLoadingDialog(activity, "请求中......", false);
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (mMyDiglog != null) {
            mMyDiglog.show();
        }
    }

    @Override
    public void onNext(T t) {
        if ("200".equals(((FoodDataOut) t).getResultcode())) {
            success(t);
        } else {
            ToastUtils.show(((FoodDataOut) t).getReason());
        }
    }

    @Override
    public void onError(Throwable t) {
        if (mMyDiglog != null && mMyDiglog.isShowing()) {
            mMyDiglog.dismiss();
        }
        if (t instanceof NetworkErrorException ||
                t instanceof UnknownHostException
                || t instanceof ConnectException) {
            ToastUtils.show("网络异常");
        } else if (t instanceof SocketTimeoutException
                || t instanceof InterruptedIOException
                || t instanceof TimeoutException) {
            ToastUtils.show("请求超时");
        } else if (t instanceof JsonSyntaxException) {
            ToastUtils.show("请求不合法");
        } else if (t instanceof JsonParseException
                || t instanceof JSONException
                || t instanceof ParseException) {   //  解析错误
            ToastUtils.show("解析错误");
        } else {
            ToastUtils.show("连接服务器失败");
        }
    }

    @Override
    public void onComplete() {
        if (mMyDiglog != null) {
            mMyDiglog.dismiss();
        }
    }

    protected abstract void success(T e);
}
