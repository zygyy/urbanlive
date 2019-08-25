package com.zy.controller;

import com.github.pagehelper.Page;
import com.zy.entity.Result;
import com.zy.entity.StatusCode;
import com.zy.entity.Tb_info;
import com.zy.service.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author 周宇
 * @university ycit.com
 * @creat 2019/8/20 11:58
 */
@Controller
@RequestMapping("/info")
public class InfoController {
    @Resource
    private InfoService infoService;

    /**
     * 发布新消息
     *
     * @param tb_info
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    public Result addMessage(Tb_info tb_info) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        tb_info.setInfo_date(simpleDateFormat.format(new Date()));
        int resultAddMessage = infoService.addMessage(tb_info);
        if (resultAddMessage > 0) {
            return new Result(true, StatusCode.OK, "信息发布成功");
        } else {
            return new Result(false, StatusCode.OK, "信息发布失败");
        }
    }


    /**
     *按照类型查询相应数据
     * @param pageNum    分页属性当前页数
     * @param pageSize   页面size
     * @param type       属性
     * @param key        查询的关键字
     * @param searchType 查询的类型-模糊查询、全字查询
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @ResponseBody
    @RequestMapping("/search")
    public Result searchByType(int pageNum, int pageSize, String type, String key, String searchType) throws NoSuchFieldException,IllegalAccessException  {
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        if (searchType.equals("all")) {
            return infoService.selectByAll(page,type,key) ;
        } else {
            return infoService.selectByLike(page,type,key) ;
        }
    }

}
