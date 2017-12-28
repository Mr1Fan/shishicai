package com.ssc2018.dqb.Draw;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import java.lang.reflect.Field;

/**
 * Created by ygs on 2017/6/9.
 */

public class DeviceUtils {

    /**
     * 获取屏幕宽度(px)
     *
     * @param
     * @return
     */
    public static int getMobileWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        return width;
    }

    /**
     * 获取屏幕高度(px)
     *
     * @param
     * @return
     */
    public static int getMobileHeight(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        return height;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取状态栏高度
     * @return
     */
    public static int getStatusBarHeight(Activity activity) {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    /**
     * 调整tablayou下划线的宽度
     * 通过反射修改私有属性
     * @param tabs
     * @param leftDip
     * @param rightDip
     */
    public static void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field field = null;  //Field 类中的成员变量
        try {
            //getDeclaredField 获取指定名称的私有属性
            //getDeclaredFields 获取在这个类型的声明中定义的所有属性(私有的,保护的,都返回,父类的不返回)
            // getField只能获取类的public 字段.
            field = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        field.setAccessible(true); //tabLayout类中的成员变量为private,故必须进行此操作,此步应该在获取Field之后
        LinearLayout linearLayout = null;
        try {
            linearLayout = (LinearLayout) field.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //将传进来是 leftDip转换成 DIP的单位值  //TypedValue.COMPLEX_UNIT_DIP 获取单位
        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip,
                Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View child = linearLayout.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    public static String getSystomMsg(Context context){
        StringBuffer sb = new StringBuffer();
        sb.append("lercai,");
        sb.append(VersionUtils.getVersionName(context)+",");
        sb.append(VersionUtils.getVersionCode(context));
        sb.append(";");
        sb.append("Android,");
        sb.append(Build.DEVICE+",");
        sb.append(Build.VERSION.SDK_INT+",");
        sb.append(Build.VERSION.RELEASE);
        return sb.toString();
    }
}
