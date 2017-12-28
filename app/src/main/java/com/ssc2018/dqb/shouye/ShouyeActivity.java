package com.ssc2018.dqb.shouye;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssc2018.dqb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MrXu on 2017/12/27 10:19
 * 邮箱：17610872621@163.com
 */
public class ShouyeActivity  extends Fragment{
    private TabLayout mTabLayout;
    private ViewPager mNewsViewpager;
    private View mView;
    private List<Fragment> fragments;
    private GouCaiFragment gouCaiFragment;
    private FindFragment findFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.tablayout_pager, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }
    public void initView() {
        mTabLayout = (TabLayout) mView.findViewById(R.id.tab_layout);
        mNewsViewpager = (ViewPager) mView.findViewById(R.id.news_viewpager);
        //设置tablayout属性 每个标签平分TabLayout的全部宽度
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        tablelayout 标签过多可以滚动
        // mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        mTabLayout.setTabTextColors(Color.parseColor("#000000"),Color.parseColor("#0ddcff"));
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0ddcff"));

        initValidata();
    }
    public void initValidata() {
        fragments = new ArrayList<Fragment>();
        gouCaiFragment = new GouCaiFragment();
        findFragment = new FindFragment();
        fragments.add(gouCaiFragment);
        fragments.add(findFragment);
        findFragment = new FindFragment();
        mNewsViewpager.setAdapter(new FragmentPagerAdapter(getFragmentManager()){
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
            //            滑动标题
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:
                        return "模拟生成";
                    case 1:
                        return "发现";
                }
                return "沒有标题";
            }
        });
        mTabLayout.setupWithViewPager(mNewsViewpager);
    }


}
