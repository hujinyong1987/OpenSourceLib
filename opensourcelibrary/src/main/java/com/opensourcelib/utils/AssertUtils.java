package com.opensourcelib.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by hjy on 2017/6/8.
 */

public class AssertUtils {

    /**
     * 读取assets文件数据
     * @return
     */
    public static String getFromAssets(Context context, String fileName) {
        String result = "";
        try {
            InputStreamReader inputReader = new InputStreamReader(context.getResources().getAssets().open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";
            while((line = bufReader.readLine()) != null)
                result += line;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
