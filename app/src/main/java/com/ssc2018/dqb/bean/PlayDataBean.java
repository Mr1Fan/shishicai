package com.ssc2018.dqb.bean;

/**
 * 作者：MrXu on 2017/12/27 02:14
 * 邮箱：17610872621@163.com
 */

import java.util.ArrayList;

/**
 * 足球数据bean
 */
public class PlayDataBean {
    private String game_id;
    private String ids;
    private String game_no;
    private String game_day;
    private String week_day;
    private String league_id;
    private String league_name;
    private String game_time;
    private String end_buy_time;
    private String host_team;
    private String guest_team;
    private String guest_score;
    private String host_score;
    private String history_score;
    private String dataUrl;


    private String is_postponed;
    private String jczq_spf_flag;
    private ArrayList<String> jczq_spf;
    private ArrayList<String> jczq_spf_rq;
    private ArrayList<String> jczq_zjq;
    private ArrayList<String> jczq_bqc;
    private ArrayList<String> jczq_bf;

    private String bf_single;
    private String bqc_single;
    private String rqspf_single;
    private String spf_single;
    private String zjq_single;
    private boolean is_history_visble;

    public boolean is_history_visble() {
        return is_history_visble;
    }

    public void setIs_history_visble(boolean is_history_visble) {
        this.is_history_visble = is_history_visble;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public String getGuest_score() {
        return guest_score;
    }

    public void setGuest_score(String guest_score) {
        this.guest_score = guest_score;
    }

    public String getHost_score() {
        return host_score;
    }

    public void setHost_score(String host_score) {
        this.host_score = host_score;
    }

    public String getHistory_score() {
        return history_score;
    }

    public void setHistory_score(String history_score) {
        this.history_score = history_score;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getBf_single() {
        return bf_single;
    }

    public void setBf_single(String bf_single) {
        this.bf_single = bf_single;
    }

    public String getBqc_single() {
        return bqc_single;
    }

    public void setBqc_single(String bqc_single) {
        this.bqc_single = bqc_single;
    }

    public String getRqspf_single() {
        return rqspf_single;
    }

    public void setRqspf_single(String rqspf_single) {
        this.rqspf_single = rqspf_single;
    }

    public String getSpf_single() {
        return spf_single;
    }

    public void setSpf_single(String spf_single) {
        this.spf_single = spf_single;
    }

    public String getZjq_single() {
        return zjq_single;
    }

    public void setZjq_single(String zjq_single) {
        this.zjq_single = zjq_single;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getGame_no() {
        return game_no;
    }

    public void setGame_no(String game_no) {
        this.game_no = game_no;
    }

    public String getGame_day() {
        return game_day;
    }

    public void setGame_day(String game_day) {
        this.game_day = game_day;
    }

    public String getWeek_day() {
        return week_day;
    }

    public void setWeek_day(String week_day) {
        this.week_day = week_day;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public String getGame_time() {
        return game_time;
    }

    public void setGame_time(String game_time) {
        this.game_time = game_time;
    }

    public String getEnd_buy_time() {
        return end_buy_time;
    }

    public void setEnd_buy_time(String end_buy_time) {
        this.end_buy_time = end_buy_time;
    }

    public String getHost_team() {
        return host_team;
    }

    public void setHost_team(String host_team) {
        this.host_team = host_team;
    }

    public String getGuest_team() {
        return guest_team;
    }

    public void setGuest_team(String guest_team) {
        this.guest_team = guest_team;
    }

    public String getIs_postponed() {
        return is_postponed;
    }

    public void setIs_postponed(String is_postponed) {
        this.is_postponed = is_postponed;
    }

    public String getJczq_spf_flag() {
        return jczq_spf_flag;
    }

    public void setJczq_spf_flag(String jczq_spf_flag) {
        this.jczq_spf_flag = jczq_spf_flag;
    }

    public ArrayList<String> getJczq_spf() {
        return jczq_spf;
    }

    public void setJczq_spf(ArrayList<String> jczq_spf) {
        this.jczq_spf = jczq_spf;
    }

    public ArrayList<String> getJczq_spf_rq() {
        return jczq_spf_rq;
    }

    public void setJczq_spf_rq(ArrayList<String> jczq_spf_rq) {
        this.jczq_spf_rq = jczq_spf_rq;
    }

    public ArrayList<String> getJczq_zjq() {
        return jczq_zjq;
    }

    public void setJczq_zjq(ArrayList<String> jczq_zjq) {
        this.jczq_zjq = jczq_zjq;
    }

    public ArrayList<String> getJczq_bqc() {
        return jczq_bqc;
    }

    public void setJczq_bqc(ArrayList<String> jczq_bqc) {
        this.jczq_bqc = jczq_bqc;
    }

    public ArrayList<String> getJczq_bf() {
        return jczq_bf;
    }

    public void setJczq_bf(ArrayList<String> jczq_bf) {
        this.jczq_bf = jczq_bf;
    }



}
