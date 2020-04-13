package com.schoolmanager.service;

import com.github.pagehelper.PageInfo;
import com.schoolmanager.entity.SchoolRepair;
import com.schoolmanager.entity.SchoolUserinfo;

import java.util.List;

public interface SchoolOrderService {

    public Integer removeById(String id);

    public List<SchoolRepair> listOrder();

    /**
     * 查询所有用户
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<SchoolRepair> showOrders(Integer page, Integer pageSize);

    /**
     * 模糊查询
     * @param repairUserName
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<SchoolRepair> selectOrderLike(String repairUserName,Integer page, Integer pageSize,String repairType);

    public  int saveOrder(SchoolRepair schoolRepair);

    /**
     * 编辑维修单
     * @param schoolRepair
     * @return
     */
    public int editOrder(SchoolRepair schoolRepair);

    /**
     * 根据ID查询维修单
     * @param id
     * @return
     */
    SchoolRepair getOrderById(String id);
}
