package com.chen.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @program: community
 * @description: 任职表
 * @author: wangshilei
 * @create: 2020-05-25 18:52
 **/

@Data
@Entity
public class office {
    @Id
    private Integer id;    //id
    private String name;    //部门名
    private String position;//职位
    private Integer com_id; //社团id   (联级删除 大量）
    private Integer peo_id; //负责人id  (联级删除 set null）

    private String comName; //社团名称
    private String peoName; //负责人姓名
    private String peoPhone;//负责人电话
}
