package com.ssc2018.dqb.bean;

/**
 * 作者：MrXu on 2017/12/27 02:16
 * 邮箱：17610872621@163.com
 */

/**
 * 福彩3D 11选5 的 中奖公告Bean
 */
public class ThreeEResultBean {
    private String dateline;  //:2017-08-24,
    private String issue;  //:2017229,
    private String url;  //:http://47.93.151.103/api-doc/explain/threeD_prize.html,
    private String winnum;  //:7 0 7

    public String getDateline() {
        return dateline;
    }

    public void setDateline(String dateline) {
        this.dateline = dateline;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWinnum() {
        return winnum;
    }

    public void setWinnum(String winnum) {
        this.winnum = winnum;
    }


}
