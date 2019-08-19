package com.zy.service.impl;

import com.zy.dao.UserDao;
import com.zy.entity.Tb_User;
import com.zy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 周宇
 * @university ycit.com
 * @creat 2019/8/15 19:52
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 用户登录
     *
     * @param user_name
     * @return
     */
    @Override
    public Tb_User login(String user_name) {
        return userDao.login(user_name);
    }

    /**
     * 用户注册
     *
     * @param tb_user
     * @return
     */
    public int register(Tb_User tb_user) {
        return userDao.register(tb_user);
    }

    /**
     * 用户注册时，保证姓名唯一
     * @param user_name
     * @return
     */
    public Tb_User checkRegister(String user_name){
        return userDao.checkRegister(user_name);
    }
}
