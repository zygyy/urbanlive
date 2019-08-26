package com.zy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.dao.UserDao;
import com.zy.entity.Result;
import com.zy.entity.Tb_User;
import com.zy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
     *
     * @param user_name
     * @return
     */
    public Tb_User checkRegister(String user_name) {
        return userDao.checkRegister(user_name);
    }

    /**
     * 查询所有非管理员用户
     *
     * @param page
     * @return
     */
    @Override
    public Result selectAllUser(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Tb_User> tb_users = userDao.selectAllUser();
        PageInfo<Tb_User> tb_userPageInfo = new PageInfo<>(tb_users);
        return new Result(tb_userPageInfo);

    }

    /**
     * 根据ID查询用户
     *
     * @param tb_user
     * @return
     */
    public Result selectUserById(Tb_User tb_user) {
        return new Result(userDao.selectUserById(tb_user));
    }

    /**
     * 删除账户
     *
     * @param tb_user
     * @return
     */
    @Override
    public Result delectUser(Tb_User tb_user) {
        tb_user.setUser_statue("1");
        int i = userDao.delectUser(tb_user);
        if (i == 1) {
            return new Result(true, "删除成功！");
        } else {
            return new Result(false, "删除失败");
        }

    }

    /**
     * 更新用户
     *
     * @param tb_User
     * @return
     */
    public Result updateUser(Tb_User tb_User) {
        int result=userDao.updateUser(tb_User);
        if(result==1){
            return new Result(true, "更新成功！");
        } else {
            return new Result(false, "更新失败");
        }

    }



}
