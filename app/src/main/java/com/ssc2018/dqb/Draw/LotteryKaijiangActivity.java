package com.ssc2018.dqb.Draw;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.ssc2018.dqb.R;


/**
 * Created by xrc on 2017/12/15.
 * 开奖界面
 */

public class LotteryKaijiangActivity extends BasesActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    @Override
    public void initData() {

    }

    @Override
    public void findView() {
        //加载开奖的Fragment
        fragmentManager=getSupportFragmentManager();

        transaction=fragmentManager.beginTransaction();
        LotteryNotificaFrag purchaseOrderFg=new LotteryNotificaFrag();
        transaction.replace(R.id.mypurchase_content,purchaseOrderFg);
        transaction.commit();

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public int getContentView() {
        return R.layout.lottery_kaijaing_layout;
    }
}
