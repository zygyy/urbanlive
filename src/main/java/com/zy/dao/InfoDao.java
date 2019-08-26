package com.zy.dao;

import com.zy.entity.Tb_info;

import java.util.List;

/**
 * @author 周宇
 * @university ycit.com
 * @creat 2019/8/20 11:54
 */
public interface InfoDao {
    /**
     * 信息发布
     * @param tb_info
     * @return
     */
    public int addMessage(Tb_info tb_info);

    /**
     * 全字匹配查询
     * @param tb_info
     * @return
     */
    public List<Tb_info> selectByAll(Tb_info tb_info);

    /**
     * 模糊查询
     * @param tb_info
     * @return
     */
    public List<Tb_info> selectByLike(Tb_info tb_info);

    /**
     * 查询付款信息
     * @param tb_info
     * @return
     */
    public List<Tb_info> selectAllByCheckPay(Tb_info tb_info);


}
