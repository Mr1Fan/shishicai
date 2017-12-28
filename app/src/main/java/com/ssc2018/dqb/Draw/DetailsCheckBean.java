package com.ssc2018.dqb.Draw;

/**
 * 11选5 投注详情中 是否中奖
 */

public class DetailsCheckBean {

    private String number;
    private boolean is_check;
    private boolean red_blue;  //falase 是红球, true是篮球

    public boolean isRed_blue() {
        return red_blue;
    }

    public void setRed_blue(boolean red_blue) {
        this.red_blue = red_blue;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean is_check() {
        return is_check;
    }

    public void setIs_check(boolean is_check) {
        this.is_check = is_check;
    }
}
