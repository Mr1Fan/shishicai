package com.ssc2018.dqb.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;


import com.ssc2018.dqb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Mr.xu on 2017/12/21 11:41
 * 邮箱：17610872621@163.com
 */
public class ThreeDNumberView extends LinearLayout {
    private Context mContext;
    private LinearLayout ball_ll_1;
    private LinearLayout ball_ll_2;
    private OnDataChangeListener changeListener;

    public ThreeDNumberView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public ThreeDNumberView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.three_d_items_comon,this);
        ball_ll_1 = (LinearLayout) findViewById(R.id.ball_ll_1);
        ball_ll_2 = (LinearLayout) findViewById(R.id.ball_ll_2);

        for (int i = 0; i < ball_ll_1.getChildCount(); i++) {
            BallTextView ballTextView = (BallTextView) ball_ll_1.getChildAt(i);
            ballTextView.setClickListener(listener);
        }
        for (int i = 0; i < ball_ll_2.getChildCount(); i++) {
            BallTextView ballTextView = (BallTextView) ball_ll_2.getChildAt(i);
            ballTextView.setClickListener(listener);
        }
    }

    private void printNumber() {
        ArrayList<Integer> selectBall = new ArrayList<>();
        for (int i = 0; i < ball_ll_1.getChildCount(); i++) {
            BallTextView ballTextView = (BallTextView) ball_ll_1.getChildAt(i);
            if (ballTextView.isChecked()) {
                selectBall.add(Integer.valueOf(ballTextView.getText().toString()));
            }
        }
        for (int i = 0; i < ball_ll_2.getChildCount(); i++) {
            BallTextView ballTextView = (BallTextView) ball_ll_2.getChildAt(i);
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
            printNumber();
        }
    };

    public void setChangeListener(OnDataChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    public interface OnDataChangeListener {
        public void onChange(ArrayList<Integer> selectBall);
    }

    /**
     * 设置随机选中
     *
     * @param postion
     */
    public void setRandowCheck(List<Integer> postion) {
        clearChecked();
        for (int i = 0; i < postion.size(); i++) {
            if (postion.get(i) >= 0 && postion.get(i) <= 4) {
                BallTextView ballTextView = (BallTextView) ball_ll_1.getChildAt(postion.get(i));
                ballTextView.setChecked(true);
            }
        }

        for (int i = 0; i < postion.size(); i++) {
            if (postion.get(i) >= 5 && postion.get(i) <= 9) {
                BallTextView ballTextView = (BallTextView) ball_ll_2.getChildAt(postion.get(i) - 5);
                ballTextView.setChecked(true);
            }
        }
    }

    /**
     * 清空选项
     */
    public void clearChecked() {
        for (int i = 0; i < ball_ll_1.getChildCount(); i++) {
            BallTextView ballTextView = (BallTextView) ball_ll_1.getChildAt(i);
            ballTextView.setChecked(false);
        }
        for (int i = 0; i < ball_ll_2.getChildCount(); i++) {
            BallTextView ballTextView = (BallTextView) ball_ll_2.getChildAt(i);
            ballTextView.setChecked(false);
        }
    }
}
