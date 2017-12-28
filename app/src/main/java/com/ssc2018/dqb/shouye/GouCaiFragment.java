package com.ssc2018.dqb.shouye;

/**
 * 作者：MrXu on 2017/12/27 13:38
 * 邮箱：17610872621@163.com
 */

import android.content.Intent;
import android.view.View;

import com.ssc2018.dqb.fragment.BaseFragment;
import com.ssc2018.dqb.goucai.DaLeTouActivity;
import com.ssc2018.dqb.goucai.FuCaiThreeDActivity;
import com.ssc2018.dqb.goucai.LanQiuActivity;
import com.ssc2018.dqb.goucai.QiLeCaiActivity;
import com.ssc2018.dqb.goucai.SSQActivity;
import com.ssc2018.dqb.R;

/**
 * 购彩  也就是   模拟生成
 */
public class GouCaiFragment extends BaseFragment {
    @Override
    protected void initData() {


    }
    @Override
    protected void initView() {
        //跳转到双色球界面
        findViewById(R.id.home_ssq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SSQActivity.class));
            }
        });

        //跳转到篮球界面
        findViewById(R.id.jingcailanqiu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LanQiuActivity.class));
            }
        });
        //跳转到福彩3D界面
        findViewById(R.id.fucaithreeD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FuCaiThreeDActivity.class));
            }
        });
//        跳转到足球界面
        findViewById(R.id.jingcaizuqiu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LanQiuActivity.class));
            }
        });
        //跳转到七乐彩界面
        findViewById(R.id.qilecai).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), QiLeCaiActivity.class));
            }
        });
//        跳转到大乐透界面
        findViewById(R.id.daletou).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DaLeTouActivity.class));
            }
        });
    }
    @Override
    public int getFragmentViewById() {
        return R.layout.goucai_layout;
    }

}
