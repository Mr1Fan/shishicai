package com.ssc2018.dqb.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ssc2018.dqb.adapter.BaseRecyclerAdapter;
import com.ssc2018.dqb.adapter.RecyclerViewHolder;
import com.ssc2018.dqb.bean.GenDanBangBean;
import com.ssc2018.dqb.bean.ResponseBeseResult;
import com.ssc2018.dqb.R;
import com.ssc2018.dqb.utils.TempDataRead;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MrXu on 2017/12/27 11:53
 * 邮箱：17610872621@163.com
 */
public class GenDanListActivity extends Activity implements BaseRecyclerAdapter.Delegate{
    private XRecyclerView mRecycview;
    private List<GenDanBangBean> dataslist = new ArrayList<>();
    private String type = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        findView();
    }

    public void initData() {
        type = getIntent().getStringExtra("type");
        Type types = new TypeToken<ResponseBeseResult<GenDanBangBean>>() {
        }.getType();
        String json = "";
        if (type.equals("1")) {
            json = TempDataRead.getData(getApplicationContext(), "mingzhongbang");
        } else if (type.equals("1")) {
            json = TempDataRead.getData(getApplicationContext(), "yinglibang");
        } else {
            json = TempDataRead.getData(getApplicationContext(), "yinglibang");
        }
        Gson gson = new Gson();
        ResponseBeseResult<GenDanBangBean> response = gson.fromJson(json, types);
        dataslist = response.getData();
        BaseRecyclerAdapter adapter = new BaseRecyclerAdapter(GenDanListActivity.this, this);
        mRecycview.setAdapter(adapter);
    }

    public void findView() {
        ((TextView) findViewById(R.id.title)).setText("模拟榜单");
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRecycview = (XRecyclerView) findViewById(R.id.xrecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycview.setLayoutManager(manager);
        initData();
        mRecycview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mRecycview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                mRecycview.loadMoreComplete();
            }
        });
    }

    public int getContentView() {
        return R.layout.yuce_layout;
    }

    @Override
    public List<GenDanBangBean> getData() {
        return dataslist;
    }

    @Override
    public int getView(ViewGroup parent, int viewType) {
        return R.layout.itemmingzhon;
    }

    @Override
    public <T> void bindView(RecyclerViewHolder holder, int position, T item) {
        GenDanBangBean bean = (GenDanBangBean) item;
        ImageView simpleDraweeView = (ImageView) holder.getView(R.id.simple_view);
        simpleDraweeView.setImageURI(Uri.parse("http://mapi.159cai.com" + bean.getImageUrl()));
        holder.setText(R.id.numTv, (position + 1) + "");
        holder.setText(R.id.nicknamtTv, bean.getNickname());

        if (type.equals("1")) {
            holder.setText(R.id.zhanjiTv, "近七日战绩" + bean.getAllnum() + "中" + bean.getHitnum());
        } else if (type.equals("1")) {
            holder.setText(R.id.zhanjiTv, "近七日盈利率" + bean.getProfit() + "%");
        } else {
            holder.setText(R.id.zhanjiTv, "");
        }
    }
}
