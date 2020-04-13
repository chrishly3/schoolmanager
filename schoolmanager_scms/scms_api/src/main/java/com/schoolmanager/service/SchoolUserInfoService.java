package com.schoolmanager.service;


import com.github.pagehelper.PageInfo;
import com.schoolmanager.entity.SchoolUserinfo;
import utils.HttpCode.R;

import java.util.List;

/**
 * @author chrishly
 */
public interface SchoolUserInfoService {

    /**
     * 编辑用户
     * @param schoolUserinfo
     * @return
     */
    public int editUser(SchoolUserinfo schoolUserinfo);

    /**
     * 根据密码和账户名查询
     * @param userName
     * @param passWord
     * @return
     */
    public R getPersonExist(String userName, String passWord);

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    SchoolUserinfo getUserById(String id);

    /**
     * 添加用户
     * @param userinfo
     * @return 是否添加成功
     */
    public int saveUser(SchoolUserinfo userinfo);

    /**
     * 测试映射关系的查询用户总数
     * @return
     */
    List<SchoolUserinfo> listUser();

    /**
     * 根据ID逻辑删除
     * @param id
     * @return
     */
    Integer removeById(String id);

    /**
     * 查询所有用户
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<SchoolUserinfo> showUsers( Integer page, Integer pageSize);

    /**
     * 模糊查询
     * @param userName
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<SchoolUserinfo> selectUserLike(String userName,Integer page, Integer pageSize,String userType);

    /**
     * 用户总数
     * @return
     */
    Long countUser();


}
