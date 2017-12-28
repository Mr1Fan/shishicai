package com.ssc2018.dqb.bean;

import java.util.ArrayList;

/**
 * 作者：MrXu on 2017/12/27 01:59
 * 邮箱：17610872621@163.com
 */
public class EverydayDataBean<T> {

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
