package com.ssc2018.dqb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.ssc2018.dqb.MainActivity;
import com.ssc2018.dqb.R;
import com.ssc2018.dqb.sp.UserInfoPreUtils;

/**
 * 作者：MrXu on 2017/12/27 14:04
 * 邮箱：17610872621@163.com
 */
public class WelcomeActivity extends Activity {
    private UserInfoPreUtils preUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Thread(){
            @Override
            public void run() {
                try{
                    startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
