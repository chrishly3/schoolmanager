package com.schoolmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.schoolmanager.dao.SchoolOrderMapper;
import com.schoolmanager.dao.SchoolUserInfoMapper;
import com.schoolmanager.entity.SchoolRepair;
import com.schoolmanager.entity.SchoolUserinfo;
import com.schoolmanager.service.SchoolOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolOrderServiceImpl implements SchoolOrderService {

    @Autowired
    private SchoolOrderMapper orderMapper;
    private final Logger logger = LoggerFactory.getLogger(SchoolOrderServiceImpl.class);

    /**
     * 逻辑删除用户
     * @param id
     * @return
     */
    @Override
    public Integer removeById(String id) {
        return orderMapper.removeById(id);
    }

    @Override
    public List<SchoolRepair> listOrder() {
        return orderMapper.listOrder();
    }

    /**
     * 查询所有报修单
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<SchoolRepair> showOrders(Integer page, Integer pageSize) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10: pageSize;
        System.out.println(page + "--"+pageSize);
        //在帮助类中传入分页参数
        PageHelper.startPage(page, pageSize);
        List<SchoolRepair> list = orderMapper.listOrder();
        System.out.println("list  :  "+list);
        PageInfo<SchoolRepair> pageList = new PageInfo<SchoolRepair>(list);
        return pageList;
    }

    /**
     * 模糊查询
     * @param repairUserName
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<SchoolRepair> selectOrderLike(String repairUserName,Integer page, Integer pageSize,String repairType) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10: pageSize;
        System.out.println(page + "--"+pageSize);
        //在帮助类中传入分页参数
        PageHelper.startPage(page, pageSize);
        List<SchoolRepair> list =orderMapper.selectOrderLike("%"+repairUserName+"%","%"+repairType+"%");
        System.out.println("list  :  "+list);
        PageInfo<SchoolRepair> pageList = new PageInfo<SchoolRepair>(list);
        return pageList;
    }

    /**
     * 添加维修单
     * @param schoolRepair
     * @return
     */
    @Override
    public  int saveOrder(SchoolRepair schoolRepair){
        return orderMapper.saveOrder(schoolRepair);
    }

    @Override
    public int editOrder(SchoolRepair schoolRepair) {
        return orderMapper.editOrder(schoolRepair);
    }

    @Override
    public SchoolRepair getOrderById(String id) {
        return orderMapper.getOrderById(id);
    }

}
