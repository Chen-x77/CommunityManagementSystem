package com.chen.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class applycomm {
    @Id
    private  Integer id;
    private String introduce;  //自我介绍
    private Integer state;  //0没批准。1已经同意
    private Integer com_id;
    private Integer peo_id;

    private String comName;//社团
    private String peoName;//姓名
    private String peoUserName;//账号
    private String peoPhone;//联系电话

}
