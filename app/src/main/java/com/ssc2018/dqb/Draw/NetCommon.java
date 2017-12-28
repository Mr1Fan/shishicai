package com.ssc2018.dqb.Draw;

import java.util.ArrayList;

/**
 * 网络请求的数据结果
 */

public class NetCommon<T> {

    private String rows;
    private String code;
    private String info;
    private ArrayList<T> data;

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }
}
