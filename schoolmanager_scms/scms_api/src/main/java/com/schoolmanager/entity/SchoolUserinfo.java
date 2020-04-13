package com.schoolmanager.entity;

import org.hibernate.annotations.Parameter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;

@EntityScan
@Entity
public class SchoolUserinfo {

  @Id
  private long id;
  private String userName;
  private long userType;
  private String userPassword;
  private String userPhone;
  private String userCode;
  private java.sql.Timestamp creatTime;
  private java.sql.Timestamp updateTime;
  private String userStunum;

  private long def;

  public String getUserStunum() {
    return userStunum;
  }

  public void setUserStunum(String userStunum) {
    this.userStunum = userStunum;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public long getUserType() {
    return userType;
  }

  public void setUserType(long userType) {
    this.userType = userType;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }


  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }


  public java.sql.Timestamp getCreatTime() {
    return creatTime;
  }

  public void setCreatTime(java.sql.Timestamp creatTime) {
    this.creatTime = creatTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }


  public long getDef() {
    return def;
  }

  public void setDef(long def) {
    this.def = def;
  }

  @Override
  public String toString() {
    return "SchoolUserinfo{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", userType=" + userType +
            ", userPassword='" + userPassword + '\'' +
            ", userPhone='" + userPhone + '\'' +
            ", userCode='" + userCode + '\'' +
            ", creatTime=" + creatTime +
            ", updateTime=" + updateTime +
            ", userStunum='" + userStunum + '\'' +
            ", def=" + def +
            '}';
  }
}
