package com.ssc2018.dqb.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.ssc2018.dqb.bean.NewsBean;
import com.ssc2018.dqb.R;

/**
 * 作者：MrXu on 2017/12/27 11:23
 * 邮箱：17610872621@163.com
 */

/**
 * 咨询详情
 */
public class NewsDetailsActivity extends Activity {

    private TextView titleTv, timeTv, contentTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
    }
    public void initData() {
        NewsBean hemaiBean = (NewsBean) getIntent().getSerializableExtra("hemaiBean");
        titleTv.setText(hemaiBean.names);
        timeTv.setText(hemaiBean.data);
        contentTv.setText(hemaiBean.contents);
    }

    public void findView() {
        ((TextView) findViewById(R.id.title)).setText("资讯详情");
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        titleTv = (TextView) findViewById(R.id.titleTv);
        timeTv = (TextView) findViewById(R.id.timeTv);
        contentTv = (TextView) findViewById(R.id.contentTv);
        initData();
    }

    public int getContentView() {
        return R.layout.new_detaisl_layout;
    }

}
