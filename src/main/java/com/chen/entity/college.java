package com.chen.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class college {
    @Id
    private Integer id;//编号
    private String name;//名称

}
