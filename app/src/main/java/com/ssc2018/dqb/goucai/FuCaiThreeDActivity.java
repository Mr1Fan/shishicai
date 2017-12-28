package com.ssc2018.dqb.goucai;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ssc2018.dqb.adapter.BaseRecyclerAdapter;
import com.ssc2018.dqb.adapter.RecyclerViewHolder;
import com.ssc2018.dqb.bean.KaiJiangBean;
import com.ssc2018.dqb.R;
import com.ssc2018.dqb.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MrXu on 2017/12/27 13:52
 * 邮箱：17610872621@163.com
 */
public class FuCaiThreeDActivity extends Activity implements BaseRecyclerAdapter.Delegate{


    private TextView select_hint, at_leastTv;
    private LinearLayout kjh_visible;
    private ImageView up_downImg;
    private RecyclerView kjh_recyc;
    private List<KaiJiangBean> benaList = new ArrayList<>();
    private boolean is_visble = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        findView();
    }
    public void initData() {
        KaiJiangBean bena1 = new KaiJiangBean("260期", "0 9 5");
        KaiJiangBean bena2 = new KaiJiangBean("259期", "4 8 1");
        KaiJiangBean bena3 = new KaiJiangBean("258期", "3 6 2");
        KaiJiangBean bena4 = new KaiJiangBean("257期", "2 3 4");
        KaiJiangBean bena5 = new KaiJiangBean("256期", "3 6 2");
        KaiJiangBean bena6 = new KaiJiangBean("255期", "5 2 1");
        KaiJiangBean bena7 = new KaiJiangBean("254期", "3 2 6");
        benaList.add(bena1);
        benaList.add(bena2);
        benaList.add(bena3);
        benaList.add(bena4);
        benaList.add(bena5);
        benaList.add(bena6);
        benaList.add(bena7);

        BaseRecyclerAdapter adapter = new BaseRecyclerAdapter(this, this);
        kjh_recyc.setAdapter(adapter);
    }
    public void findView() {
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ((TextView) findViewById(R.id.title)).setText("福彩3D");
        kjh_visible = (LinearLayout) findViewById(R.id.kjh_visible);
        up_downImg = (ImageView) findViewById(R.id.up_downImg);
        at_leastTv = (TextView) findViewById(R.id.at_leastTv);
        String play = "至少选择6个<html><body><font color='#e1261d'>" + "红球" +"</font></body></html>";
        at_leastTv.setText(Html.fromHtml(play));

        kjh_recyc = (RecyclerView) findViewById(R.id.kjh_recyc);
        kjh_recyc.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.visible_Re).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_visble) {
                    kjh_visible.setVisibility(View.GONE);
                    up_downImg.setImageDrawable(getResources().getDrawable(R.mipmap.down));
                    is_visble = false;
                } else {
                    kjh_visible.setVisibility(View.VISIBLE);
                    up_downImg.setImageDrawable(getResources().getDrawable(R.mipmap.up));
                    is_visble = true;
                }
            }
        });

        findViewById(R.id.confirm_bet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show("根据相关法律法规，线上暂不允许购彩，请到各大线下网点投注", FuCaiThreeDActivity.this);
            }
        });
        initData();
    }
    public int getContentView() {
        return R.layout.fucai3d_layout;
    }

    @Override
    public List<KaiJiangBean> getData() {
        return benaList;
    }

    @Override
    public int getView(ViewGroup parent, int viewType) {
        return R.layout.items_union_lotton;
    }

    @Override
    public <T> void bindView(RecyclerViewHolder holder, int position, T item) {
        KaiJiangBean bean = (KaiJiangBean) item;
        LinearLayout kjh_lin = (LinearLayout) holder.getView(R.id.kjh_lin);
        TextView kjh_num = (TextView) holder.getView(R.id.kjh_num);
        if (position % 2 == 0) {
            kjh_lin.setBackgroundColor(getResources().getColor(R.color.gray_eb));
        } else {
            kjh_lin.setBackgroundColor(getResources().getColor(R.color.gray_e6));
        }
        holder.setText(R.id.qh_num, bean.issno + "期");
        String shuzi = "<html><body><font color='#e1261d'>" + bean.winno.replace(" ", "  ") +
                "</font></body></html>" + "<html><body><font color='#348fff'></font></body></html>";
        kjh_num.setText(Html.fromHtml(shuzi));
    }


}
