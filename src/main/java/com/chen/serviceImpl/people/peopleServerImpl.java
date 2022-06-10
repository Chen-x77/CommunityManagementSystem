package com.chen.serviceImpl.people;

import com.chen.entity.people;
import com.chen.mapper.people.peopleMapper;
import com.chen.service.people.peopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class peopleServerImpl implements peopleService {
    @Autowired
    peopleMapper peopleMapper;

    //查询某社团成员
    @Override
    public List<people> queryPeopleList(Integer com_id) {
        return peopleMapper.queryPeopleList(com_id);
    }

    //查询成员
    @Override
    public List<people> findPeopleList() {
        return peopleMapper.findPeopleList();
    }

    @Override
    public List<people> queryCommPeopleListByName(Integer com_id, String name) {
        return peopleMapper.queryCommPeopleListByName(com_id,name);
    }

    @Override
    public people findPeopleByUserName(String userName) {
        return peopleMapper.findPeopleByUserName(userName);
    }
    //修改成员信息
    @Override
    public Boolean updatePeople(people people) {
        int n = peopleMapper.updatePeople(people);
        if (n > 0) {
            return true;
        }
        return false;
    }
    //把成员置为普通用户
    @Override
    public boolean delCommPeople(Integer com_id ,Integer peo_id) {
        int n=peopleMapper.delCommPeople(com_id,peo_id);
        if(n>0){
            return true;
        }
        return false;
    }

    @Override
    public people findPeopleByFlag(Integer comm_id, Integer flag) {
        return peopleMapper.findPeopleByFlag(comm_id,flag);
    }

    @Override
    public people findPeopleById(Integer id) {
        return peopleMapper.findPeopleById(id);
    }
}
