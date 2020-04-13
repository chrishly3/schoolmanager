package com.schoolmanager.dao;

import com.schoolmanager.entity.SchoolRepair;
import com.schoolmanager.entity.SchoolUserinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SchoolOrderMapper {

    /**
     * 查询所有保修单
     * @return
     */
    @Select("select * from school_repair where def =0")
    public List<SchoolRepair> listOrder();

    /**
     * 逻辑删除报修单
     * @param id
     * @return
     */
    @Update("UPDATE school_repair SET def = 1 WHERE id=#{id}")
    Integer removeById(String id);

    /**
     * 模糊查询报修单
     * @param repairUserName
     * @param repairType
     * @return
     */
    @Select("select * from school_repair "
            + "where repair_userName like #{repairUserName} and repair_type like #{repairType} and def = 0")
    List<SchoolRepair> selectOrderLike(@Param("repairUserName") String repairUserName, @Param("repairType") String repairType);

    /**
     * 添加报修单
     * @param schoolRepair
     * @return
     */
    @Insert("insert into school_repair(repair_type,repair_doornum,repair_userName,repair_message,repair_dateTime,repair_status) values(#{repairType},#{repairDoorNum},#{repairUserName},#{repairMessage},#{repairDateTime},#{repairStatus})")
    public int saveOrder(SchoolRepair schoolRepair);

    @Update("update school_repair set " +
            "repair_userName=#{repairUserName},repair_type=#{repairType},repair_doornum=#{repairDoorNum},repair_message=#{repairMessage},repair_status=#{repairStatus} " +
            "where id=#{id}")
    int editOrder(SchoolRepair schoolRepair);

    /**
     * 根据id查询维修单
     * @param id
     * @return
     */
    @Select("Select * from school_repair where id=#{id} and def=0 ")
    SchoolRepair getOrderById(String id);


}
