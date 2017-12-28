package com.ssc2018.dqb.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 作者：MrXu on 2017/12/27 00:17
 * 邮箱：17610872621@163.com
 */
public abstract class BaseActivty extends AppCompatActivity {
    public final  String TAG = this.getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        findView();
        setListenter();
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
    }

    public abstract void initData();

    public abstract void findView();

    public abstract int getContentView();
    public void setListenter(){

    }
}
