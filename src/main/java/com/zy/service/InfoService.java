package com.zy.service;

import com.github.pagehelper.Page;
import com.zy.entity.Result;
import com.zy.entity.Tb_info;

import java.util.List;

/**
 * @author 周宇
 * @university ycit.com
 * @creat 2019/8/20 11:55
 */
public interface InfoService {
    /**
     * 信息发布
     *
     * @param tb_info
     * @return
     */
    public int addMessage(Tb_info tb_info);

    /**
     * 全字匹配查询
     *
     * @param page
     * @param type
     * @param key
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public Result selectByAll(Page page, String type, String key) throws NoSuchFieldException, IllegalAccessException;

    /**
     * 模糊查询
     *
     * @param page
     * @param type
     * @param key
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public Result selectByLike(Page page, String type, String key) throws NoSuchFieldException, IllegalAccessException;


}
