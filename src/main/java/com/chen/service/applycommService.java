package com.chen.service;

import com.chen.entity.applycomm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

public interface applycommService {
    //入社申请
    boolean addApplycomm(applycomm applycomm);

    //查询此人是否又申请信息
    applycomm getApplycommByPeoid(Integer peo_id);

    //申请列表查看
    List<applycomm> finApplycommList(Integer com_id);

    Boolean delApplycomm(Integer id);
}
