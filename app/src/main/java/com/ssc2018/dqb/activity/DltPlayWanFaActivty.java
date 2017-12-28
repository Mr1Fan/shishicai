package com.ssc2018.dqb.activity;

/**
 * 作者：MrXu on 2017/12/27 00:21
 * 邮箱：17610872621@163.com
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.ssc2018.dqb.R;

/**
 * 大乐透玩法说明
 */
public class DltPlayWanFaActivty extends Activity {
    private TextView tv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dlt_wanfa_layout);
        //标题
        ((TextView) findViewById(R.id.title)).setText(getIntent().getStringExtra("title"));

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv1 = (TextView) findViewById(R.id.textview1);
        if (!TextUtils.isEmpty(getIntent().getStringExtra("content"))){
            tv1.setText(getIntent().getStringExtra("content"));
        }
    }
}
