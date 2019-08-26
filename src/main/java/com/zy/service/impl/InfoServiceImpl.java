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
     * 判断查询类型，调用不同的查询方法
     *
     * @param page
     * @param type
     * @param key
     * @param searchType
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Override
    public Result select(Page page, String type, String key, String searchType) throws NoSuchFieldException, IllegalAccessException {
        Tb_info tb_info = new Tb_info();
        Field field = Tb_info.class.getDeclaredField(type);
        field.setAccessible(true);
        field.set(tb_info, key);
        if (searchType.equals("all")) {
            return selectByAll(page, tb_info);
        } else {
            return selectByLike(page, tb_info);
        }
    }

    /**
     * 全字匹配查询
     *
     * @param page
     * @param tb_info
     * @return
     */
    public Result selectByAll(Page page, Tb_info tb_info) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Tb_info> tb_infos = infoDao.selectByAll(tb_info);
        PageInfo<Tb_info> tb_infoPageInfo = new PageInfo<>(tb_infos);
        System.out.println("PageSize" + tb_infoPageInfo.getPageSize());
        return new Result(tb_infoPageInfo);
    }

    /**
     * 模糊查询
     *
     * @param page
     * @param tb_info
     * @return
     */
    public Result selectByLike(Page page, Tb_info tb_info) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Tb_info> tb_infos = infoDao.selectByLike(tb_info);
        PageInfo<Tb_info> tb_infoPageInfo = new PageInfo<>(tb_infos);
        return new Result(tb_infoPageInfo);
    }

    /**
     * 根据付费状态、审核状态查询信息
     *
     * @param page
     * @param tb_info
     * @return
     */
    @Override
    public Result selectAllByCheckPay(Page page, Tb_info tb_info) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Tb_info> tb_infos = infoDao.selectAllByCheckPay(tb_info);
        System.out.println(tb_infos);
        PageInfo<Tb_info> tb_infoPageInfo = new PageInfo<>(tb_infos);
        return new Result(tb_infoPageInfo);
    }

}
