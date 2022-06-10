package com.chen.service.comm;

import com.chen.entity.comm;

import java.util.List;

public interface commService {
    //增加社团
    boolean addComm(comm comm);
    //查找该社团
    comm findComm(String name);
    //根据id查找社团
    comm getCommById(Integer id);

    //获取活动列表
    List<comm> findCommList();

    //删除社团
    boolean delComm(Integer id);

    boolean delCommOfficeALL(Integer com_id);

    //修改社团信息
    Boolean updataComm(comm comm);

    //根据名字模糊匹配社团
    List<comm>queryCommList(String name);

}
