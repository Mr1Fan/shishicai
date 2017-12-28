package com.ssc2018.dqb.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 作者：MrXu on 2017/12/27 10:54
 * 邮箱：17610872621@163.com
 */

/**
 * Toast工具类
 */
public class ToastUtils {
    public static void show(String text,Context context){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }
}
