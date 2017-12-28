package com.ssc2018.dqb.goucai;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssc2018.dqb.Draw.BasketPlayBean;
import com.ssc2018.dqb.Draw.MyBaseExpandableAdapter;
import com.ssc2018.dqb.Draw.TableTextView;
import com.ssc2018.dqb.bean.EverydayDataBean;
import com.ssc2018.dqb.bean.ResponseBeseResult;
import com.ssc2018.dqb.constants.BallConstants;
import com.ssc2018.dqb.R;
import com.ssc2018.dqb.utils.TempDataRead;
import com.ssc2018.dqb.utils.ToastUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MrXu on 2017/12/27 13:48
 * 邮箱：17610872621@163.com
 */
public class LanQiuActivity extends Activity implements MyBaseExpandableAdapter.PageDelegate{

    private ExpandableListView expendlist;
    protected MyBaseExpandableAdapter adapter;
    protected ArrayList<EverydayDataBean<BasketPlayBean>> dataBeen;
    protected ArrayList<String> group_list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        findView();
    }
    public void initData(){
        Type types = new TypeToken<ResponseBeseResult<EverydayDataBean<BasketPlayBean>>>() {
        }.getType();
        String json = TempDataRead.getData(this, "basketball_data");
        Gson gson = new Gson();
        ResponseBeseResult<EverydayDataBean<BasketPlayBean>> response = gson.fromJson(json, types);
        findViewById(R.id.progressBar).setVisibility(View.GONE);
        dataBeen = response.getData();
        adapter = new MyBaseExpandableAdapter(this);
        expendlist.setAdapter(adapter);
        expendlist.expandGroup(0);
    }
    public void findView(){
        ((TextView) findViewById(R.id.title)).setText("篮球投注");
        expendlist = (ExpandableListView) findViewById(R.id.expendlist);
        expendlist.setGroupIndicator(null);  //设置默认的箭头为null
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.confirm_bet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show("根据相关法律法规，线上暂不允许购彩，请到各大线下网点投注", LanQiuActivity.this);
            }
        });
        initData();
    }
    public int getContentView(){
        return  R.layout.football_layout;
    }
    @Override
    public ArrayList<EverydayDataBean<BasketPlayBean>> getData() {
        return dataBeen;
    }

    @Override
    public ArrayList<String> getGroupData() {
        if (group_list == null) {
            group_list = new ArrayList<>();
            for (int i = 0; i < dataBeen.size(); i++) {
                group_list.add(dataBeen.get(i).getMatch_time() +
                        "有" + dataBeen.get(i).getPlay_list().size() + "场比赛");
            }
        }
        return group_list;
    }

    @Override
    public Context getContext() {
        return LanQiuActivity.this;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_group_football,null);
        return convertView;
    }

    /**
     * 绑定 itemGroupView数据
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     */
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
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_basked_ht,null);
        return convertView;
    }

    @Override
    public void bindChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView match_name = (TextView) convertView.findViewById(R.id.match_name);
        TextView game_no = (TextView) convertView.findViewById(R.id.game_no);
        TextView end_buy_time = (TextView) convertView.findViewById(R.id.end_buy_time);
        TextView host_name = (TextView) convertView.findViewById(R.id.host_name);
        TextView guest_name = (TextView) convertView.findViewById(R.id.guest_name);
        final ImageView up_downImg = (ImageView) convertView.findViewById(R.id.up_downImg);
        LinearLayout flag_ll = (LinearLayout) convertView.findViewById(R.id.flag_ll);

        //获取二级数据
        BasketPlayBean playBean = getData().get(groupPosition).getPlay_list().get(childPosition);

        //显示主队 客队的名称,和比赛时间
        //足球界面的显示
        //篮球界面的显示
        if (getData().get(groupPosition).getPlay_list().get(childPosition) instanceof BasketPlayBean) {
            up_downImg.setVisibility(View.GONE);
            BasketPlayBean playDataBean = (BasketPlayBean) getData().get(groupPosition).getPlay_list().get(childPosition);
            match_name.setText("篮球"); //playDataBean.getLeague_name()
            game_no.setText(playDataBean.getGame_no());
            String time = playDataBean.getEnd_buy_time();
            time = time.substring(time.indexOf(" ") + 1, time.length());
            end_buy_time.setText(time);
            host_name.setText(playDataBean.getHost_team_single());
            guest_name.setText(playDataBean.getGuest_team_single());
        }
        LinearLayout ht_lin1 = (LinearLayout) convertView.findViewById(R.id.ht_lin1);  //胜负
        LinearLayout ht_lin2 = (LinearLayout) convertView.findViewById(R.id.ht_lin2); //让分胜负
        TableTextView tableView_rf = (TableTextView) convertView.findViewById(R.id.tableTextView_rq);
        TableTextView htsf_visbletv = (TableTextView) convertView.findViewById(R.id.htsf_visbletv);
        TableTextView htrfsf_visbletv = (TableTextView) convertView.findViewById(R.id.htrfsf_visbletv);
        //获取 胜负 让分 赔率数据
        List<String> sf_list = playBean.getJclq_dxfsf();
        List<String> rf_list = playBean.getJclq_rfsf();
        //设置让分View的颜色值
        if (null != rf_list && tableView_rf != null && rf_list.size() != 0) {
            tableView_rf.setText(rf_list.get(0));
            if (rf_list.get(0).contains("-")) {
                tableView_rf.setBackgroundColor(getResources().getColor(R.color.light_green_bg));
                tableView_rf.setTextColor(getResources().getColor(R.color.light_green_text));
            } else {
                tableView_rf.setBackgroundColor(getResources().getColor(R.color.light_red_bg));
                tableView_rf.setTextColor(getResources().getColor(R.color.light_red_text));
            }
        }
        //判断胜负是否有数据
        if (sf_list == null || sf_list.size() == 0) {
            htsf_visbletv.setVisibility(View.VISIBLE);
            ht_lin1.setVisibility(View.GONE);
        } else {
            htsf_visbletv.setVisibility(View.GONE);
            ht_lin1.setVisibility(View.VISIBLE);
            for (int i = 1; i < ht_lin1.getChildCount(); i++) {
                if (ht_lin1.getChildAt(i) instanceof TableTextView) {
                    TableTextView tableTextView = (TableTextView) ht_lin1.getChildAt(i);
                    tableTextView.setText(BallConstants.sfObbs[i - 1].replace("$odds", sf_list.get(i - 1)));
                }
            }
        }

        //判断让分胜负赔率是否有数据
        if (rf_list == null || rf_list.size() == 0) {
            htrfsf_visbletv.setVisibility(View.VISIBLE);
            ht_lin2.setVisibility(View.GONE);
            htrfsf_visbletv.setFlag_line_up(0);
        } else {
            htrfsf_visbletv.setVisibility(View.GONE);
            ht_lin2.setVisibility(View.VISIBLE);
            for (int i = 1; i < ht_lin2.getChildCount(); i++) {
                if (ht_lin1.getChildAt(i) instanceof TableTextView) {
                    TableTextView tab2 = (TableTextView) ht_lin2.getChildAt(i);
                    tab2.setText(BallConstants.rfsfObbs[i - 1].replace("$odds", rf_list.get(i)));
                }
            }
        }
    }
}
