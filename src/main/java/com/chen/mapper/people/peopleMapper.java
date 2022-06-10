package com.chen.mapper.people;
import com.chen.entity.people;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface peopleMapper {

    //获取某社团成员列表
    List<people> queryPeopleList(Integer com_id);

    List<people> findPeopleList();

    //更具账号查询用户
    people findPeopleByUserName(String userName);

    //更具id查询用户
    people findPeopleById(Integer id);

    //根据姓名模糊查询某社团成员
    List<people> queryCommPeopleListByName(Integer com_id,String name);


    //修改账户
    Integer updatePeople(people people);

    //设置成员所属社团
    Integer delCommPeople(Integer com_id,Integer peo_id);

    //更具com_Id,flag查找社团负责人
    people findPeopleByFlag(Integer com_id,Integer flag);


}
