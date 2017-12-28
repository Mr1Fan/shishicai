package com.ssc2018.dqb.bean;

import java.io.Serializable;

/**
 * 作者：MrXu on 2017/12/27 02:13
 * 邮箱：17610872621@163.com
 */
public class NewsBean implements Serializable {

    public String names;
    public String data;
    public String imgs;
    public String contents;

    public NewsBean(String names, String data, String imgs,String contents) {
        this.names = names;
        this.data = data;
        this.imgs = imgs;
        this.contents=contents;
    }

}
