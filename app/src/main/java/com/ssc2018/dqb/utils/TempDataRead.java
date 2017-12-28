package com.ssc2018.dqb.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 作者：MrXu on 2017/12/27 11:51
 * 邮箱：17610872621@163.com
 */
public class TempDataRead {
    public static String getData(Context context, String json_wj){
        try {
            InputStreamReader inputReader = new InputStreamReader(context.getResources().
                    getAssets().open(json_wj));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line="";
            String Result="";
            while((line = bufReader.readLine()) != null)
                Result += line;
            return Result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
