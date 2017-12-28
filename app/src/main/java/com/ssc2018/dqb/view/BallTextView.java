package com.ssc2018.dqb.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;

import com.ssc2018.dqb.R;
import com.ssc2018.dqb.utils.LogUtils;

/**
 * 作者：MrXu on 2017/12/27 13:42
 * 邮箱：17610872621@163.com
 */
public class BallTextView extends AppCompatTextView implements View.OnClickListener {
    private Context mContext;
    private AttributeSet mAttrs;

    /** 1是红球, 2是篮球 */
    private int ballType;
    private boolean checked;

    private OnClickListener listener;
    public BallTextView(Context context) {
        super(context);
        init();
    }

    public BallTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mAttrs = attrs;
        init();
    }

    public BallTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mAttrs = attrs;
        init();
    }

    private void init(){
        TypedArray ta = mContext.obtainStyledAttributes(mAttrs, R.styleable.BallTextView);
        ballType = ta.getInteger(R.styleable.BallTextView_BallType,1);
        checked = ta.getBoolean(R.styleable.BallTextView_checked,false);
        setChecked(checked);
        setOnClickListener(this);
    }

    public void setChecked(boolean isChecked){

        LogUtils.i(getText().toString()+"***"+isChecked);

        if (isChecked){
            if (ballType == 1){
                setTextColor(getResources().getColor(R.color.white));
                setBackground(getResources().getDrawable(R.drawable.red_select_circle_bg));
            }else if (ballType == 2){
                setTextColor(getResources().getColor(R.color.white));
                setBackground(getResources().getDrawable(R.drawable.blue_select_circle_bg));
            }
            checked = true;
        }else{
            if (ballType == 1){
                setTextColor(getResources().getColor(R.color.colorPrimary));
                setBackground(getResources().getDrawable(R.drawable.red_normal_circle_bg));
            }else if (ballType == 2){
                setTextColor(getResources().getColor(R.color.basket_blue));
                setBackground(getResources().getDrawable(R.drawable.blue_normal_circle_bg));
            }
            checked = false;
        }
    }

    public boolean isChecked(){
        return checked;
    }
    @Override
    public void onClick(View v) {
        setChecked(!checked);
        if (listener!=null){
            listener.onClick(v);
        }
    }
    public void setClickListener(OnClickListener listener){
        this.listener = listener;
    }
}
