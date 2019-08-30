package com.zy.controller;

import com.github.pagehelper.Page;
import com.zy.entity.Result;
import com.zy.entity.Tb_info;
import com.zy.service.InfoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
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
            return new Result(true, "信息发布成功");
        } else {
            return new Result(false, "信息发布失败");
        }
    }


    /**
     * 按照类型查询相应数据
     *
     * @param pageNum    当前页数
     * @param pageSize   页面条数
     * @param type       属性
     * @param key        查询的关键字
     * @param searchType 查询的类型-模糊查询、全字查询
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @ResponseBody
    @RequestMapping("/search")
    public Result searchByType(int pageNum, int pageSize, String type, String key, String searchType) throws NoSuchFieldException, IllegalAccessException {
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return infoService.select(page, type, key, searchType);
    }

    /**
     * 根据付费状态、审核状态查询信息
     *
     * @param pageNum
     * @param pageSize
     * @param tb_info
     * @return
     */
    @ResponseBody
    @RequestMapping("/select")
    public Result selectAllByCheckPay(int pageNum, int pageSize, Tb_info tb_info) {
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return infoService.selectAllByCheckPay(page, tb_info);
    }

    /**
     * 根据Id查询信息
     *
     * @param tb_info
     * @return
     */
    @ResponseBody
    @RequestMapping("/sel")
    public Result selectInfoById(Tb_info tb_info) {
        return infoService.selectInfoById(tb_info);
    }

    /**
     * 审核状态的修改
     *
     * @param tb_info
     * @return
     */
    @ResponseBody
    @RequestMapping("/check")
    public Result setCheck(Tb_info tb_info) {
        return infoService.setChecked(tb_info);
    }


    /**
     * 支付状态的修改
     *
     * @param tb_info
     * @return
     */
    @ResponseBody
    @RequestMapping("/pay")
    public Result setPay(Tb_info tb_info) {

        return infoService.setPay(tb_info);
    }


    /**
     * 文件下载
     *
     * @param filename
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    @RequestMapping("/download")
    ResponseEntity<byte[]> getUserBook(String filename) throws URISyntaxException, IOException {
        String path = this.getClass().getClassLoader().getResource("").toURI().getPath();
        path = path.substring(0, path.length() - 8);
        File file = new File(path + "\\file\\" + filename);
        InputStream inputStream = new FileInputStream(file);
        byte[] body = new byte[inputStream.available()];
        inputStream.read(body);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attchement;filename=" + file.getName());
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, httpHeaders, HttpStatus.OK);
        return entity;
    }

    /**
     * 招聘信息
     *
     * @param tb_info
     * @return
     */
    @ResponseBody
    @RequestMapping("/recruit")
    public Result recruit(Tb_info tb_info) {
        return infoService.recruit(tb_info);
    }


}
