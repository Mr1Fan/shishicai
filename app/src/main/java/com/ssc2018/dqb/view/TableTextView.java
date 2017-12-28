package com.ssc2018.dqb.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;

import com.ssc2018.dqb.Draw.DeviceUtils;
import com.ssc2018.dqb.R;

/**
 * 作者：Mr.xu on 2017/12/12 12:05
 * 邮箱：17610872621@163.com
 */
public class TableTextView extends AppCompatTextView implements View.OnClickListener {
    private Paint paint_1 = new Paint();
    private Paint paint_2 = new Paint();

    private Context mContext;
    private AttributeSet mAttrs;

    private int flag_line_up;
    private int flag_line_down;
    private int flag_line_left;
    private int flag_line_right;

    private boolean isClick;
    private boolean checked;

    public TableTextView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public TableTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mAttrs = attrs;
        init();
    }

    public TableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mAttrs = attrs;
        init();
    }

    private void init(){

        if (mAttrs != null){
            // 0:无线条   1:虚线   2:实线
            TypedArray ta = mContext.obtainStyledAttributes(mAttrs, R.styleable.TableTextView);
            flag_line_up = ta.getInteger(R.styleable.TableTextView_up_line,0);
            flag_line_down = ta.getInteger(R.styleable.TableTextView_down_line,0);
            flag_line_left = ta.getInteger(R.styleable.TableTextView_left_line,0);
            flag_line_right = ta.getInteger(R.styleable.TableTextView_right_line,0);
            isClick = ta.getBoolean(R.styleable.TableTextView_isClick,false);
            checked = ta.getBoolean(R.styleable.TableTextView_checked,false);
        }

        DashPathEffect pathEffect = new DashPathEffect(new float[] { 7,3 }, 0);
        paint_1.reset();
        paint_1.setStyle(Paint.Style.STROKE);
        paint_1.setStrokeWidth(DeviceUtils.dip2px(mContext,1));
        paint_1.setColor(Color.parseColor("#e2e2e2"));
        paint_1.setAntiAlias(true);
        paint_1.setPathEffect(pathEffect);

        paint_2.setColor(Color.parseColor("#e2e2e2"));
        paint_2.setStyle(Paint.Style.STROKE);
        paint_2.setStrokeWidth(DeviceUtils.dip2px(mContext,1));
        paint_2.setAntiAlias(true);

        if (isClick){
            setOnClickListener(this);
        }

        setChecked(checked);
    }

    public void setChecked(boolean isChecked){
        if (isChecked){
            setTextColor(getResources().getColor(R.color.white));
            setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            setTag(R.id.isChecked,true);
            checked = true;
        }else{
            setTextColor(getResources().getColor(R.color.black_666));
            setBackgroundColor(getResources().getColor(R.color.white));
            setTag(R.id.isChecked,null);
            checked = false;
        }
    }

    public boolean isChecked() {
        return checked;
    }


    private OnClickListener listener;

    public void setOnClick(OnClickListener listener){
        this.listener = listener;
    }

    //0:无线条   1:虚线   2:实线
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画TextView的4个边
        switch (flag_line_up){
            case 1:
                Path path = new Path();
                path.moveTo(0,0);
                path.lineTo(this.getWidth() - 1,0);
                canvas.drawPath(path,paint_1);
                break;
            case 2:
                canvas.drawLine(0, 0, this.getWidth() - 1, 0, paint_2);
                break;
        }

        switch (flag_line_down){
            case 1:
                Path path = new Path();
                path.moveTo(0,this.getHeight() - 1);
                path.lineTo(this.getWidth() - 1,this.getHeight() - 1);
                canvas.drawPath(path,paint_1);
                break;
            case 2:
                canvas.drawLine(0, this.getHeight() - 1, this.getWidth() - 1, this.getHeight() - 1, paint_2);
                break;
        }

        switch (flag_line_left){
            case 1:
                Path path = new Path();
                path.moveTo(0,DeviceUtils.dip2px(mContext,8));
                path.lineTo(0,this.getHeight() - 1 - DeviceUtils.dip2px(mContext,8));
                canvas.drawPath(path,paint_1);
                break;
            case 2:
                canvas.drawLine(0, 0, 0, this.getHeight() - 1, paint_2);
                break;
        }

        switch (flag_line_right){
            case 1:
                Path path = new Path();
                path.moveTo(this.getWidth() - 1, DeviceUtils.dip2px(mContext,8));
                path.lineTo(this.getWidth() - 1, this.getHeight() - 1 - DeviceUtils.dip2px(mContext,8));
                canvas.drawPath(path,paint_1);
                break;
            case 2:
                canvas.drawLine(this.getWidth() - 1, 0, this.getWidth() - 1, this.getHeight() - 1, paint_2);
                break;
        }
    }

    public void setFlag_line_up(int flag_line_up) {
        this.flag_line_up = flag_line_up;
    }

    public void setFlag_line_down(int flag_line_down) {
        this.flag_line_down = flag_line_down;
    }

    @Override
    public void onClick(View v) {
        setChecked(!checked);
        if (listener!=null){
            listener.onClick(v);
        }
    }
}
