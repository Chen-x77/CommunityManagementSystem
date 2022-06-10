package com.chen.entity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class admin {
    @Id
    private Integer id;//编号
    private String userName;//账号
    private String passWord;//密码
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;     //创建日期
    private String name;     //姓名
}
