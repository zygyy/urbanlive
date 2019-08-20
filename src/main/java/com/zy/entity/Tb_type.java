package com.zy.entity;

/**
 * @author 周宇
 * @university ycit.com
 * @creat 2019/8/20 10:54
 */
public class Tb_type {
    private int type_sign;
    private String type_name;
    private String type_intro;

    public int getType_sign() {
        return type_sign;
    }

    public void setType_sign(int type_sign) {
        this.type_sign = type_sign;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getType_intro() {
        return type_intro;
    }

    public void setType_intro(String type_intro) {
        this.type_intro = type_intro;
    }

    @Override
    public String toString() {
        return "Tb_type{" +
                "type_sign=" + type_sign +
                ", type_name='" + type_name + '\'' +
                ", type_intro='" + type_intro + '\'' +
                '}';
    }
}
