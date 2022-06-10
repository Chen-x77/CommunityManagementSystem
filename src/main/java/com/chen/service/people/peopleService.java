package com.chen.service.people;
import com.chen.entity.comm;
import com.chen.entity.people;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

public interface peopleService {

    //查询某社团成员
    List<people>queryPeopleList(Integer com_id);

    //查询所有成员
    List<people>findPeopleList();

    //账号查询成员
    people findPeopleByUserName(String userName);

    //根据姓名模糊查询某社团成员
    List<people> queryCommPeopleListByName(Integer com_id,String name);

    //更具id查询用户
    people findPeopleById(Integer id);
    //修改成员信息
    Boolean updatePeople(people people);
    //把成员置为普通用户
    boolean delCommPeople(Integer com_id, Integer peo_id);

    //根据权限查询社团负责人
    people findPeopleByFlag(Integer comm_id,Integer flag);




}
