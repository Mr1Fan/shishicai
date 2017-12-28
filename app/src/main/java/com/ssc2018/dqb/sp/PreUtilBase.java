package com.ssc2018.dqb.sp;

import android.content.SharedPreferences;

/**
 * 作者：MrXu on 2017/12/27 14:05
 * 邮箱：17610872621@163.com
 */
public abstract class PreUtilBase {
    public abstract SharedPreferences getSp();
    protected void remove(String key) {
        SharedPreferences.Editor editor = getSp().edit();
        editor.remove(key);
        editor.commit();
    }

    /* ----- Boolean ----- */
    protected void addBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = getSp().edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    protected boolean getBoolean(String key, boolean defValue) {
        return getSp().getBoolean(key, defValue);
    }

    protected boolean getBooleanWithDefaultValueFalse(String key) {
        return getSp().getBoolean(key, false);
    }

    protected boolean getBooleanWithDefaultValueTrue(String key) {
        return getSp().getBoolean(key, true);
    }

    /* ----- String ----- */
    public void addString(String key, String value) {
        SharedPreferences.Editor editor = getSp().edit();
        editor.putString(key, value);
        editor.commit();
    }

    protected void resetStringTo1(String key){
        addString(key, "1");
    }

    protected void resetStringTo0(String key){
        addString(key, "0");
    }

    protected void resetStringToQuote(String key){
        addString(key, "");
    }

    public String getString(String key, String defValue) {
        return getSp().getString(key, defValue);
    }

    protected String getStringWithDefaultValueNull(String key) {
        return getSp().getString(key, null);
    }

    protected String getStringWithDefaultValueQuote(String key) {
        return getSp().getString(key, "");
    }

    protected String getStringWithDefaultValue(String key, String value) {
        return getSp().getString(key, value);
    }

    /* ----- Integer ----- */
    protected void addInt(String key, int value) {
        SharedPreferences.Editor editor = getSp().edit();
        editor.putInt(key, value);
        editor.commit();
    }

    protected int getIntWithDefaultValue0(String key) {
        return getSp().getInt(key, 0);
    }

    protected int getInt(String key, int defValue) {
        return getSp().getInt(key, defValue);
    }


}
