package com.chen.serviceImpl.activity;

import com.chen.entity.activity;
import com.chen.mapper.activity.activityMapper;
import com.chen.service.activity.activityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class activityServerImpl implements activityService {

    @Autowired
    private activityMapper activityMapper;

    @Override
    public List<activity> findCommActivityList(Integer com_id) {
        return activityMapper.findCommActivityList(com_id);
    }

    @Override
    public List<activity> queryCommActivityList(Integer com_id, String name) {
        return activityMapper.queryCommActivityList(com_id, name);
    }

    @Override
    public activity findCommActivityById(Integer id) {
        return activityMapper.findCommActivityById(id);
    }

    @Override
    public boolean delCommActivityById(Integer id) {
        int n = activityMapper.delCommActivityById(id);
        if (n > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean addCommActivity(activity activity) {
        int n = activityMapper.addCommActivity(activity);
        if (n > 0) {
            return true;
        }
        return null;
    }

    @Override
    public Boolean updataActivity(activity activity) {
        int n = activityMapper.updataActivity(activity);
        if (n > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<activity> findActivityListByState(Integer state) {
        return activityMapper.findActivityListByState(state);
    }

    @Override
    public List<activity> findActivityListByNameState(String name, Integer state) {
        return activityMapper.findActivityListByNameState(name,state);
    }
}

