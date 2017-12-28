package com.ssc2018.dqb.fragment;

import android.content.Intent;
import android.view.View;

import com.ssc2018.dqb.activity.ZhiBoWebActivity;
import com.ssc2018.dqb.constants.BallConstants;
import com.ssc2018.dqb.R;

/**
 * 作者：MrXu on 2017/12/27 10:11
 * 邮箱：17610872621@163.com
 */
public class ZhiBoFragment extends BaseFragment {
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

/**
 * 足球直播
 */
        findViewById(R.id.footRe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ZhiBoWebActivity.class);
                intent.putExtra("title","足球直播");
                intent.putExtra("url", BallConstants.FOOTBALL_ZB);
                startActivity(intent);
            }
        });
        /**
         * 篮球直播
         */
        findViewById(R.id.basketRe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ZhiBoWebActivity.class);
                intent.putExtra("title","篮球直播");
                intent.putExtra("url",BallConstants.BASKETBALL_ZB);
                startActivity(intent);
            }
        });

    }
    @Override
    public int getFragmentViewById() {
        return R.layout.zhibo_layout;
    }

}
