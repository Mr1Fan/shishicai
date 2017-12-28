package com.ssc2018.dqb.bean;

import java.io.Serializable;

/**
 * 作者：MrXu on 2017/12/27 02:00
 * 邮箱：17610872621@163.com
 */

/**
 * 跟单Bean
 */
public class GendanBean implements Serializable {

    private String createtime; //:10-25 17:50 截止,
    private String team; //:天皇杯,
    private String zigou; //:204元,
    private String  benshu;
    private String gendan; //:0人,
    private String header; //:http://cp-quanzi.nos.netease.com/quanzi/200-200_1164870_1423652708706_8211.jpg,
    private String content; //:竞彩足球精选方案！,
    private String nickname; //:红单狙击大队,

    public String getBenshu() {
        return benshu;
    }

    public void setBenshu(String benshu) {
        this.benshu = benshu;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getZigou() {
        return zigou;
    }

    public void setZigou(String zigou) {
        this.zigou = zigou;
    }

    public String getGendan() {
        return gendan;
    }

    public void setGendan(String gendan) {
        this.gendan = gendan;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


}
