package com.ssc2018.dqb.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssc2018.dqb.adapter.BaseRecyclerAdapter;
import com.ssc2018.dqb.adapter.RecyclerViewHolder;
import com.ssc2018.dqb.bean.GendanBean;
import com.ssc2018.dqb.bean.ResponseBeseResult;
import com.ssc2018.dqb.R;
import com.ssc2018.dqb.utils.TempDataRead;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MrXu on 2017/12/27 11:38
 * 邮箱：17610872621@163.com
 */
public class FuZhiGenDanActivity extends BaseActivty{
    private RecyclerView gend_recy;
    private List<GendanBean> gendanBeanList = new ArrayList<>();

    @Override
    public void initData() {
        //跟单数据
        String jsosdn = TempDataRead.getData(this, "gendan");
        //获取本地的假数据
        Type types = new TypeToken<ResponseBeseResult<GendanBean>>() {
        }.getType();
        Gson gsonsd = new Gson();
        ResponseBeseResult<GendanBean> responses = gsonsd.fromJson(jsosdn, types);
        gendanBeanList = responses.getData();
        BaseRecyclerAdapter adapters = new BaseRecyclerAdapter(FuZhiGenDanActivity.this, gendanDe);
        gend_recy.setAdapter(adapters);
    }

    @Override
    public void findView() {
        LinearLayout linearLayout= (LinearLayout) findViewById(R.id.mingzhongLin);
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        linearLayout.requestFocus();
        findViewById(R.id.toolbar).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.title)).setText("复制跟单");
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        gend_recy = (RecyclerView) findViewById(R.id.recyclerView);
        gend_recy.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.mingzhongLin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FuZhiGenDanActivity.this, GenDanListActivity.class);
                intent.putExtra("type", "1");
                startActivity(intent);
            }
        });

        findViewById(R.id.yinlibLIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FuZhiGenDanActivity.this, GenDanListActivity.class);
                intent.putExtra("type", "1");
                startActivity(intent);
            }
        });

        findViewById(R.id.wodgzLin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FuZhiGenDanActivity.this, GenDanListActivity.class);
                intent.putExtra("type", "1");
                startActivity(intent);
            }
        });
    }
    /**
     * 跟单列表
     */
    BaseRecyclerAdapter.Delegate gendanDe = new BaseRecyclerAdapter.Delegate() {
        @Override
        public List<GendanBean> getData() {
            return gendanBeanList;
        }

        @Override
        public int getView(ViewGroup parent, int viewType) {
            return R.layout.itemmingzhon;
        }

        @Override
        public <T> void bindView(RecyclerViewHolder holder, int position, T item) {
            final GendanBean bean = (GendanBean) item;
            ImageView simple_view = (ImageView) holder.getView(R.id.simple_view);
            simple_view.setImageURI(Uri.parse(bean.getHeader()));
            holder.setText(R.id.nicknamtTv, bean.getNickname());
            holder.setText(R.id.benshuTv, bean.getBenshu());
            holder.setText(R.id.teamTv, bean.getTeam());
            holder.setText(R.id.endtimeTv, bean.getCreatetime());
            holder.setText(R.id.contentTv, bean.getContent());
            holder.setText(R.id.zigouTv, bean.getZigou());
            holder.setText(R.id.gendanTv, bean.getGendan());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FuZhiGenDanActivity.this, GendanDetailsActivtiy.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("bean",bean);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

        }
    };
    @Override
    public int getContentView() {
        return R.layout.fuzhi_gendan_layout;
    }
}
