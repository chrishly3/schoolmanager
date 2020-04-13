package com.schoolmanager.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.Entity;
import javax.persistence.Id;

@EntityScan
@Entity
@Data
public class SchoolToken {

  @Id
  private long id;
  private String tokenType;
  private long buildTime;
  private String accessToken;


}
