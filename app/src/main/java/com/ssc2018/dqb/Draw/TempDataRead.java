package com.ssc2018.dqb.Draw;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by ygs on 2017/6/23.
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
