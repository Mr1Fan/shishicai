package com.ssc2018.dqb.bean;

import java.io.Serializable;

/**
 * 作者：MrXu on 2017/12/27 02:01
 * 邮箱：17610872621@163.com
 */
public class HemaiBean implements Serializable {
    private int baifenbi;
    private String type_name;
    private String nick;
    private String total_money;
    private String fen_m;
    private String syfen;

    public int getBaifenbi() {
        return baifenbi;
    }

    public void setBaifenbi(int baifenbi) {
        this.baifenbi = baifenbi;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTotal_money() {
        return total_money;
    }

    public void setTotal_money(String total_money) {
        this.total_money = total_money;
    }

    public String getFen_m() {
        return fen_m;
    }

    public void setFen_m(String fen_m) {
        this.fen_m = fen_m;
    }

    public String getSyfen() {
        return syfen;
    }

    public void setSyfen(String syfen) {
        this.syfen = syfen;
    }




}
