package com.chen.mapper;

import com.alibaba.fastjson.JSONObject;
import com.chen.entity.admin;
import com.chen.entity.college;
import com.chen.entity.people;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: community
 * @description: 会费收入支出情况
 * @author: wangshilei
 * @create: 2020-05-28 12:05
 **/
@Mapper
public interface loginMapper {

    //社团登录管理
    admin adminLogin (String userName, String passWord);

    //成员登录
    people peoLogin(String userName);

    //注册
    Integer register(people people);
    //获取学院列表
    List<college> finCollegesList();

    Integer adminUpdatePwd(Integer id, String newpassword);

}
