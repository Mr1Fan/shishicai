package com.ssc2018.dqb.Draw;

import java.util.ArrayList;

/**
 * 足球 日期(周二两场赛事)类
 */

public class EverydayDataBean<T>{

    private String match_time;
    private ArrayList<T> play_list;


    public String getMatch_time() {
        return match_time;
    }

    public void setMatch_time(String match_time) {
        this.match_time = match_time;
    }

    public ArrayList<T> getPlay_list() {
        return play_list;
    }

    public void setPlay_list(ArrayList<T> play_list) {
        this.play_list = play_list;
    }
}
