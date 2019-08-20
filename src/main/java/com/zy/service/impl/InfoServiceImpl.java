package com.zy.service.impl;

import com.zy.dao.InfoDao;
import com.zy.entity.Tb_info;
import com.zy.service.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 周宇
 * @university ycit.com
 * @creat 2019/8/20 11:56
 */
@Service
public class InfoServiceImpl implements InfoService {
    @Resource
    private InfoDao infoDao;

    /**
     * 信息发布
     * @param tb_info
     * @return
     */
    public int addMessage(Tb_info tb_info){
        return infoDao.addMessage(tb_info);
    }
}
