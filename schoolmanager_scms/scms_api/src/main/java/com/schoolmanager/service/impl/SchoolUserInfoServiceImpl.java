package com.schoolmanager.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.schoolmanager.controller.SchoolUserInfoController;
import com.schoolmanager.dao.SchoolUserInfoMapper;
import com.schoolmanager.entity.Audience;
import com.schoolmanager.entity.SchoolToken;
import com.schoolmanager.entity.SchoolUserinfo;
import com.schoolmanager.service.SchoolUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.HttpCode.R;
import utils.JwtTokenUtil.CreateTokenUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SchoolUserInfoServiceImpl implements SchoolUserInfoService {
    @Autowired
    private SchoolUserInfoMapper userInfoMapper;
    private final Logger logger = LoggerFactory.getLogger(SchoolUserInfoServiceImpl.class);
    @Autowired
    private Audience audience;

    @Override
    public int editUser(SchoolUserinfo schoolUserinfo) {
        return userInfoMapper.editUser(schoolUserinfo);
    }

    /**
     * 根据用户名密码查询
     * @param userName
     * @param passWord
     * @return
     */
    @Override
    public R getPersonExist(String userName, String passWord) {
        logger.info("SchoolUserInfoServiceImpl-getPersonExist userName:{},passWord:{}",userName,passWord);
        SchoolUserinfo resultList = userInfoMapper.selectUserInfobyNameAndPwd(userName,passWord);
        Map<String,Object> map = new HashMap<>();
        //如果为空
        if(resultList == null){
            return R.error();
        }
        //将对象传入map
        map.put("resultList",resultList);
        //这里是生成token 存入了id,名字，还有时间，base64
        String accessToken = CreateTokenUtils
                .createJWT(userName,audience.getClientId(), audience.getName(),audience.getExpiresSecond() * 1000, audience.getBase64Secret());
        SchoolToken accessTokenEntity = new SchoolToken();
        accessTokenEntity.setAccessToken(accessToken);
        accessTokenEntity.setBuildTime(audience.getExpiresSecond());
        accessTokenEntity.setTokenType("bearer");
        map.put("accessToken",accessTokenEntity);
        return R.ok().data(map);
    }

    @Override
    public SchoolUserinfo getUserById(String id) {
        return userInfoMapper.getUserById(id);
    }

    @Override
    public int saveUser(SchoolUserinfo userinfo){

        return userInfoMapper.saveUser(userinfo);
    }

    @Override
    public List<SchoolUserinfo> listUser() {
        return userInfoMapper.listUser();
    }

    /**
     * 逻辑删除用户
     * @param id
     * @return
     */
    @Override
    public Integer removeById(String id) {
        return userInfoMapper.removeById(id);
    }


    /**
     * 查询所有人员
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<SchoolUserinfo> showUsers(Integer page, Integer pageSize) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10: pageSize;
        System.out.println(page + "--"+pageSize);
        //在帮助类中传入分页参数
        PageHelper.startPage(page, pageSize);
        List<SchoolUserinfo> list = userInfoMapper.listUser();
        System.out.println("list  :  "+list);
        PageInfo<SchoolUserinfo> pageList = new PageInfo<SchoolUserinfo>(list);
        return pageList;
    }

    /**
     * 模糊查询
     * @param userName
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<SchoolUserinfo> selectUserLike(String userName, Integer page, Integer pageSize,String userType) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10: pageSize;
        System.out.println(page + "--"+pageSize);
        //在帮助类中传入分页参数
        PageHelper.startPage(page, pageSize);
        List<SchoolUserinfo> list =userInfoMapper.selectUserLike("%"+userName+"%","%"+userType+"%");
        System.out.println("list  :  "+list);
        PageInfo<SchoolUserinfo> pageList = new PageInfo<SchoolUserinfo>(list);
        return pageList;
    }


    @Override
    public Long countUser() {
        return userInfoMapper.countUser();
    }


}
