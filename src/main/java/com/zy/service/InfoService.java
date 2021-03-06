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


    /**
     * 根据付费状态，审核状态查询信息
     *
     * @param page
     * @param tb_info
     * @return
     */
    public Result selectAllByCheckPay(Page page, Tb_info tb_info);


    /**
     * 根据信息ID查询信息
     *
     * @param tb_info
     * @return
     */
    public Result selectInfoById(Tb_info tb_info);

    /**
     * 修改核审状态
     *
     * @param tb_info
     * @return
     */
    public Result setChecked(Tb_info tb_info);

    /**
     * 修改支付状态
     *
     * @param tb_info
     * @return
     */
    public Result setPay(Tb_info tb_info);

    /**
     * 查询招聘信息
     *
     * @param tb_info
     * @return
     */
    public Result recruit(Tb_info tb_info);

}
