package com.zy.dao;

import com.zy.entity.Tb_User;

import java.util.List;

/**
 * @author 周宇
 * @university ycit.com
 * @creat 2019/8/15 19:48
 */
public interface UserDao {
    /**
     * 用户登录
     *
     * @param user_name
     * @return
     */
    public Tb_User login(String user_name);

    /**
     * 用户注册时，保证姓名唯一(跟登录方法相同，可以省略)
     *
     * @param user_name
     * @return
     */
    public Tb_User checkRegister(String user_name);

    /**
     * 用户注册
     *
     * @param tb_user
     * @return
     */
    public int register(Tb_User tb_user);

    /**
     * 查询所有非管理用户
     *
     * @return
     */
    public List<Tb_User> selectAllUser();

    /**
     * 根据用户ID查询用户
     *
     * @param tb_user
     * @return
     */
    public Tb_User selectUserById(Tb_User tb_user);


}
