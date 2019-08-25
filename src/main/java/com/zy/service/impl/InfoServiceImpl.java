package com.zy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.dao.InfoDao;
import com.zy.entity.Result;
import com.zy.entity.Tb_info;
import com.zy.service.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.List;

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
     *
     * @param tb_info
     * @return
     */
    public int addMessage(Tb_info tb_info) {
        return infoDao.addMessage(tb_info);
    }

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
    public Result selectByAll(Page page, String type, String key) throws NoSuchFieldException, IllegalAccessException {
        Tb_info tb_info = new Tb_info();
        Field field = Tb_info.class.getDeclaredField(type);
        field.setAccessible(true);
        field.set(tb_info, key);
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Tb_info> tb_infos = infoDao.selectByAll(tb_info);
        PageInfo<Tb_info> tb_infoPageInfo = new PageInfo<>(tb_infos);
        return new Result(tb_infoPageInfo);
    }

    /**
     * 模糊查询
     * @param page
     * @param type
     * @param key
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public Result selectByLike(Page page, String type, String key) throws NoSuchFieldException, IllegalAccessException {
        Tb_info tb_info = new Tb_info();
        Field field = Tb_info.class.getDeclaredField(type);
        field.setAccessible(true);
        field.set(tb_info, key);
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Tb_info> tb_infos = infoDao.selectByLike(tb_info);
        PageInfo<Tb_info> tb_infoPageInfo = new PageInfo<>(tb_infos);
        return new Result(tb_infoPageInfo);
    }

}
