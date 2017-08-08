package com.opensourcelib.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;

import com.blankj.utilcode.util.Utils;

/**
 * Created by hjy on 2017/6/7.
 */
public class ToastUtil {
    private static Context mContext;
    private static Toast toast;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    public static void show(String message) {
        show(message, Toast.LENGTH_SHORT);
    }

    @Deprecated
    public static void show(Context context, String message) {
        show(message, Toast.LENGTH_SHORT);
    }

    public static void show(final String message, final int duration) {
        sHandler.post(new Runnable() {
            @Override
            public void run() {
                if(TextUtils.isEmpty(message)) {
                    return;
                }
                if(mContext == null) {
                    mContext = Utils.getContext();
                }
                if(toast == null) {
                    toast = Toast.makeText(mContext, message, duration);
                }
                toast.setText(message);
                toast.show();
            }
        });

    }
}
