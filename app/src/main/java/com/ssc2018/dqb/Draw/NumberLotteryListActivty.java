package com.ssc2018.dqb.Draw;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssc2018.dqb.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xrc on 2017/12/15.
 */
public class NumberLotteryListActivty extends Activity implements BaseRecyclerAdapter.Delegate,SwipeRefreshLayout.OnRefreshListener{
    private TextView title;
    private ImageView back;
    private RecyclerView mRecycview;
    private List<NetDatas> historyList = new ArrayList<>();
    private String array_type = "";
    List<DetailsCheckBean> listjiang = new ArrayList<>();
    private Call<NetCommon<NetDatas>> phoneResultCall;
    private String jsons = "";
    private SwipeRefreshLayout home_swiper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        findView();
    }

    public void initData() {
        init();
        getBendiData();
        getPostDatas();
    }

    private void init(){
        array_type = getIntent().getStringExtra("array_type");
        if (array_type.equals("ThreeD")) {
            getHistDatas("fc3d", "福彩3D开奖公告");
            jsons = "fcsd_result";
            phoneResultCall = Retrofitnit.getService().getFc3d();
        } else if (array_type.equals("ChooseFive")) {
            getHistDatas("4", "11选5开奖公告");
            jsons = "eleven_five_result";
            phoneResultCall = Retrofitnit.getService().getBj11x5();
        } else if (array_type.equals("ArrayThree")) {
            getHistDatas("7", "排列三开奖公告");
            jsons = "paisan_result";
            phoneResultCall = Retrofitnit.getService().getPl3();
        } else if (array_type.equals("ArrayFive")) {
            getHistDatas("8", "排列五开奖公告");
            jsons = "paiwu_result";
            phoneResultCall = Retrofitnit.getService().getPl5();
        } else if (array_type.equals("lotto")) {
            getHistDatas("6", "双色球开奖公告");
            jsons = "ssq_result";
            phoneResultCall = Retrofitnit.getService().getSsq();
        } else if (array_type.equals("excel")) {
            getHistDatas("5", "大乐透开奖公告");
            jsons = "daletou_result";
            phoneResultCall = Retrofitnit.getService().getDlt();
        }
    }

    private void getBendiData() {
        Type types = new TypeToken<NetCommon<NetDatas>>() {
        }.getType();
        String json = TempDataRead.getData(getApplicationContext(), jsons);
        Gson gson = new Gson();
        NetCommon<NetDatas> response = gson.fromJson(json, types);
        //historyList = response.getData();//后注释
        BaseRecyclerAdapter adapter = new BaseRecyclerAdapter(this, this);
        mRecycview.setAdapter(adapter);
    }

    public void getHistDatas(String type, String name) {
        title.setText(name);
    }

    public void findView() {
        title = (TextView) findViewById(R.id.title);
        back = (ImageView) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRecycview = (RecyclerView) findViewById(R.id.lottery_recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycview.setLayoutManager(manager);

        home_swiper = (SwipeRefreshLayout) findViewById(R.id.home_swiper);
        home_swiper.setOnRefreshListener(this);
        home_swiper.setColorScheme(new int[]{android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light});

        initData();
    }

    public int getContentView() {
        return R.layout.fragment_lottery_notice;
    }

    @Override
    public List<NetDatas> getData() {
        return historyList;
    }

    @Override
    public int getView(ViewGroup parent, int viewType) {
        return R.layout.item_lottery_threeleven;
    }

    @Override
    public <T> void bindView(com.ssc2018.dqb.adapter.RecyclerViewHolder holder, int position, T item) {
        final NetDatas resultBean = (NetDatas) item;
        TextView lotter_lineTv = (TextView) holder.getView(R.id.lotter_lineTv);
        TextView jc_time = (TextView) holder.getView(R.id.jc_time);
        AutoLineFeedLayout contentVie = (AutoLineFeedLayout) holder.getView(R.id.contentVie);

        if (historyList.size() - 1 == position) {
            lotter_lineTv.setVisibility(View.GONE);
        }
        jc_time.setText("第" + resultBean.getExpect() + "期  " + resultBean.getOpentime());

        listjiang.clear();
        if (array_type.equals("lotto")) {
            String[] lablese = resultBean.getOpencode().split("\\+");
            String[] reds = lablese[0].split(",");
            String[] blues = lablese[1].split(",");
            kaijiangAddDate(reds, false);
            kaijiangAddDate(blues, true);
        } else if ( array_type.equals("excel")) {
            String[] lablese = resultBean.getOpencode().split("\\+");
            String[] reds = lablese[0].split(",");
            String[] blues = lablese[1].split(",");
            kaijiangAddDate(reds, false);
            kaijiangAddDate(blues, true);
        }else {
            String[] lablese = resultBean.getOpencode().split(",");
            kaijiangAddDate(lablese, false);
        }
        contentVie.removeAllViews();
        for (int i = 0; i < listjiang.size(); i++) {
            final TextView textview = new TextView(this);
            textview.setHeight(DeviceUtils.dip2px(this, 35));
            textview.setWidth(DeviceUtils.dip2px(this, 35));
            textview.setGravity(Gravity.CENTER);
            if (listjiang.get(i).isRed_blue()) {
                textview.setBackgroundResource(R.mipmap.blue_qiu);
                textview.setTextColor(Color.parseColor("#ffffff"));
            } else {
                textview.setBackgroundResource(R.mipmap.red_qiu);
                textview.setTextColor(Color.parseColor("#ffffff"));
            }
            textview.setTextSize(12);
            textview.setText(listjiang.get(i).getNumber());
            textview.setTag(i);
            contentVie.addView(textview);
        }
    }

//    @Override
//    public <T> void bindView(RecyclerViewHolder holder, int position, T item) {
//        final NetDatas resultBean = (NetDatas) item;
//        TextView lotter_lineTv = (TextView) holder.getView(R.id.lotter_lineTv);
//        TextView jc_time = (TextView) holder.getView(R.id.jc_time);
//        AutoLineFeedLayout contentVie = (AutoLineFeedLayout) holder.getView(R.id.contentVie);
//
//        if (historyList.size() - 1 == position) {
//            lotter_lineTv.setVisibility(View.GONE);
//        }
//        jc_time.setText("第" + resultBean.getExpect() + "期  " + resultBean.getOpentime());
//
//        listjiang.clear();
//        if (array_type.equals("lotto")) {
//            String[] lablese = resultBean.getOpencode().split("\\+");
//            String[] reds = lablese[0].split(",");
//            String[] blues = lablese[1].split(",");
//            kaijiangAddDate(reds, false);
//            kaijiangAddDate(blues, true);
//        } else if ( array_type.equals("excel")) {
//            String[] lablese = resultBean.getOpencode().split("\\+");
//            String[] reds = lablese[0].split(",");
//            String[] blues = lablese[1].split(",");
//            kaijiangAddDate(reds, false);
//            kaijiangAddDate(blues, true);
//        }else {
//            String[] lablese = resultBean.getOpencode().split(",");
//            kaijiangAddDate(lablese, false);
//        }
//        contentVie.removeAllViews();
//        for (int i = 0; i < listjiang.size(); i++) {
//            final TextView textview = new TextView(this);
//            textview.setHeight(DeviceUtils.dip2px(this, 35));
//            textview.setWidth(DeviceUtils.dip2px(this, 35));
//            textview.setGravity(Gravity.CENTER);
//            if (listjiang.get(i).isRed_blue()) {
//                textview.setBackgroundResource(R.mipmap.blue_qiu);
//                textview.setTextColor(Color.parseColor("#ffffff"));
//            } else {
//                textview.setBackgroundResource(R.mipmap.red_qiu);
//                textview.setTextColor(Color.parseColor("#ffffff"));
//            }
//            textview.setTextSize(12);
//            textview.setText(listjiang.get(i).getNumber());
//            textview.setTag(i);
//            contentVie.addView(textview);
//        }
//
//    }

    private void kaijiangAddDate(String[] lablese, boolean red_blue) {
        for (int i = 0; i < lablese.length; i++) {
            DetailsCheckBean bean = new DetailsCheckBean();
            bean.setNumber(lablese[i]);
            bean.setRed_blue(red_blue);
            listjiang.add(bean);
        }
    }

    /**
     * 只是用Retrofit写出来的请求方法
     */
    private void getPostDatas() {
        init();
        phoneResultCall.enqueue(new Callback<NetCommon<NetDatas>>() {
            @Override
            public void onResponse(Call<NetCommon<NetDatas>> call, Response<NetCommon<NetDatas>> response) {
                if (response.isSuccessful()) {
                    NetCommon article = response.body();
                    if (article != null) {
                        historyList = article.getData();
                        BaseRecyclerAdapter adapter = new BaseRecyclerAdapter(NumberLotteryListActivty.this,
                                NumberLotteryListActivty.this);
                        mRecycview.setAdapter(adapter);
                    }
                } else {
                    getBendiData();
                }
                home_swiper.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<NetCommon<NetDatas>> call, Throwable t) {
                getBendiData();
                home_swiper.setRefreshing(false);
            }
        });
    }

    @Override
    public void onRefresh() {
        getPostDatas();
    }
}
