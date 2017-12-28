package com.ssc2018.dqb.sp;

import android.content.Context;
import android.content.SharedPreferences;

import com.ssc2018.dqb.constants.SpConstants;

/**
 * 作者：MrXu on 2017/12/27 14:05
 * 邮箱：17610872621@163.com
 */
public class UserInfoPreUtils extends PreUtilBase {

    private static final String projectSetingPre = "UserInfo_pref";

    private static UserInfoPreUtils instance;
    private SharedPreferences sp;

    public static UserInfoPreUtils getInstance(Context context) {
        if (instance == null){
            synchronized (UserInfoPreUtils.class){
                if (instance == null) {
                    instance = new UserInfoPreUtils(context);
                }
            }
        }
        return instance;
    }

    private UserInfoPreUtils(Context context) {
        sp = context.getSharedPreferences(projectSetingPre, Context.MODE_PRIVATE);
    }

    @Override
    public SharedPreferences getSp() {
        return sp;
    }

    public void setUserToken(String value){
        addString(SpConstants.UserToken,value);
    }

    public String getUsetToken(){
        return getStringWithDefaultValueNull(SpConstants.UserToken);
    }

    public void setNickname(String value){
        addString(SpConstants.Nickname,value);
    }

    public String getNickname(){
        return getStringWithDefaultValueNull(SpConstants.Nickname);
    }

    public void setUserId(String value){
        addString(SpConstants.UserId,value);
    }

    public String getUsetId(){
        return getStringWithDefaultValueNull(SpConstants.UserId);
    }

    public void setMobileWidth(int value){
        addInt(SpConstants.mobileWidth,value);
    }
    public void setMobileHeight(int value){
        addInt(SpConstants.mobileHeight,value);
    }

    public int getMobileWidth(){
        return getIntWithDefaultValue0(SpConstants.mobileWidth);
    }

    public int getMobileHeight(){
        return getIntWithDefaultValue0(SpConstants.mobileHeight);
    }

    public boolean isLogin() {
        return getBooleanWithDefaultValueFalse(SpConstants.isLogin);
    }

    public void setLogin(boolean login) {
        addBoolean(SpConstants.isLogin,login);
    }

    public boolean isFirstInstail() {
        return getBooleanWithDefaultValueFalse(SpConstants.is_first_instail);
    }

    public void setIsFirstInstail(boolean is_first) {
        addBoolean(SpConstants.is_first_instail,is_first);
    }

    public void setIsWeixinSQ(boolean value){
        addBoolean(SpConstants.IsWeixinSq,value);
    }

    public boolean getIsWeixinSQ(){
        return getBooleanWithDefaultValueFalse(SpConstants.IsWeixinSq);
    }

    public void setRequestUrl(String url){
        addString(SpConstants.RequestUrl,url);
    }

    public String getRequestUrl(){
        return getStringWithDefaultValueNull(SpConstants.RequestUrl);
    }

    public void logout(){
        setLogin(false);
        remove(SpConstants.UserId);
        remove(SpConstants.Nickname);
        remove(SpConstants.UserToken);
    }

}
