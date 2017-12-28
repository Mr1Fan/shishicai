package com.ssc2018.dqb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 作者：MrXu on 2017/12/27 13:47
 * 邮箱：17610872621@163.com
 */
public class ThreeECountUtils {
    /**
     * 计算直选多少注
     */
    public static Integer CountZXBets(List<Integer> hundredsList, List<Integer> decadeList, List<Integer> theunitList) {
        Integer bets = hundredsList.size() * decadeList.size() * theunitList.size();
        return bets;
    }

    /**
     * 计算组三 注数
     *
     * @param list
     * @return
     */
    public static Integer CountZThreeBets(List<Integer> list) {
        Integer bets = list.size() * (list.size() - 1);
        return bets;
    }


    /**
     * 直选组六计算 注数
     *
     * @param start
     * @param num
     * @param lists
     * @param temms
     * @param rlist
     */
    public static List<String> CountZsixBets(int start, int num, List lists, String temms, List<String> rlist) {
        functionZ3(start, num, lists, temms, rlist);
        return rlist;
    }

    public static void functionZ3(int start, int num, List lists, String templist, List<String> rlist) {
        for (; start < lists.size(); start++) {
            StringBuilder builder = new StringBuilder();
            builder.append(templist).append(lists.get(start));
            String temp = builder.toString();
            if (num == 1) {
                rlist.add(temp);
            } else {
                int s = start + 1;
                int n = num - 1;
                functionZ3(s, n, lists, temp, rlist);
            }
        }
    }

    /**
     * 空格拼接
     * is_need_zero 福彩3D的是 0-9,所以不需要拼接0 其余11选5,双色球等需要在1-9拼接0
     *
     * @param list
     * @return
     */
    public static String pingSpacingInteger(List<Integer> list, boolean is_need_zero) {
        String hunder = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (is_need_zero) {
                Integer index = list.get(i);
                if (index < 10) {
                    builder.append("0" + list.get(i)).append(" ");
                } else {
                    builder.append(list.get(i)).append(" ");
                }
            } else {
                builder.append(list.get(i)).append(" ");
            }
        }
        hunder = builder.toString();
        hunder = hunder.substring(0, hunder.length() - 1);
        return hunder;
    }

    /**
     * 逗号拼接
     *
     * @param list
     * @return
     */
    public static String pingLineStringMethod(List<String> list) {
        String hunder = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i)).append(",");
        }
        hunder = builder.toString();
        hunder = hunder.substring(0, hunder.length() - 1);
        return hunder;
    }


    /**
     * 比较时间的大小
     *
     * @return
     */
    public static boolean getTime(String now_time, String end_time) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Calendar now = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        try {
            Date startDate = formatter.parse(now_time);
            Date endDate = formatter.parse(end_time);
            now.setTime(startDate);
            end.setTime(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result1 = now.compareTo(end); // 比较大小 当 前时间< -1 > 1 = 0
        return result1 < 0;
    }
}
