package com.opensourcelib.platform.glide;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.opensourcelib.R;

/**
 * Created by hjy on 2017/6/8.
 */
public class RequestOptionsUtils {

    /**
     * centerCrop
     *
     * @param placeholder
     * @param error
     * @param priority
     * @param cacheStrategy
     * @return
     */
    public static RequestOptions getRequestOptions(int placeholder, int error, Priority priority, DiskCacheStrategy cacheStrategy) {
        return new RequestOptions()
                .centerCrop()
                .placeholder(placeholder)
                .error(error)
                .priority(priority)
                .diskCacheStrategy(cacheStrategy);
    }

    /**
     *   默认
     *
     * @return
     */
    public static RequestOptions getDefaultRequestOptions() {
        return getRequestOptions(R.mipmap.common,R.mipmap.common,Priority.HIGH, DiskCacheStrategy.ALL);
    }

}
