package com.ssc2018.dqb.utils;

import android.util.Log;

/**
 * 作者：MrXu on 2017/12/27 13:44
 * 邮箱：17610872621@163.com
 */
public class LogUtils {
    public static boolean LogDEBUG = true;

    private static final String TAG = LogUtils.class.getName();

    public static void i(String msg){
        if (LogDEBUG) {
            Log.i(TAG, msg==null?"null":msg);
        }
    }

    public static void i(String tag,String msg){
        if (LogDEBUG) {
            Log.i(tag, msg==null?"null":msg);
        }
    }
    public static void v(String tag,String msg){
        if (LogDEBUG) {
            Log.v(tag, msg==null?"null":msg);
        }
    }

    public static void d(String tag,String msg){
        if (LogDEBUG) {
            Log.d(tag, msg==null?"null":msg);
        }
    }

    public static void e(String msg){
        if (LogDEBUG) {
            Log.e(TAG, msg==null?"null":msg);
        }
    }

    public static void e(String tag,String msg){
        if (LogDEBUG) {
            Log.e(tag, msg==null?"null":msg);
        }
    }

    public static void w(String tag,String msg){
        if (LogDEBUG) {
            Log.w(tag, msg==null?"null":msg);
        }
    }
}
