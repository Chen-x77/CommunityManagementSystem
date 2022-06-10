package com.chen.service;

import com.chen.entity.admin;
import com.chen.entity.college;
import com.chen.entity.people;

import java.util.List;

public interface loginService {
    //社团登录接口
    admin adminLogin(String userName, String passWord);
    //教师登录接口
    people peoLogin(String userName);

    //注册
    boolean register(people people);

    List<college> finCollegesList();

    Boolean adminUpdatePwd(Integer id, String newpassword);

}
