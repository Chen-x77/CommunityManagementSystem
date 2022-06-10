package com.chen.service.activity;


import com.chen.entity.activity;

import java.util.List;

public interface activityService {

    //找到社团活动记录
    List<activity> findCommActivityList(Integer com_id);

    //找到活动记录
    activity findCommActivityById(Integer id);

    //删除活动记录
    boolean delCommActivityById(Integer id);


    //活动申请
    Boolean addCommActivity(activity activity);

    //修改状态和审批意见
    Boolean updataActivity(activity activity);
    //根据状态找到活动列表
    List<activity> findActivityListByState(Integer state);
    //社团管理员查询活动记录
    List<activity> queryCommActivityList(Integer com_id,String name);
    //系统管理员查询活动记录
    List<activity> findActivityListByNameState(String name,Integer state);
}
