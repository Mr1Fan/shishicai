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
import com.ssc2018.dqb.view.RedNumberView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MrXu on 2017/12/27 13:53
 * 邮箱：17610872621@163.com
 */
public class QiLeCaiActivity extends Activity implements BaseRecyclerAdapter.Delegate,SensorEventListener{

    private TextView select_hint, at_leastTv;
    private LinearLayout kjh_visible;
    private ImageView up_downImg;
    private RecyclerView kjh_recyc;
    private RedNumberView red_view;
    private List<KaiJiangBean> benaList = new ArrayList<>();
    private boolean is_visble = false;

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
    public List<Integer> lists = new ArrayList<>();
    List<String> rlist = new ArrayList<String>();  //计算结果的list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        findView();
        if(getIntent().getBooleanExtra("is_show",false)){
            ToastUtils.show("摇一摇幸运选一注吧!",QiLeCaiActivity.this);
        }
    }
    public void initData() {
        KaiJiangBean bena1 = new KaiJiangBean("121期", "02 07 09 11 19 21 23");
        KaiJiangBean bena2 = new KaiJiangBean("120期", "02 03 18 19 23 30 23");
        KaiJiangBean bena3 = new KaiJiangBean("119期", "07 09 12 19 26 27 29");
        KaiJiangBean bena4 = new KaiJiangBean("118期", "02 03 07 11 17 26 28");
        KaiJiangBean bena5 = new KaiJiangBean("117期", "02 08 09 12 20 21 23");
        KaiJiangBean bena6 = new KaiJiangBean("116期", "04 01 09 10 12 22 27");
        KaiJiangBean bena7 = new KaiJiangBean("115期", "09 02 20 32 30 21 23");
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

    @Override
    public void onStart() {
        super.onStart();
        //获取 SensorManager 负责管理传感器
        mSensorManager = ((SensorManager) getSystemService(SENSOR_SERVICE));
        if (mSensorManager != null) {
            //获取加速度传感器
            mAccelerometerSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (mAccelerometerSensor != null) {

                 mSensorManager.registerListener(QiLeCaiActivity.this, mAccelerometerSensor, SensorManager.SENSOR_DELAY_UI);
    //            mSensorManager.registerListener((SensorEventListener) QiLeCaiActivity.this, mAccelerometerSensor, SensorManager.SENSOR_DELAY_UI);
            }
        }
    }
    /**
     * 摇一摇监听事件
     *
     * @param event
     */
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
            randomSelect(7);
            mVibrator.vibrate(300); //设置震动
            isShake = false;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    /**
     * 设置随机数
     */
    public void randomSelect(int nums) {
        lists.clear();
        List<Integer> positio = RandomNumUtils.randomArray(1, 30, nums);
        red_view.setRandowCheck(positio, true, false, true);
        for (int i = 0; i < positio.size(); i++) {
            lists.add(positio.get(i));
        }
        CountBetM(7);
    }

    /**
     * 计算多少注,多少钱
     */
    private void CountBetM(int randow_num) {
        rlist.clear();
        String timps = "";
        rlist = ThreeECountUtils.CountZsixBets(0, randow_num, lists, timps, rlist);
        zhushu = rlist.size();
        bet_moneys = zhushu * 2;
        playZhumoney(zhushu, bet_moneys);
    }
    private void playZhumoney(Integer zhu, Integer money) {
        String betmon = zhu + "注" + "  " + "<html><body><font color='#dcb029'>" + money
                + "元</font></body></html>";
        select_hint.setText(Html.fromHtml(betmon));
    }

    public void findView() {

        red_view = (RedNumberView) findViewById(R.id.red_view);
        red_view.setList(31, false, 6);

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ((TextView) findViewById(R.id.title)).setText("七乐彩");
        kjh_visible = (LinearLayout) findViewById(R.id.kjh_visible);
        up_downImg = (ImageView) findViewById(R.id.up_downImg);
        at_leastTv = (TextView) findViewById(R.id.at_leastTv);
        select_hint= (TextView) findViewById(R.id.select_hint);
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

         /*摇一摇的点击事件*/
//        findViewById(R.id.yaoyiyao_selectImg).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                randomSelect(7);
//            }
//        });

        red_view.setChangeListener(new RedNumberView.OnDataChangeListener() {
            @Override
            public void onChange(ArrayList<Integer> selectBall) {
                lists = selectBall;
                CountBetM(7);
            }
        });

        findViewById(R.id.confirm_bet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show("根据相关法律法规，线上暂不允许购彩，请到各大线下网点投注", QiLeCaiActivity.this);
            }
        });
        initData();

    }

    public int getContentView() {
        return R.layout.qilecai_layout;
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
