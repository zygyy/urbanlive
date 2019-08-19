package com.zy.controller;

import com.zy.entity.Result;
import com.zy.entity.StatusCode;
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
     * 登录
     *
     * @param tb_user
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public Result login(Tb_User tb_user) {
        System.out.println("请求传到后台");
        Tb_User tb_userLogin = userService.login(tb_user.getUser_name());
        if (tb_userLogin != null) {
            if (tb_userLogin.getUser_password().equals(tb_user.getUser_password())) {
                System.out.println("密码正确！登录成功！");
                return new Result(true, StatusCode.OK, "登录成功");
            } else {
                return new Result(true, StatusCode.ERROR, "密码错误");
            }

        } else {
            return new Result(true, StatusCode.ERROR, "账号错误");
        }
    }


}
