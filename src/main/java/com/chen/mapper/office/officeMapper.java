package com.chen.mapper.office;

import com.chen.entity.office;
import com.chen.entity.people;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface officeMapper {
    //添加部门
    Integer addCommOffice(office office);

    //查找社团部门
    List<office> finCommOfficeList(Integer com_id);

    //删除部门
    Integer delCommOffice(Integer id);

    //查找成员任职信息
    List<office>finCommOfficeBypeoId(Integer peoId);

}
