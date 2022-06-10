package com.chen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: community
 * @description: 学生社团
 * @author: wangshilei
 * @create: 2020-05-25 18:42
 **/
@Data
@Entity
public class comm {
    @Id
    private Integer id;//id
    private String name;//社团名称
    private Integer college;//所属学院
    private String teacher;//指导老师


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;//成立时间
    private Integer sum;//会员总数
    private String intro;//社团简介
    private Integer type;//社团类型

    private String collegeName;//所属学院
    //负责人在成员表中查 flag为1且com_id = id
    private String peoName; //负责人姓名
}
