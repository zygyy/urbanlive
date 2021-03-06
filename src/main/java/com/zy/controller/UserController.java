package com.zy.controller;

import com.github.pagehelper.Page;
import com.zy.entity.Result;
import com.zy.entity.Tb_User;
import com.zy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 周宇
 * @university ycit.com
 * @creat 2019/8/15 20:02
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册（用户名唯一）
     *
     * @param user_passwordQueRen
     * @param tb_user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register/{user_passwordQueRen}", method = RequestMethod.POST)
    public Result login(@PathVariable String user_passwordQueRen, Tb_User tb_user) {
        System.out.println("用户注册");
        Tb_User tb_userCheck = userService.checkRegister(tb_user.getUser_name());
        if (tb_userCheck == null) {
            if (tb_user.getUser_password().equals(user_passwordQueRen)) {
                int result = userService.register(tb_user);
                return new Result(true, "注册成功");
            } else {
                return new Result(false, "请再次确认密码");
            }
        } else {
            return new Result(false, "用户名重复");
        }

    }

    /**
     * 登录
     *
     * @param tb_user
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public Result login(Tb_User tb_user) {
        Tb_User tb_userLogin = userService.login(tb_user.getUser_name());
        if (tb_userLogin != null) {
            if (tb_userLogin.getUser_password().equals(tb_user.getUser_password())) {
                //System.out.println("密码正确！登录成功！");
                return new Result(true, "登录成功");
            } else {
                return new Result(false, "密码错误");
            }
        } else {
            return new Result(false, "账号错误");
        }
    }

    /**
     * 查询所有非管理员的用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/select")
    public Result selectAllUser(int pageNum, int pageSize) {
        Page page = new Page();
        page.setPageSize(pageSize);
        page.setPageNum(pageNum);
        return userService.selectAllUser(page);
    }

    /**
     * 根据Id查找用户
     *
     * @param tb_user
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectById")
    public Result selectUserById(Tb_User tb_user) {
        return userService.selectUserById(tb_user);
    }

    /**
     * 删除用户
     *
     * @param tb_user
     * @return
     */
    @ResponseBody
    @RequestMapping("/del")
    public Result delectUser(Tb_User tb_user) {
        return userService.delectUser(tb_user);
    }

    /**
     * 更新用户信息
     *
     * @param tb_user
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Result updateUser(Tb_User tb_user) {
      return userService.updateUser(tb_user);
    }
}
