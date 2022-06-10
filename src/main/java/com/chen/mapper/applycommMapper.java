package com.chen.mapper;

import com.chen.entity.applycomm;
import com.chen.entity.people;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface applycommMapper {
    //入社申请
    Integer addApplycomm(applycomm applycomm);

    //查询此人是否又申请信息
    applycomm getApplycommByPeoid(Integer peo_id);

    //查看入社申请
   List<applycomm> finApplycommList(Integer com_id);

   Integer delApplycomm(Integer id);

}
