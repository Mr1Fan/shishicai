package com.ssc2018.dqb.view;

/**
 * 作者：MrXu on 2017/12/27 13:40
 * 邮箱：17610872621@163.com
 */

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ssc2018.dqb.adapter.BaseRecyclerAdapter;
import com.ssc2018.dqb.adapter.RecyclerViewHolder;
import com.ssc2018.dqb.R;
import com.ssc2018.dqb.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 双色球  红色球  布局 view
 */
public class RedNumberView extends LinearLayout implements BaseRecyclerAdapter.Delegate{
    private Context mContext;
    private RecyclerView recyclerView;
    private OnDataChangeListener changeListener;
    private List<String> list = new ArrayList<>();
    private List<String> louhaolist = new ArrayList<>();
    private Integer hang_nums = 0;
    private GridLayoutManager manager;
    private BaseRecyclerAdapter adapter;


    public RedNumberView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }
    public RedNumberView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }
    /**
     * @param nums      设置显示多少个数字
     * @param is_zero   是否是从0开始,如0-9 /01-11
     * @param hang_nums 每行显示几个数字
     */
    public void setList(Integer nums, boolean is_zero, int hang_nums) {
        list.clear();
        this.hang_nums = hang_nums;
        if (is_zero) {
            for (int i = 0; i < nums; i++) {
                list.add(i + "");
            }
        } else {
            for (int i = 1; i < nums; i++) {
                if (i < 10) {
                    list.add("0" + i);
                } else {
                    list.add(i + "");
                }
            }
        }
        manager = new GridLayoutManager(mContext, hang_nums);
        recyclerView.setLayoutManager(manager);
        adapter = new BaseRecyclerAdapter(mContext, this);
        recyclerView.setAdapter(adapter);
    }
    /**
     * 设置漏号的数据
     *
     * @param louhaolist
     */
    public void setLouhaolist(List<String> louhaolist) {
        this.louhaolist = louhaolist;
        adapter.notifyDataSetChanged();
    }

    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.union_lotto_common, this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }
    /**
     * 获取选中的值
     */
    private void printNumber() {
        ArrayList<Integer> selectBall = new ArrayList<>();
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            LinearLayout linearLayout = (LinearLayout) manager.getChildAt(i);
            BallTextView ballTextView = (BallTextView) linearLayout.getChildAt(0);
            if (ballTextView.isChecked()) {
                selectBall.add(Integer.valueOf(ballTextView.getText().toString()));
            }
        }
        if (changeListener != null) {
            changeListener.onChange(selectBall);
        }
    }
    private OnClickListener listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            int count = 0;
            for (int i = 0; i < recyclerView.getChildCount(); i++) {
                LinearLayout linearLayout = (LinearLayout) manager.getChildAt(i);
                BallTextView ballTextView = (BallTextView) linearLayout.getChildAt(0);
                if (ballTextView.isChecked()) {
                    count += 1;
                }
            }
            if (count > 18) {
                BallTextView view = (BallTextView) v;
                view.setChecked(false);
                ToastUtils.show("最多投注18个红球", getContext());
            } else {
                printNumber();
            }
        }
    };
    public void setChangeListener(OnDataChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    @Override
    public List<String> getData() {
        return list;
    }

    @Override
    public int getView(ViewGroup parent, int viewType) {
        return R.layout.item_red_union;
    }

    @Override
    public <T> void bindView(RecyclerViewHolder holder, int position, T item) {
        BallTextView rednumTv = (BallTextView) holder.getView(R.id.rednumTv);
        TextView louhaoTv = (TextView) holder.getView(R.id.louhaoTv);
        rednumTv.setText(list.get(position));
        if (louhaolist.size() != 0) {
            louhaoTv.setVisibility(VISIBLE);
            String louhao = louhaolist.get(position);
            louhaoTv.setText(louhao);
        } else {
            louhaoTv.setVisibility(GONE);
        }
        rednumTv.setClickListener(listener);
    }
    public interface OnDataChangeListener {
        void onChange(ArrayList<Integer> selectBall);
    }

    /**
     * 设置随机选中
     *
     * @param list     设置为false的集合
     * @param is_check 设置为true ,还是false
     * @param is_zero  是否从0开始
     */
    public void setRandowCheck(List<Integer> list, boolean is_check, boolean is_zero, boolean is_need_clear) {
        if (is_need_clear) {
            clearChecked();
        }
        for (int i = 0; i < list.size(); i++) {
            int posi = 0;
            if (is_zero) {
                posi = list.get(i);
            } else {
                posi = list.get(i) - 1;
            }
            LinearLayout linearLayout = (LinearLayout) manager.getChildAt(posi);
            if (null != linearLayout) {
                BallTextView ballTextView = (BallTextView) linearLayout.getChildAt(0);
                ballTextView.setChecked(is_check);
            }
        }
    }

    /**
     * 清空选项
     */
    public void clearChecked() {
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            LinearLayout linearLayout = (LinearLayout) manager.getChildAt(i);
            BallTextView ballTextView = (BallTextView) linearLayout.getChildAt(0);
            ballTextView.setChecked(false);
        }
    }
    /**
     * 隐藏漏号
     */
    public void setYincangLouhao(int visble) {
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            LinearLayout linearLayout = (LinearLayout) manager.getChildAt(i);
            TextView textView = (TextView) linearLayout.getChildAt(1);
            textView.setVisibility(visble);
        }
    }
}
