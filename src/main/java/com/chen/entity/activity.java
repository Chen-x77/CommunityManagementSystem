package com.chen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: community
 * @description: 活动申请表
 * @author: wangshilei
 * @create: 2020-05-25 19:01
 **/
@Data
@Entity
public class activity {
    @Id
    private Integer id;
    private String name;//活动名称

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date_start;//开始时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date_stop;//结束时间

    private String location;//活动地点
    private String theme;//活动主题
    private String intros;//活动简介
    private String reply;  //批复意见

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;//申请时间

    private Integer state;//申请状态
    private Integer peo_id;//申请人ID
    private Integer com_id;//申请社团
    //附加属性
    private String comName;
    private String peoName;
    private String peoPhone;//联系方式
}

