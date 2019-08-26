package com.zy.service;


import com.github.pagehelper.Page;
import com.zy.entity.Result;
import com.zy.entity.Tb_User;

/**
 * @author 周宇
 * @university ycit.com
 * @creat 2019/8/15 19:50
 */

public interface UserService {
    /**
     * 用户登录
     *
     * @param user_name
     * @return
     */
    public Tb_User login(String user_name);

    /**
     * 用户注册
     *
     * @param tb_user
     * @return
     */
    public int register(Tb_User tb_user);

    /**
     * 用户注册时，保证姓名唯一
     *
     * @param user_name
     * @return
     */
    public Tb_User checkRegister(String user_name);

    /**
     * 查询所有非管理员用户
     *
     * @param page
     * @return
     */
    public Result selectAllUser(Page page);

    /**
     * 根据ID查询用户
     *
     * @param tb_user
     * @return
     */
    public Result selectUserById(Tb_User tb_user);

    /**
     * 删除用户
     *
     * @param tb_user
     * @return
     */
    public Result delectUser(Tb_User tb_user);


    /**
     * 更新用户
     *
     * @param tb_User
     * @return
     */
    public Result updateUser(Tb_User tb_User);

}
