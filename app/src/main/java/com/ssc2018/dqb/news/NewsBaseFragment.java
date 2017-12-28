package com.ssc2018.dqb.news;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ssc2018.dqb.fragment.BaseFragment;
import com.ssc2018.dqb.R;

/**
 * 作者：MrXu on 2017/12/27 11:05
 * 邮箱：17610872621@163.com
 */
public class NewsBaseFragment extends BaseFragment implements XRecyclerView.LoadingListener{
    public XRecyclerView recyclerView;
    private View headr;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        recyclerView = (XRecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallClipRotatePulse);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.SquareSpin);
        recyclerView.setLoadingListener(this);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
