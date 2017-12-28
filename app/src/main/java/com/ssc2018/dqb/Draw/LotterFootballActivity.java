package com.ssc2018.dqb.Draw;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssc2018.dqb.R;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by xrc on 2017/12/15.
 */

public class LotterFootballActivity extends Activity implements MyBaseExpandableAdapter.PageDelegate {
    private Button betBtn;
    private TextView title;
    private ImageView back;
    protected ExpandableListView expendlist;
    private MyBaseExpandableAdapter adapter;
    private ProgressBar progressBar;
    /*数据*/
    private ArrayList<EverydayDataBean<LotterFootBean>> datalist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        findView();
    }

    public void initData() {
        Type types = new TypeToken<ResponseBaseResult<EverydayDataBean<LotterFootBean>>>() {
        }.getType();
        String json = TempDataRead.getData(getApplicationContext(), "football_result");
        Gson gson = new Gson();
        ResponseBaseResult<EverydayDataBean<LotterFootBean>> response = gson.fromJson(json, types);
        findViewById(R.id.progressBar).setVisibility(View.GONE);
        datalist = response.getData();

        adapter = new MyBaseExpandableAdapter(this);
        expendlist.setAdapter(adapter);
        expendlist.expandGroup(0);
        progressBar.setVisibility(View.GONE);
    }


    public void findView() {
        expendlist = (ExpandableListView) findViewById(R.id.expendlist);
        expendlist.setGroupIndicator(null);
        betBtn = (Button) findViewById(R.id.lotter_foot_betBtn);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        title = (TextView) findViewById(R.id.title);
        title.setText("竞彩足球");
        back = (ImageView) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        betBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(LotterFootballActivity.this, FootballActivity.class));
            }
        });
        initData();
    }

    public int getContentView() {
        return R.layout.activity_lotter_football;
    }


    @Override
    public ArrayList<EverydayDataBean<LotterFootBean>> getData() {
        return datalist;
    }

    /**
     * 一级的listview
     *
     * @return
     */
    @Override
    public ArrayList<String> getGroupData() {
        ArrayList<String> group_list = new ArrayList<>();
        for (int i = 0; i < datalist.size(); i++) {
            group_list.add(datalist.get(i).getMatch_time() + "有" + datalist.get(i).getPlay_list().size() + "场比赛");
        }
        return group_list;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_group_football, null);
        return convertView;
    }

    @Override
    public void bindGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView groupTitle = (TextView) convertView.findViewById(R.id.group_title);
        groupTitle.setText(getGroupData().get(groupPosition));
        ImageView up_downImg = (ImageView) convertView.findViewById(R.id.up_downImg);
        if (isExpanded) {
            up_downImg.setImageDrawable(getResources().getDrawable(R.mipmap.up));
        } else {
            up_downImg.setImageDrawable(getResources().getDrawable(R.mipmap.down));
        }
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.items_lotter_football, null);
        return convertView;
    }

    @Override
    public void bindChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
                              ViewGroup parent) {
        int size = getData().get(groupPosition).getPlay_list().size();
        if (size == childPosition + 1) {
            View view = convertView.findViewById(R.id.gray_bg);
            ViewGroup.LayoutParams params = view.getLayoutParams();
            params.height = 0;
            view.setLayoutParams(params);
            view.setVisibility(View.INVISIBLE);
        }

        TextView lot_ite_time = (TextView) convertView.findViewById(R.id.lot_ite_time);
        TextView item_bf = (TextView) convertView.findViewById(R.id.item_bf);
        TextView item_host = (TextView) convertView.findViewById(R.id.item_host);
        TextView item_guest = (TextView) convertView.findViewById(R.id.item_guest);
        TableTextView ite_rq_num = (TableTextView) convertView.findViewById(R.id.ite_rq_num);
        LinearLayout item_lot_footlin = (LinearLayout) convertView.findViewById(R.id.item_lot_footlin);
        TableTextView tab1 = (TableTextView) item_lot_footlin.getChildAt(0);
        TableTextView tab2 = (TableTextView) item_lot_footlin.getChildAt(1);
        TableTextView tab3 = (TableTextView) item_lot_footlin.getChildAt(2);
        TableTextView tab4 = (TableTextView) item_lot_footlin.getChildAt(3);
        TableTextView tab5 = (TableTextView) item_lot_footlin.getChildAt(4);

        //设置第一栏的背景颜色
        LinearLayout lot_foot_lin = (LinearLayout) convertView.findViewById(R.id.lot_foot_lin);
        for (int i = 0; i < lot_foot_lin.getChildCount(); i++) {
            if (i == 1) {
                LinearLayout lin = (LinearLayout) lot_foot_lin.getChildAt(i);
                TableTextView textView = (TableTextView) lin.getChildAt(0);
                textView.setBackgroundColor(getResources().getColor(R.color.gray_e6));
                TableTextView textView2 = (TableTextView) lin.getChildAt(1);
                textView2.setBackgroundColor(getResources().getColor(R.color.gray_e6));
                textView2.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                TableTextView textView = (TableTextView) lot_foot_lin.getChildAt(i);
                textView.setBackgroundColor(getResources().getColor(R.color.gray_e6));
            }
        }

        LotterFootBean footBean = getData().get(groupPosition).getPlay_list().get(childPosition);

        lot_ite_time.setText(footBean.getGameType() + "\n" + footBean.getGameId()); //名称

        if (null != footBean.getHostAndTeam() && !footBean.getHostAndTeam().equals("")) {
            String[] teams = footBean.getHostAndTeam().split("VS");
            item_host.setText(teams[0]);
            item_guest.setText(teams[1]);
        }

        if (null != footBean.getJczq_bf() && !footBean.getJczq_bf().equals("") &&
                !footBean.getJczq_bf().equals("暂无数据")) {

            if (footBean.getJczq_bf().equals("胜其他")) {
                item_bf.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else if (footBean.getJczq_bf().equals("平其他")) {
                item_bf.setTextColor(getResources().getColor(R.color.basket_blue));
            } else if (footBean.getJczq_bf().equals("负其他")) {
                item_bf.setTextColor(getResources().getColor(R.color.football_green));
            } else {
                String[] score = footBean.getJczq_bf().split(":");
                Integer num1 = Integer.valueOf(score[0]);
                Integer num2 = Integer.valueOf(score[1]);
                if (num1 == num2) {
                    item_bf.setTextColor(getResources().getColor(R.color.basket_blue));
                } else if (num1 < num2) {
                    item_bf.setTextColor(getResources().getColor(R.color.football_green));
                } else if (num1 > num2) {
                    item_bf.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
            }
            item_bf.setText(footBean.getJczq_bf());  //比分数据
        }else{
            item_bf.setText("VS");  //比分数据
            item_bf.setTextColor(getResources().getColor(R.color.yellow));
        }

        if (!footBean.getJczq_rqspf().equals("暂无数据")) {
            //让球的数据
            if (footBean.getJczq_rqspf().contains("-")) {
                ite_rq_num.setTextColor(getResources().getColor(R.color.football_green));
            } else {
                ite_rq_num.setTextColor(getResources().getColor(R.color.colorPrimary));
            }
            String[] rqnum = footBean.getJczq_rqspf().split("\\$");
            ite_rq_num.setText(rqnum[0]);
            tab2.setText(rqnum[1]); //让球
        } else {
            ite_rq_num.setText(footBean.getJczq_rqspf());  //让球胜平负
        }
        tab1.setText(footBean.getJczq_spf());  //胜平负
        tab3.setText(footBean.getJczq_bf());  //比分
        tab4.setText(footBean.getJczq_zjq());  //总进球
        tab5.setText(footBean.getJczq_bqc()); //半全场
    }
}
