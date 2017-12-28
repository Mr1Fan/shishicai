package com.ssc2018.dqb.bean;

/**
 * 作者：MrXu on 2017/12/27 02:08
 * 邮箱：17610872621@163.com
 */

import com.google.gson.JsonObject;

/**
 * 开奖公告
 * 列表实体类
 */

public class LotterNoticeBean {
    private JsonObject game_result;  //开奖公告列表
    private String game_type;  //开奖公告类型

    public JsonObject getGame_result() {
        return game_result;
    }

    public void setGame_result(JsonObject game_result) {
        this.game_result = game_result;
    }

    public String getGame_type() {
        return game_type;
    }

    public void setGame_type(String game_type) {
        this.game_type = game_type;
    }

}
