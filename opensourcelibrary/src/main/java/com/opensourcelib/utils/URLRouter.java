package com.opensourcelib.utils;

/**
 * Created by hjy on 2017/7/6.
 */

public class URLRouter {


    /**
     *
     final Uri uri = new Uri.Builder().authority("wsc").path("home/bbb")
     .appendQueryParameter("message", new Gson().toJson(messageModel)).build();
     final Intent intent = new Intent(Intent.ACTION_VIEW);
     intent.setData(uri);
     startActivity(intent);
     *
     */


    /**
     ZanURLRouter.from(getContext())
     .withAction(Intent.ACTION_VIEW)
     .withUri("wsc://home/bbb")
     .withParcelableExtra("message", messageModel)
     .navigate();
     */

    public URLRouter(){
    }




}
