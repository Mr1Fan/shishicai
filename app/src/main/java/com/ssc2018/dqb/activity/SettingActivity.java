package com.ssc2018.dqb.activity;

/**
 * 作者：MrXu on 2017/12/27 10:58
 * 邮箱：17610872621@163.com
 */

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.ssc2018.dqb.R;
import com.ssc2018.dqb.utils.ToastUtils;

/**
 * 设置
 */
public class SettingActivity extends BaseActivty{
    private ToggleButton toggleButton;
    @Override
    public void initData() {

    }

    @Override
    public void findView() {

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toggleButton = (ToggleButton) findViewById(R.id.waredetail_recommentBtn);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ToastUtils.show("消息推送已打开",SettingActivity.this);

                }else{
                    ToastUtils.show("消息推送已关闭",SettingActivity.this);
                }
            }
        });



        findViewById(R.id.versionRe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show("已经是最新版本",SettingActivity.this);
            }
        });
    }

    @Override
    public int getContentView() {
        return R.layout.setting_layout ;
    }
}
