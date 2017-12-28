package com.ssc2018.dqb.Draw;

import android.content.Context;
import android.widget.Toast;


/**
 * Created by Administrator on 2017/2/20.
 */

public class ToastUtils {
//    public static void showLong(String value){
//        if (!TextUtils.isEmpty(value)){
//            Toast.makeText(MyApplication.getContext(), value, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public static void showShort(String value){
//        if (!TextUtils.isEmpty(value)){
//            Toast.makeText(MyApplication.getContext(), value, Toast.LENGTH_SHORT).show();
//        }
//    }
    public static void show(String text, Context context) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
