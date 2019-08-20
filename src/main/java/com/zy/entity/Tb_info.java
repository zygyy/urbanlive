package com.zy.entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * @author 周宇
 * @university ycit.com
 * @creat 2019/8/20 10:56
 */
public class Tb_info {
    private int id;
    private int info_type;
    private String info_title;
    private String info_content;
    private String info_linkman;
    private String info_phone;
    private String info_email;
    private String info_date;
    private String info_check;
    private String info_payFor;
    private String info_status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfo_type() {
        return info_type;
    }

    public void setInfo_type(int info_type) {
        this.info_type = info_type;
    }

    public String getInfo_title() {
        return info_title;
    }

    public void setInfo_title(String info_title) {
        this.info_title = info_title;
    }

    public String getInfo_content() {
        return info_content;
    }

    public void setInfo_content(String info_content) {
        this.info_content = info_content;
    }

    public String getInfo_linkman() {
        return info_linkman;
    }

    public void setInfo_linkman(String info_linkman) {
        this.info_linkman = info_linkman;
    }

    public String getInfo_phone() {
        return info_phone;
    }

    public void setInfo_phone(String info_phone) {
        this.info_phone = info_phone;
    }

    public String getInfo_email() {
        return info_email;
    }

    public void setInfo_email(String info_email) {
        this.info_email = info_email;
    }

    public String getInfo_date() {
        return info_date;
    }

    public void setInfo_date(String info_date) {
        this.info_date = info_date;
    }

    public String getInfo_check() {
        return info_check;
    }

    public void setInfo_check(String info_check) {
        this.info_check = info_check;
    }

    public String getInfo_payFor() {
        return info_payFor;
    }

    public void setInfo_payFor(String info_payFor) {
        this.info_payFor = info_payFor;
    }

    public String getInfo_status() {
        return info_status;
    }

    public void setInfo_status(String info_status) {
        this.info_status = info_status;
    }

    @Override
    public String toString() {
        return "Tb_info{" +
                "id=" + id +
                ", info_type=" + info_type +
                ", info_title='" + info_title + '\'' +
                ", info_content='" + info_content + '\'' +
                ", info_linkman='" + info_linkman + '\'' +
                ", info_phone='" + info_phone + '\'' +
                ", info_email='" + info_email + '\'' +
                ", info_date=" + info_date +
                ", info_check='" + info_check + '\'' +
                ", info_payFor='" + info_payFor + '\'' +
                ", info_status='" + info_status + '\'' +
                '}';
    }
}
