package com.ssc2018.dqb.activity;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ssc2018.dqb.adapter.BaseRecyclerAdapter;
import com.ssc2018.dqb.adapter.RecyclerViewHolder;
import com.ssc2018.dqb.bean.GendanBean;
import com.ssc2018.dqb.bean.NewsBean;
import com.ssc2018.dqb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MrXu on 2017/12/27 11:57
 * 邮箱：17610872621@163.com
 */
public class GendanDetailsActivtiy extends BaseActivty {
    private GendanBean bean;
    private RecyclerView recyclerView;
    private List<NewsBean> list = new ArrayList<>();



    @Override
    public void initData() {

        NewsBean bean1 = new NewsBean("可爱******", "40元", "10-31 10:57", "");
        NewsBean bean2 = new NewsBean("五家******", "26元", "10-31 10:52", "");
        NewsBean bean3 = new NewsBean("黑曼******", "24元", "10-31 10:11", "");
        NewsBean bean4 = new NewsBean("小葱******", "67元", "10-31 10:22", "");
        NewsBean bean5 = new NewsBean("白马******", "445元", "10-31 10:56", "");
        NewsBean bean6 = new NewsBean("KT******", "234元", "10-31 10:23", "");
        NewsBean bean7 = new NewsBean("SUT******", "45元", "10-31 10:45", "");
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        list.add(bean5);
        list.add(bean6);
        list.add(bean7);

        BaseRecyclerAdapter adapters = new BaseRecyclerAdapter(this, gendanDe);
        recyclerView.setAdapter(adapters);
    }

    @Override
    public void findView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ((TextView) findViewById(R.id.title)).setText("模拟跟单详情");
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bean = (GendanBean) getIntent().getSerializableExtra("bean");
        ImageView simple_view = (ImageView) findViewById(R.id.simple_view);
        simple_view.setImageURI(Uri.parse(bean.getHeader()));

        ((TextView) findViewById(R.id.endtimeTv)).setText(bean.getCreatetime());
        ((TextView) findViewById(R.id.nicknamtTv)).setText(bean.getNickname());
        ((TextView) findViewById(R.id.benshuTv)).setText(bean.getBenshu());
        ((TextView) findViewById(R.id.teamTv)).setText(bean.getTeam());
        ((TextView) findViewById(R.id.contentTv)).setText(bean.getContent());
        ((TextView) findViewById(R.id.zigouTv)).setText(bean.getZigou());
        ((TextView) findViewById(R.id.gendanTv)).setText(bean.getGendan());

    }


    /**
     * 跟单列表
     */
    BaseRecyclerAdapter.Delegate gendanDe = new BaseRecyclerAdapter.Delegate() {
        @Override
        public List<NewsBean> getData() {
            return list;
        }

        @Override
        public int getView(ViewGroup parent, int viewType) {
            return R.layout.items_gendan;
        }

        @Override
        public <T> void bindView(RecyclerViewHolder holder, int position, T item) {
            NewsBean bean = (NewsBean) item;
            holder.setText(R.id.nameTv, bean.names);
            holder.setText(R.id.timeTv, bean.imgs);
            holder.setText(R.id.moneyTv, bean.data);

        }
    };


    @Override
    public int getContentView() {
        return R.layout.gendan_details_layout;
    }

}
