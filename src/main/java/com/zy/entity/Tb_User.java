package com.zy.entity;

/**
 * @author 周宇
 * @university ycit.com
 * @creat 2019/8/15 19:35
 */
public class Tb_User {
    private int id;
    private String user_name;
    private String user_password;
    private String user_type;
    private String user_statue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_statue() {
        return user_statue;
    }

    public void setUser_statue(String user_statue) {
        this.user_statue = user_statue;
    }

    @Override
    public String toString() {
        return "Tb_User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_type='" + user_type + '\'' +
                ", user_statue='" + user_statue + '\'' +
                '}';
    }
}
