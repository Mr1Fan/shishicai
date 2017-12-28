package com.ssc2018.dqb.Draw;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ssc2018.dqb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xrc on 2017/12/15.
 */

public class LotterResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private static final int TYPE_FOOT = 0;  //足球篮球
    private static final int TYPE_THREEELENEN = 1; //数字彩
    private List<LotterNoticeBean> datas = new ArrayList<>();
    private List<DetailsCheckBean> listjiang = new ArrayList<>();

    public LotterResultAdapter(Activity context, List<LotterNoticeBean> datas) {
        this.datas = datas;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = getViewHolderByViewType(viewType);
        return holder;
    }

    private RecyclerView.ViewHolder getViewHolderByViewType(int viewType) {
        View view_basekefoot = View.inflate(mContext, R.layout.item_lottery_footbasket, null);
        View view_threeElev = View.inflate(mContext, R.layout.item_lottery_threeleven, null);
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case TYPE_FOOT:
                holder = new ViewHolder_FB(view_basekefoot);//篮球足球显示view
                break;
            case TYPE_THREEELENEN:
                holder = new ViewHolder_TE(view_threeElev); //数字彩
                break;
        }
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        LotterNoticeBean bean = datas.get(position);
        if (null != bean) {
            if (bean.getGame_type().equals("jclq") || bean.getGame_type().equals("jczq") ||
                    bean.getGame_type().equals("bjdc") || bean.getGame_type().equals("sfgg")) {
                return TYPE_FOOT;
            } else {
                return TYPE_THREEELENEN;
            }
        }
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        int width = manager.getDefaultDisplay().getWidth();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = DeviceUtils.dip2px(mContext, 10);

        if (holder != null) {
            int itemViewType = getItemViewType(position);
            switch (itemViewType) {
                case TYPE_FOOT:
                    ViewHolder_FB fb_holder = (ViewHolder_FB) holder;
                    fb_holder.item_Bg.setLayoutParams(layoutParams);
                    if (datas.get(position).getGame_type().equals("jclq") || datas.get(position).getGame_type().equals("sfgg")) {
                        if (datas.get(position).getGame_type().equals("jclq")) {
                            //fb_holder.lotter_rebg.setBackground(mContext.getResources().getDrawable(R.mipmap.basketball_kaijiang));
                        } else {
                            //fb_holder.lotter_rebg.setBackground(mContext.getResources().getDrawable(R.mipmap.sfgg));
                        }
                        fb_holder.lotter_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.result_baskicon));

                        JsonObject jsonObject = datas.get(position).getGame_result();
                        Gson gson = new Gson();
                        LotterBasketBean basketBean = gson.fromJson(jsonObject.toString(), LotterBasketBean.class);
                        fb_holder.jc_name.setText("竞彩篮球");
                        fb_holder.jc_time.setText(basketBean.getGameTime());
                        String[] teams = basketBean.getHostAndTeam().split("VS");
                        fb_holder.item_bf.setText(teams[0] + "  " + basketBean.getJclq_bf() + "  " + teams[1]);
                    } else if (datas.get(position).getGame_type().equals("jczq") || datas.get(position).getGame_type().equals("bjdc")) {
                        if (datas.get(position).getGame_type().equals("jczq")) {
                            //fb_holder.lotter_rebg.setBackground(mContext.getResources().getDrawable(R.mipmap.jzdchang));
                        } else {
                            //fb_holder.lotter_rebg.setBackground(mContext.getResources().getDrawable(R.mipmap.bjdc));
                        }
                        fb_holder.lotter_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.result_footicon));

                        JsonObject jsonObject = datas.get(position).getGame_result();
                        Gson gson = new Gson();
                        LotterFootBean footBean = gson.fromJson(jsonObject.toString(), LotterFootBean.class);
                        fb_holder.jc_name.setText("竞彩足球");
                        fb_holder.jc_time.setText(footBean.getGameTime());
                        String[] teams = footBean.getHostAndTeam().split("VS");
                        fb_holder.item_bf.setText(teams[0] + "  " + footBean.getJczq_bf() + "  " + teams[1]);
                    }
                    break;
                case TYPE_THREEELENEN:
                    ViewHolder_TE te_holder = (ViewHolder_TE) holder;
                    if (position == datas.size() - 1) {
                        te_holder.lotter_lineTv.setVisibility(View.GONE);
                    }
                    te_holder.item_bg.setLayoutParams(layoutParams);

                    JsonObject jsonObject = datas.get(position).getGame_result();
                    Gson gson = new Gson();
                    ThreeEResultBean resultBean = gson.fromJson(jsonObject.toString(), ThreeEResultBean.class);
                    te_holder.jc_time.setText("第" + resultBean.getIssue() + "期  " + resultBean.getDateline());
                    boolean is_red = false;
                    if (datas.get(position).getGame_type().equals("ThreeD")) {
                        te_holder.jc_name.setText("福彩3D");
                        is_red = false;
                    } else if (datas.get(position).getGame_type().equals("ChooseFive")) {
                        te_holder.jc_name.setText("11选5");
                        is_red = false;
                    } else if (datas.get(position).getGame_type().equals("ArrayThree")) {
                        te_holder.jc_name.setText("排列三");
                        is_red = false;
                    } else if (datas.get(position).getGame_type().equals("ArrayFive")) {
                        te_holder.jc_name.setText("排列五");
                        is_red = false;
                    } else if (datas.get(position).getGame_type().equals("lotto")) {
                        te_holder.jc_name.setText("双色球");
                        is_red = true;
                    } else if (datas.get(position).getGame_type().equals("excel")) {
                        te_holder.jc_name.setText("大乐透");
                        is_red = true;
                    }
                    listjiang.clear();
                    if (is_red) {
                        String[] lablese = resultBean.getWinnum().split(",");
                        String[] reds = lablese[0].split(" ");
                        String[] blues = lablese[1].split(" ");
                        kaijiangAddDate(reds, false);
                        kaijiangAddDate(blues, true);
                    } else {
                        String[] lablese = resultBean.getWinnum().replace(" ", ",").split(",");
                        kaijiangAddDate(lablese, false);
                    }
                    te_holder.contentVie.removeAllViews();
                    for (int i = 0; i < listjiang.size(); i++) {
                        final TextView textview = new TextView(mContext);
                        textview.setHeight(DeviceUtils.dip2px(mContext, 35));
                        textview.setWidth(DeviceUtils.dip2px(mContext, 35));
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
                        te_holder.contentVie.addView(textview);
                    }
                    break;
            }
            if (myViewHolerClicks != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String type = datas.get(position).getGame_type();
                        JsonObject jsonObject = datas.get(position).getGame_result();
                        Gson gson = new Gson();
                        ThreeEResultBean resultBean = gson.fromJson(jsonObject.toString(), ThreeEResultBean.class);
                        String url = resultBean.getUrl();
                        myViewHolerClicks.onItemClick(position, type, url);
                    }
                });
            }
        }
    }

    private void kaijiangAddDate(String[] lablese, boolean red_blue) {
        for (int i = 0; i < lablese.length; i++) {
            DetailsCheckBean bean = new DetailsCheckBean();
            bean.setNumber(lablese[i]);
            bean.setRed_blue(red_blue);
            listjiang.add(bean);
        }
    }

    @Override
    public int getItemCount() {
        Log.e("1111","datas="+datas);
        return datas.size();

    }


    class ViewHolder_FB extends RecyclerView.ViewHolder {
        public RelativeLayout lotter_rebg;
        public LinearLayout item_Bg;
        public ImageView lotter_img;
        public TextView lotter_lineTv;
        public TextView jc_name;
        public TextView jc_time;
        public TextView item_bf;

        public ViewHolder_FB(View itemView) {
            super(itemView);
            lotter_rebg = (RelativeLayout) itemView.findViewById(R.id.lotter_rebg);
            item_Bg = (LinearLayout) itemView.findViewById(R.id.item_Bg);
            lotter_img = (ImageView) itemView.findViewById(R.id.lotter_img);
            lotter_lineTv = (TextView) itemView.findViewById(R.id.lotter_lineTv);
            jc_name = (TextView) itemView.findViewById(R.id.jc_name);
            jc_time = (TextView) itemView.findViewById(R.id.jc_time);
            item_bf = (TextView) itemView.findViewById(R.id.item_bf);
        }
    }

    class ViewHolder_TE extends RecyclerView.ViewHolder {
        public TextView jc_name, jc_time, lotter_lineTv;
        private LinearLayout item_bg;
        public AutoLineFeedLayout contentVie;

        public ViewHolder_TE(View itemView) {
            super(itemView);
            lotter_lineTv = (TextView) itemView.findViewById(R.id.lotter_lineTv);
            jc_name = (TextView) itemView.findViewById(R.id.jc_name);
            jc_time = (TextView) itemView.findViewById(R.id.jc_time);
            item_bg = (LinearLayout) itemView.findViewById(R.id.item_bg);
            contentVie = (AutoLineFeedLayout) itemView.findViewById(R.id.contentVie);
        }
    }

    public MyViewHolerClicks myViewHolerClicks;


    /**
     * 供外部Activity调用的点击事件
     *
     * @param myViewHolerClicks
     */
    public void setMyViewHolerClicks(MyViewHolerClicks myViewHolerClicks) {
        this.myViewHolerClicks = myViewHolerClicks;
    }

    /**
     * 定义按钮的点击事件的方法
     */
    public interface MyViewHolerClicks {
        //item的点击事件
        void onItemClick(int position, String type, String url);
    }

}
