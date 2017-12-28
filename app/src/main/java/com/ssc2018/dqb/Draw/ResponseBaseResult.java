package com.ssc2018.dqb.Draw;


import java.util.ArrayList;

/**
 * 接口数据返回的通用类
 */

public class ResponseBaseResult<T> {

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
