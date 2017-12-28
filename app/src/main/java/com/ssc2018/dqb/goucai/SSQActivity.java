package com.ssc2018.dqb.goucai;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
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
import com.ssc2018.dqb.utils.RandomNumUtils;
import com.ssc2018.dqb.utils.ThreeECountUtils;
import com.ssc2018.dqb.utils.ToastUtils;
import com.ssc2018.dqb.view.BlueNumberView;
import com.ssc2018.dqb.view.RedNumberView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MrXu on 2017/12/27 13:39
 * 邮箱：17610872621@163.com
 */
public class SSQActivity extends Activity implements BaseRecyclerAdapter.Delegate,SensorEventListener {
    private RedNumberView red_view;
    private BlueNumberView blue_view;
    private TextView select_hint, at_leastTv;
    private LinearLayout kjh_visible;
    private ImageView up_downImg;
    private RecyclerView kjh_recyc;
    private List<KaiJiangBean> benaList = new ArrayList<>();
    private boolean is_visble = false;
    private List<Integer> red_list = new ArrayList<>();
    private List<Integer> blue_list = new ArrayList<>();

    protected SensorManager mSensorManager;  //传感器管理服对象
    protected Sensor mAccelerometerSensor;
    protected Vibrator mVibrator;//手机震动
    //记录摇动状态
    protected boolean isShake = false;
    // 两次检测的时间间隔
    protected static final int UPTATE_INTERVAL_TIME = 300;
    // 上次检测时间
    protected long lastUpdateTime;
    private Integer zhushu = 0, bet_moneys = 0;
    private List<String> rlist = new ArrayList<>();  //选择红球的结果值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_union_lotton);
        findView();
        if(getIntent().getBooleanExtra("is_show",false)){
            ToastUtils.show("摇一摇幸运选一注吧!",SSQActivity.this);
        }
    }
    public void initData() {
        KaiJiangBean bena1 = new KaiJiangBean("111期", "02 12 14 17 26 34 08 12");
        KaiJiangBean bena2 = new KaiJiangBean("110期", "10 14 20 21 35 02 02 05");
        KaiJiangBean bena3 = new KaiJiangBean("109期", "06 09 19 26 26 34 05 07");
        KaiJiangBean bena4 = new KaiJiangBean("108期", "01 04 14 17 26 34 08 12");
        KaiJiangBean bena5 = new KaiJiangBean("107期", "02 12 14 17 26 34 08 12");
        KaiJiangBean bena6 = new KaiJiangBean("106期", "02 12 14 17 26 34 08 12");
        KaiJiangBean bena7 = new KaiJiangBean("105期", "02 12 14 17 26 34 08 12");
        benaList.add(bena1);
        benaList.add(bena2);
        benaList.add(bena3);
        benaList.add(bena4);
        benaList.add(bena5);
        benaList.add(bena6);
        benaList.add(bena7);

        BaseRecyclerAdapter adapter = new BaseRecyclerAdapter(this, this);
        kjh_recyc.setAdapter(adapter);

        //获取Vibrator震动服务
        mVibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }
    public void findView() {
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ((TextView) findViewById(R.id.title)).setText("双色球");
        kjh_visible = (LinearLayout) findViewById(R.id.kjh_visible);
        up_downImg = (ImageView) findViewById(R.id.up_downImg);
        at_leastTv = (TextView) findViewById(R.id.at_leastTv);
        select_hint= (TextView) findViewById(R.id.select_hint);
        String play = "至少选择5个<html><body><font color='#e1261d'>" + "红球" + "</font></body></html>" +
                "2个<html><body><font color='#348fff'>" + "篮球" + "</font></body></html>";
        at_leastTv.setText(Html.fromHtml(play));

        red_view = (RedNumberView) findViewById(R.id.red_view);
        red_view.setList(34, false, 7);
        blue_view = (BlueNumberView) findViewById(R.id.blue_view);
        blue_view.setList(17);

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

        red_view.setChangeListener(new RedNumberView.OnDataChangeListener() {
            @Override
            public void onChange(ArrayList<Integer> selectBall) {
                red_list = selectBall;
                countRedNum();
                CountBetM();
            }
        });
        blue_view.setChangeListener(new BlueNumberView.OnDataChangeListener() {
            @Override
            public void onChange(ArrayList<Integer> selectBall) {
                blue_list = selectBall;
                CountBetM();
            }
        });
          /*摇一摇的点击事件*/
        findViewById(R.id.confirm_bet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomSelect();
            }
        });

//        /*摇一摇的点击事件*/
//        findViewById(R.id.confirm_bet).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                randomSelect();
//            }
//        });
        initData();
    }

    @Override
    public void onStart() {
        super.onStart();
        //获取 SensorManager 负责管理传感器
        mSensorManager = ((SensorManager) getSystemService(SENSOR_SERVICE));
        if (mSensorManager != null) {
            //获取加速度传感器
            mAccelerometerSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (mAccelerometerSensor != null) {
                mSensorManager.registerListener(SSQActivity.this, mAccelerometerSensor, SensorManager.SENSOR_DELAY_UI);
            }
        }
    }

    /**
     * 摇一摇监听事件
     *
     * @param event
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        long currentUpdateTime = System.currentTimeMillis();
        long timeInterval = currentUpdateTime - lastUpdateTime;
        if (timeInterval < UPTATE_INTERVAL_TIME)
            return;
        lastUpdateTime = currentUpdateTime;
        float[] values = event.values;
        float x = Math.abs(values[0]);
        float y = Math.abs(values[1]);
        float z = Math.abs(values[2]);

        if (x >= 17 || y >= 17 || z >= 17 && !isShake) {
            isShake = true;
            randomSelect();
            mVibrator.vibrate(300); //设置震动
            isShake = false;
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /**
     * 设置随机数
     */
    public void randomSelect() {
        blue_list.clear();
        red_list.clear();

        List<Integer> red_positio = RandomNumUtils.randomArray(1, 33, 6);
        red_view.setRandowCheck(red_positio, true,false,true);
        for (int i = 0; i < red_positio.size(); i++) {
            red_list.add(red_positio.get(i));
        }

        List<Integer> blue_pos = RandomNumUtils.randomArray(1, 16, 1);
        blue_view.setRandowCheck(blue_pos, true);
        for (int i = 0; i < blue_pos.size(); i++) {
            blue_list.add(blue_pos.get(i));
        }
//        ToastUtils.show("根据相关法律法规，线上暂不允许购彩，请到各大线下网点投注", SSQActivity.this);
        countRedNum();
        CountBetM();
    }

    /**
     * 计算多少注,多少钱
     */
    private void CountBetM() {
        bet_moneys = 0;
        if (blue_list.size() == 1) {
            zhushu = rlist.size();
        } else if (blue_list.size() > 1) {
            zhushu = rlist.size() * blue_list.size();
        } else {
            zhushu = 0;
        }
        bet_moneys = zhushu * 2;
        playZhumoney(zhushu, bet_moneys);
    }

    //计算红球的个数
    private void countRedNum() {
        String timps = "";
        rlist.clear();
        rlist = ThreeECountUtils.CountZsixBets(0, 6, red_list, timps, rlist);
    }

    private void playZhumoney(Integer zhu, Integer money) {
        String betmon = zhu + "注" + "  " + "<html><body><font color='#dcb029'>" + money
                + "元</font></body></html>";
        select_hint.setText(Html.fromHtml(betmon));
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
