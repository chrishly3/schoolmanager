package com.schoolmanager.dao;

import com.schoolmanager.entity.SchoolUserinfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SchoolUserInfoMapper {

    /**
     * 编辑用户
     * @param schoolUserinfo
     * @return
     */
    @Update("update school_userinfo set " +
            "user_name=#{userName},user_type=#{userType},user_password=#{userPassword},user_code=#{userCode},user_stunum=#{userStunum} " +
            "where id=#{id}")
    int editUser(SchoolUserinfo schoolUserinfo);

    /**
     * 通过账号和密码查询用户
     * @param userName
     * @param passWord
     * @return
     */
    @Select("SELECT * FROM school_userinfo WHERE user_name = #{userName} AND user_password = #{passWord}")
    public SchoolUserinfo selectUserInfobyNameAndPwd(String userName, String passWord);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("Select * from school_userinfo where id=#{id} and def=0 ")
    SchoolUserinfo getUserById(String id);

    /**
     * 添加用户
     * @param userinfo
     * @return
     */
    @Insert("insert into school_userinfo(user_name,user_type,user_password,user_phone,user_code,user_stunum) values(#{userName},#{userType},#{userPassword},#{userPhone},#{userCode},#{userStunum})")
    public int saveUser(SchoolUserinfo userinfo);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from school_userinfo where def =0")
    public List<SchoolUserinfo> listUser();

    /**
     * 逻辑删除用户
     * @param id
     * @return
     */
    @Update("UPDATE school_userinfo SET def = 1 WHERE id=#{id}")
    Integer removeById(String id);

    /**
     * 查询用户总人数
     * @return
     */
    @Select("SELECT COUNT(*) FROM school_userinfo WHERE def=0")
    Long countUser();

    /**
     * 查询所有管理员信息 超级管理员除外
     * @return 管理员信息的集合
     */
    @Select("SELECT * FROM school_userinfo WHERE def=0")
    List<SchoolUserinfo> findAllUser(Integer startRow, Integer limit);


     @Select("select * from school_userinfo "
             + "where user_name like #{userName} and user_type like #{userType} and def = 0")
     List<SchoolUserinfo> selectUserLike(@Param("userName") String userName,@Param("userType") String userType);

}
