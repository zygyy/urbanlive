package com.zy.service;


import com.zy.entity.Tb_User;

/**
 * @author 周宇
 * @university ycit.com
 * @creat 2019/8/15 19:50
 */

public interface UserService {
    /**
     * 用户登录
     * @param user_name
     * @return
     */
    public Tb_User login(String user_name);

    /**
     * 用户注册
     * @param tb_user
     * @return
     */
    public int register(Tb_User tb_user);

    /**
     * 用户注册时，保证姓名唯一
     * @param user_name
     * @return
     */
    public Tb_User checkRegister(String user_name);
}
