package com.chen.serviceImpl;

import com.chen.entity.admin;
import com.chen.entity.college;
import com.chen.entity.people;
import com.chen.mapper.loginMapper;
import com.chen.service.loginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: community
 * @description: 登录接口实现
 * @author: wangshilei
 * @create: 2020-06-04 17:17
 **/

@Service
public class loginServerImpl implements loginService {

    @Resource
    private loginMapper login;
    @Override
    public admin adminLogin(String userName, String passWord) {
        return login.adminLogin(userName,passWord);
    }

    @Override
    public people peoLogin(String userName) {
        return login.peoLogin(userName);
    }

    @Override
    public boolean register(people people) {
        people.setFlag(0);
        people.setDate(new Date());
        System.out.println(people);
        int flag=login.register(people);

        if(flag>0){
            System.out.println("注册成功");
            return true;
        }else
        {
            System.out.println("注册失败");
        }
        return false;
    }

    @Override
    public Boolean adminUpdatePwd(Integer id, String newpassword) {
        int n=login.adminUpdatePwd(id,newpassword);
        if(n>0)return true;
        return false;
    }

    //获取学院列表
    @Override
    public List<college> finCollegesList() {
        return login.finCollegesList();
    }
}
