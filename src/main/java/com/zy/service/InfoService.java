package com.zy.service;

import com.github.pagehelper.Page;
import com.zy.entity.Result;
import com.zy.entity.Tb_info;


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
     * 分类型查询
     *
     * @param page
     * @param type
     * @param key
     * @param searchType
     * @return
     */
    public Result select(Page page, String type, String key, String searchType) throws NoSuchFieldException, IllegalAccessException;


    /**
     * 全字匹配查询
     *
     * @param page
     * @param tb_info
     * @return
     */
    public Result selectByAll(Page page, Tb_info tb_info);


    /**
     * 模糊查询
     *
     * @param page
     * @param tb_info
     * @return
     */
    public Result selectByLike(Page page, Tb_info tb_info);
}
