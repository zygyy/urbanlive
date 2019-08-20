package com.zy.dao;

import com.zy.entity.Tb_info;

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
}
