package com.ssc2018.dqb;

import android.app.Application;
import android.content.Context;

import com.avos.avoscloud.AVOSCloud;

import cn.jpush.android.api.JPushInterface;

/**
 * 作者：MrXu on 2017/12/27 16:22
 * 邮箱：17610872621@163.com
 */
public class ApplicationConfig extends Application{
    private static Context context;

//    LeanClound APPID
    public static String APPID = "N7WsUiz9jqKtYuU8OmXspimJ-gzGzoHsz";
    //    LeanClound APPKEY
    public static String APPKEY = "Te1qv6DRToCA7hy85MItmxsh";
//    这里是对应的渠道
    public static String TABLENAME = "Data_360";
//    九个渠道
/**
 * "Data_360", "Data_Ali", "Data_Baidu",
 * "Data_Huawei", "Data_Xiaomi", "Data_Yingyongbao",
 * "Data_Vivo", "Data_Sougou", "Data_Google"
 */
    @Override
    public void onCreate() {
        super.onCreate();
        // LeanCloud
        AVOSCloud.initialize(this, APPID, APPKEY);
//        启动极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);


    }

    public static Context getContext(){
        return context;
    }

}
