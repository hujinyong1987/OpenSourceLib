package com.opensourcelib.platform.rxandroid.utils;

import android.util.Log;
import com.opensourcelib.entity.ResultData;
import com.opensourcelib.utils.ToastUtil;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by hjy on 2017/6/7.
 */
public abstract class BaseObserver<T> implements Observer<ResultData<T>> {

    private static final String TAG = "BaseObserver";

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(ResultData<T> value) {
        if (value.isSuccess()) {
            T t = value.data;
            onSuccess(t);
        } else {
            /**
             * 统一处理错误异常
             */
            onError(value.msg);
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "error:" + e.toString());
        onError(e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
    }


    protected abstract void onSuccess(T t);

    protected void onError(String msg) {
        ToastUtil.show(msg);
    }
}
