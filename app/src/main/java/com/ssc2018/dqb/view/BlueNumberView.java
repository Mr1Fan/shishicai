package com.ssc2018.dqb.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ssc2018.dqb.adapter.BaseRecyclerAdapter;
import com.ssc2018.dqb.adapter.RecyclerViewHolder;
import com.ssc2018.dqb.R;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MrXu on 2017/12/27 13:45
 * 邮箱：17610872621@163.com
 */
public class BlueNumberView extends LinearLayout implements BaseRecyclerAdapter.Delegate{
//    LogE TAG
    private final String TAG = "BlueNnv";
    private Context mContext;
    private RecyclerView recyclerView;
    private OnDataChangeListener changeListener;
    private List<String> list = new ArrayList<>();
    private Integer nums = 0;
    private GridLayoutManager manager;


    public BlueNumberView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }
    public BlueNumberView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }
    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.union_lotto_common, this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        manager = new GridLayoutManager(mContext, 7);
        recyclerView.setLayoutManager(manager);
    }
    private void printNumber() {
        ArrayList<Integer> selectBall = new ArrayList<>();
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            BallTextView ballTextView = (BallTextView) recyclerView.getChildAt(i);
            if (ballTextView.isChecked()) {
                selectBall.add(Integer.valueOf(ballTextView.getText().toString()));
            }
        }
        if (changeListener != null) {
            changeListener.onChange(selectBall);
        }
    }
    public void setList(Integer nums) {
        this.nums = nums;

        for (int i = 1; i < nums; i++) {
            if (i < 10) {
                list.add("0" + i);
            } else {
                list.add(i + "");
            }
        }
        BaseRecyclerAdapter adapter = new BaseRecyclerAdapter(mContext, this);
        recyclerView.setAdapter(adapter);
    }
    private OnClickListener listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            printNumber();
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
        return R.layout.item_blue_union;
    }

    @Override
    public <T> void bindView(RecyclerViewHolder holder, int position, T item) {
        BallTextView rednumTv = (BallTextView) holder.getView(R.id.rednumTv);
        rednumTv.setText(list.get(position));
        rednumTv.setClickListener(listener);
    }
    public interface OnDataChangeListener {
        public void onChange(ArrayList<Integer> selectBall);
    }

    /**
     * 设置随机选中
     *
     * @param postion
     */
    public void setRandowCheck(List<Integer> postion, boolean is_check) {
        clearChecked();
        for (int i = 0; i < postion.size(); i++) {
            BallTextView ballTextView = (BallTextView) recyclerView.getChildAt(postion.get(i) - 1);
            ballTextView.setChecked(is_check);
            Log.e(TAG, "setRandowCheck: ");

        }
    }

    /**
     * 清空选项
     */
    public void clearChecked() {
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            BallTextView ballTextView = (BallTextView) recyclerView.getChildAt(i);
            ballTextView.setChecked(false);
        }
    }

}
