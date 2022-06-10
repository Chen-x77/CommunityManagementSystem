package com.chen.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Data
@Entity
public class files {
    @Id
    private Integer id;//id
    private String path;//路径
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;//上传日期
    private String name;//名字
    private Integer peo_id;//上传人 （可以为null）
    private Integer com_id;//所属社团

    private Integer count; //计数器
    private String comName;//社团
    private String peoName;//上传人姓名
}
