package com.ssc2018.dqb.Draw;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssc2018.dqb.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xrc on 2017/12/15.
 * 开奖公告
 */

public class LotteryNotificaFrag extends BasesFragment {

    private RecyclerView mRecycview;
    private LotterResultAdapter adapter;
    private TextView title;
    private ImageView back;
    List<LotterNoticeBean> list=new ArrayList<>();

    @Override
    protected void initData() {
        String json = TempDataRead.getData(getActivity(),"kaijiang");
        //获取本地的假数据
        Type type=new TypeToken<ResponseBaseResult<LotterNoticeBean>>(){
        }.getType();
        Gson gson = new Gson();
        ResponseBaseResult<LotterNoticeBean> response = gson.fromJson(json, type);
        //后注视
        list = response.getData();
        adapter = new LotterResultAdapter(getActivity(), list);
        mRecycview.setAdapter(adapter);
        adapter.setMyViewHolerClicks(viewHolerClicks);
    }

    @Override
    protected void initView() {
        mRecycview = (RecyclerView) getView().findViewById(R.id.lottery_recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycview.setLayoutManager(manager);

        title = (TextView) findViewById(R.id.title);
        title.setText("开奖公告");
        back = (ImageView) findViewById(R.id.back_btn);
    }

    @Override
    public int getFragmentViewById() {
        return R.layout.lottery_notifica_frag;
    }
    LotterResultAdapter.MyViewHolerClicks viewHolerClicks=new LotterResultAdapter.MyViewHolerClicks() {
        @Override
        public void onItemClick(int position, String type, String url) {
            if (type.equals("jczq")|| type.equals("bjdc")) {
                startActivity(new Intent(getActivity(), LotterFootballActivity.class));
            } else if (type.equals("jclq") || type.equals("sfgg")) {
                startActivity(new Intent(getActivity(),LotterBasketballActivity.class));
            } else {
                Intent intent = new Intent(getActivity(), NumberLotteryListActivty.class);
                intent.putExtra("array_type", type);
                startActivity(intent);
            }
        }
    };
}
