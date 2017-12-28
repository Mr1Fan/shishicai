package com.ssc2018.dqb;

import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aar.webview.WebViewActivity;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.ssc2018.dqb.activity.FKActivity;
import com.ssc2018.dqb.activity.PersonInfoActivity;
import com.ssc2018.dqb.activity.SettingActivity;
import com.ssc2018.dqb.activity.WanFaShuoMingActivity;
import com.ssc2018.dqb.fragment.ZhiBoFragment;
import com.ssc2018.dqb.shouye.ShouyeActivity;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public ActionBarDrawerToggle drawerToggle;
    public DrawerLayout drawerLayout;
    public FragmentManager fragmentManager;
    public FrameLayout frameLayout;
    public static int index = 0;
    private ImageView wenhaoImg;

    private FragmentTransaction transaction;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView toolbar_title;
    //直播
    private ZhiBoFragment zhiBoFragment;
    // 首页的Fragment
    private ShouyeActivity shouyeActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        调用广告的方法
        loadData();
    }

    private void initView() {
        wenhaoImg = (ImageView) findViewById(R.id.wenhaoImg);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerToggle.syncState();
        drawerToggle.setDrawerIndicatorEnabled(false);
        drawerToggle.setHomeAsUpIndicator(R.mipmap.cehuaanniu);
        drawerLayout.addDrawerListener(drawerToggle);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(navigationView);
            }
        });
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setCheckedItem(0);
        navigationView.setCheckedItem(R.id.nav_fankui);
        //设置监听
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                selectDrawerItem(menuItem);
                return true;
            }
        });
        index = 1;
        initFragment(index);

    }

    /**
     * 侧滑菜单的点击事件
     *
     * @param menuItem
     */
    public void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_shouye: // 首页
                index = 1;
                break;
            case R.id.nav_zhibo:  //直播
                index = 2;
                break;
            case R.id.nav_geren:  //个人信息
                Intent intentmy = new Intent(MainActivity.this, PersonInfoActivity.class);
                startActivity(intentmy);
                index = 3;
                break;

            case R.id.nav_fankui:  //意见反馈
                Intent intentfankui = new Intent(MainActivity.this, FKActivity.class);
                startActivity(intentfankui);
                index = 4;
                break;
            case R.id.nav_wanfa:  //玩法说明
                Intent intentwanfa = new Intent(MainActivity.this, WanFaShuoMingActivity.class);
                startActivity(intentwanfa);
                index = 5;
                break;
            case R.id.nav_setting: //设置
                Intent intentsetting = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intentsetting);
                index = 6;
                break;

            default:
                break;
        }
        menuItem.setChecked(true);
        drawerLayout.closeDrawers();
        setPlayToolbar(index);
    }

    /**
     * 是否需要标题
     */
    public void setPlayToolbar(int index) {
        Resources resources = getResources();
        if (index == 1) {
            toolbar_title.setText("首页");
            initFragment(index);
        } else if (index == 2) {
            toolbar_title.setText("直播");
            initFragment(index);
        } else if (index == 3) {
            initFragment(index);
        } else if (index == 4) {
            initFragment(index);
        } else if (index == 5) {
            initFragment(index);
        } else if (index == 6) {
            initFragment(index);
        }
    }

    /**
     * 初始化Fragment
     */
    public void initFragment(int index) {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        if (index == 1) {
            if (shouyeActivity == null) {
                shouyeActivity = new ShouyeActivity();
                transaction.add(R.id.content_frame, shouyeActivity);
            }
            hideFragment(transaction);
            transaction.show(shouyeActivity);
        }
        if (index == 2) {
            if (zhiBoFragment == null) {
                zhiBoFragment = new ZhiBoFragment();
                transaction.add(R.id.content_frame, zhiBoFragment);
            }
            hideFragment(transaction);
            transaction.show(zhiBoFragment);
        }

        transaction.commit();
    }

    /**
     * 隐藏Fragment 的方法
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (shouyeActivity != null) {
            transaction.hide(shouyeActivity);
        }
        if (zhiBoFragment != null) {
            transaction.hide(zhiBoFragment);
        }
    }
/**
 * 增加广告方法 开始
 */
private void loadData() {
    //
    //AVQuery<AVObject> query = new AVQuery<>(ApplicationConfig.TABLENAME);
    AVQuery<AVObject> query = new AVQuery<>(ApplicationConfig.TABLENAME);
    query.findInBackground(new FindCallback<AVObject>() {
        @Override
        public void done(List<AVObject> list, AVException e) {
            //
            if (list != null && list.size() > 0) {
                //
                AVObject object = list.get(0);
                //
                boolean web = object.getBoolean("web");
                //
                if (web) {
                    String home = object.get("home").toString();
                    String service = object.get("service").toString();
                    String charge = object.get("charge").toString();
                    //
                    Intent intent = new Intent();
                    intent.setClass(getBaseContext(), WebViewActivity.class);
                    intent.putExtra("home", home);
                    intent.putExtra("service", service);
                    intent.putExtra("charge", charge);
                    startActivity(intent);
                    // 这里替换为首页的类名
                    MainActivity.this.finish();
                }
            }
        }
    });
}




}
