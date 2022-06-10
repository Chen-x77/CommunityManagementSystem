package com.chen.mapper.activity;

import com.chen.entity.activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface activityMapper {

    //找到社团活动记录
    List<activity> findCommActivityList(Integer com_id);
    List<activity> queryCommActivityList(Integer com_id,String name);
    List<activity> findActivityListByNameState(String name,Integer state);

    //找到活动记录
    activity findCommActivityById(Integer id);
    //删除活动记录
    Integer delCommActivityById(Integer id);

    //活动申请
    Integer addCommActivity(activity activity);

    //修改状态和审批意见
    Integer updataActivity(activity activity);

    //根据状态找到活动列表
    List<activity> findActivityListByState(Integer state);
}
