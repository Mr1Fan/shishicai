package com.ssc2018.dqb.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ssc2018.dqb.adapter.TabAdapter;
import com.ssc2018.dqb.news.LTBasketballFrag;
import com.ssc2018.dqb.news.LTFootballFrag;
import com.ssc2018.dqb.news.LTFucaiFrag;
import com.ssc2018.dqb.news.LTTiCaiFrag;
import com.ssc2018.dqb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MrXu on 2017/12/27 11:02
 * 邮箱：17610872621@163.com
 */
public class ZiXunActivity extends FragmentActivity {
    private TextView title;
    private ImageView back;
    private TabLayout tabLayout;   //定义TabLayout
    private ViewPager viewPager;      //定义viewPager
    private TabAdapter tabAdapter;    //定义Tab 的adapter
    private List<Fragment> list_fragment; //定义要装fragment的列表
    private List<String> list_title;   //tab名称列表
    private LTFootballFrag ltFootballFrag;
    private LTBasketballFrag ltBasketballFrag;
    private LTFucaiFrag ltFucailFrag;
    private LTTiCaiFrag ltTicailFrag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        findView();
    }
    public void initData() {
    }

    public void findView() {
        title = (TextView) findViewById(R.id.title);
        title.setText("彩票资讯");
        back = (ImageView) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.account_tab_layout);
        viewPager = (ViewPager) findViewById(R.id.account_viewpager);

        //初始化各fragment
        ltFootballFrag = new LTFootballFrag();
        ltBasketballFrag = new LTBasketballFrag();
        ltFucailFrag = new LTFucaiFrag();
        ltTicailFrag = new LTTiCaiFrag();

        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(ltFootballFrag);
        list_fragment.add(ltBasketballFrag);
        list_fragment.add(ltFucailFrag);
        list_fragment.add(ltTicailFrag);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("竞足");
        list_title.add("竞篮");
        list_title.add("福彩");
        list_title.add("体彩");

        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(3)));
        tabAdapter = new TabAdapter(getSupportFragmentManager(),list_fragment,list_title);


        //viewpager加载adapter
        viewPager.setAdapter(tabAdapter);
        viewPager.setOffscreenPageLimit(3);
        //TabLayout加载viewpager
        tabLayout.setupWithViewPager(viewPager);
        initData();
    }

}
