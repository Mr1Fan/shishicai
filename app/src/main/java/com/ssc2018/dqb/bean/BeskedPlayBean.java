package com.ssc2018.dqb.bean;

/**
 * 作者：MrXu on 2017/12/27 00:43
 * 邮箱：17610872621@163.com
 */

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 篮球数据结构
 * 最内层的数据
 */
public class BeskedPlayBean implements Serializable {
    private String ids;  //ids
    private String game_id;
    private String game_no;
    private String game_day;
    private String week_day;
    private String league_id;
    private String match_name; //名称
    private String game_time;
    private String end_buy_time;
    private String host_team;  //主全称
    private String guest_team;  //客全称
    private String host_team_single;   //主简称
    private String guest_team_single; //客简称

    private String is_postponed;  // //是否延迟

    private String begin_time;  //开始时间
    private String end_time;  //结束时间

    private String rfsf_rf;  //让分胜负的分数
    private String dxf_zf;   //大小分 的 总分
    private ArrayList<String> jclq_dxfsf = new ArrayList<>(); //胜负
    private ArrayList<String> jclq_dxf = new ArrayList<>(); //大小分
    private ArrayList<String> jclq_rfsf = new ArrayList<>(); //让分胜负/让分
    private ArrayList<String> jclq_sfc = new ArrayList<>(); //胜分差

    private String league_name; // 美国女子篮球联盟,
    private String single; //

    private String single_dxf; // //大小分单关
    private String single_rfsf; //让分胜负单关
    private String single_sf; //胜负单关
    private String single_sfc; //胜负差单关

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getSingle_dxf() {
        return single_dxf;
    }

    public void setSingle_dxf(String single_dxf) {
        this.single_dxf = single_dxf;
    }

    public String getSingle_rfsf() {
        return single_rfsf;
    }

    public void setSingle_rfsf(String single_rfsf) {
        this.single_rfsf = single_rfsf;
    }

    public String getSingle_sf() {
        return single_sf;
    }

    public void setSingle_sf(String single_sf) {
        this.single_sf = single_sf;
    }

    public String getSingle_sfc() {
        return single_sfc;
    }

    public void setSingle_sfc(String single_sfc) {
        this.single_sfc = single_sfc;
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

    public String getMatch_name() {
        return match_name;
    }

    public void setMatch_name(String match_name) {
        this.match_name = match_name;
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

    public String getHost_team_single() {
        return host_team_single;
    }

    public void setHost_team_single(String host_team_single) {
        this.host_team_single = host_team_single;
    }

    public String getGuest_team_single() {
        return guest_team_single;
    }

    public void setGuest_team_single(String guest_team_single) {
        this.guest_team_single = guest_team_single;
    }

    public String getIs_postponed() {
        return is_postponed;
    }

    public void setIs_postponed(String is_postponed) {
        this.is_postponed = is_postponed;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getRfsf_rf() {
        return rfsf_rf;
    }

    public void setRfsf_rf(String rfsf_rf) {
        this.rfsf_rf = rfsf_rf;
    }

    public String getDxf_zf() {
        return dxf_zf;
    }

    public void setDxf_zf(String dxf_zf) {
        this.dxf_zf = dxf_zf;
    }

    public ArrayList<String> getJclq_dxfsf() {
        return jclq_dxfsf;
    }

    public void setJclq_dxfsf(ArrayList<String> jclq_dxfsf) {
        this.jclq_dxfsf = jclq_dxfsf;
    }

    public ArrayList<String> getJclq_dxf() {
        return jclq_dxf;
    }

    public void setJclq_dxf(ArrayList<String> jclq_dxf) {
        this.jclq_dxf = jclq_dxf;
    }

    public ArrayList<String> getJclq_rfsf() {
        return jclq_rfsf;
    }

    public void setJclq_rfsf(ArrayList<String> jclq_rfsf) {
        this.jclq_rfsf = jclq_rfsf;
    }

    public ArrayList<String> getJclq_sfc() {
        return jclq_sfc;
    }

    public void setJclq_sfc(ArrayList<String> jclq_sfc) {
        this.jclq_sfc = jclq_sfc;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }



}
