package com.schoolmanager.entity;


public class SchoolRepair {

  private long id;
  private String userCode;
  private String repairType;
  private String repairUserName;
  private String repairMessage;
  private java.sql.Timestamp repairDateTime;
  private String repairStatus;
  private java.sql.Timestamp creatTime;
  private java.sql.Timestamp updateTime;
  private String repairDoorNum;
  private long def;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getRepairDoorNum() {
    return repairDoorNum;
  }

  public void setRepairDoorNum(String repairDoorNum) {
    this.repairDoorNum = repairDoorNum;
  }

  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }


  public String getRepairType() {
    return repairType;
  }

  public void setRepairType(String repairType) {
    this.repairType = repairType;
  }


  public String getRepairUserName() {
    return repairUserName;
  }

  public void setRepairUserName(String repairUserName) {
    this.repairUserName = repairUserName;
  }


  public String getRepairMessage() {
    return repairMessage;
  }

  public void setRepairMessage(String repairMessage) {
    this.repairMessage = repairMessage;
  }


  public java.sql.Timestamp getRepairDateTime() {
    return repairDateTime;
  }

  public void setRepairDateTime(java.sql.Timestamp repairDateTime) {
    this.repairDateTime = repairDateTime;
  }


  public String getRepairStatus() {
    return repairStatus;
  }

  public void setRepairStatus(String repairStatus) {
    this.repairStatus = repairStatus;
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

}
