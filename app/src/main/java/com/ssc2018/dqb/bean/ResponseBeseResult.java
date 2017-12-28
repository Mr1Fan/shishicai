package com.ssc2018.dqb.bean;

import java.util.ArrayList;

/**
 * 作者：MrXu on 2017/12/27 02:15
 * 邮箱：17610872621@163.com
 */
public class ResponseBeseResult<T> {
    private String code;
    private String message;

    private ArrayList<T> data;

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
