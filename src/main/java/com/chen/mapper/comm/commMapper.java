package com.chen.mapper.comm;

import com.chen.entity.comm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface commMapper {
    Integer addComm(comm comm);
    //根据名字找到社团
    comm findComm(String name);

    //根据名字模糊匹配社团
    List<comm>queryCommList(String name);

    comm getCommById(Integer id);
    //获取社团列表
    List<comm> findCommList();

    //删除社团

    Integer delComm(Integer id);
    Integer delCommOfficeALL(Integer com_id);

    //修改社团
    Integer updataComm(comm comm);
}
