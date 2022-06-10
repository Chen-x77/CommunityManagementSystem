package com.chen.serviceImpl;

import com.chen.entity.applycomm;
import com.chen.mapper.applycommMapper;
import com.chen.service.applycommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class applycommServiceImpl implements applycommService {
    @Autowired
    private applycommMapper applycommMapper;

    @Override
    public boolean addApplycomm(applycomm applycomm) {
        int n = applycommMapper.addApplycomm(applycomm);
        if (n > 0) return true;
        else return false;
    }

    @Override
    public applycomm getApplycommByPeoid(Integer peo_id) {
        return applycommMapper.getApplycommByPeoid(peo_id);
    }

    @Override
    public List<applycomm> finApplycommList(Integer com_id) {
        return applycommMapper.finApplycommList(com_id);
    }

    @Override
    public Boolean delApplycomm(Integer id) {
        int n = applycommMapper.delApplycomm(id);
        if (n > 0) return true;
        return false;
    }
}

