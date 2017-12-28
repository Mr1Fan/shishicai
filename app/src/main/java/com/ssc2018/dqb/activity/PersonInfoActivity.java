package com.ssc2018.dqb.activity;

/**
 * 作者：MrXu on 2017/12/27 10:50
 * 邮箱：17610872621@163.com
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.ssc2018.dqb.R;

/**
 * 个人信息
 */
public class PersonInfoActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        findView();
    }
    public void initData(){
        ((TextView) findViewById(R.id.nameTv)).setText(getResources().getString(R.string.app_name)+"用户");
    }
    public void findView(){
        ((TextView) findViewById(R.id.title)).setText("个人信息");
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();
    }


    public int getContentView(){
        return R.layout.myself_layout;
    }

}
