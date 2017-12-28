package com.ssc2018.dqb.Draw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by xrc on 2017/12/15.
 */

public abstract class BasesActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        findView();
        setListenter();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    public abstract void initData();

    public abstract void findView();

    public abstract int getContentView();

    public void setListenter(){

    }

}
