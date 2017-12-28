package com.ssc2018.dqb.shouye;

/**
 * 作者：MrXu on 2017/12/27 11:00
 * 邮箱：17610872621@163.com
 */

import android.content.Intent;
import android.view.View;

import com.ssc2018.dqb.Draw.LotteryKaijiangActivity;
import com.ssc2018.dqb.activity.FuZhiGenDanActivity;
import com.ssc2018.dqb.activity.YuCeActivity;
import com.ssc2018.dqb.activity.ZhiBoWebActivity;
import com.ssc2018.dqb.activity.ZiXunActivity;
import com.ssc2018.dqb.constants.BallConstants;
import com.ssc2018.dqb.fragment.BaseFragment;
import com.ssc2018.dqb.R;

/**
 * 发现
 */
public class FindFragment extends BaseFragment {
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
//跳转到直播界面
        findViewById(R.id.find_zhibo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ZhiBoWebActivity.class);
                intent.putExtra("title","篮球直播");
                intent.putExtra("url", BallConstants.BASKETBALL_ZB);
                startActivity(intent);
            }
        });
        //跳转到资讯页面
        findViewById(R.id.find_zixun).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ZiXunActivity.class));
            }
        });

        // 跳转到复制跟单

        findViewById(R.id.find_gendan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FuZhiGenDanActivity.class));
            }
        });
        // 跳转到预测
        findViewById(R.id.find_yuce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), YuCeActivity.class));
            }
        });


        // 跳转到 开奖信息
        findViewById(R.id.find_kaijiang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LotteryKaijiangActivity.class));
            }
        });

        // 跳转到 每日竞彩
        findViewById(R.id.find_jingcai).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ZiXunActivity.class));
            }
        });
    }
    @Override
    public int getFragmentViewById() {
        return R.layout.find_layout;
    }
}
