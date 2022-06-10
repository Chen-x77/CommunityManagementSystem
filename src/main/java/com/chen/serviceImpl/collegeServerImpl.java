package com.chen.serviceImpl;
import com.chen.entity.college;
import com.chen.mapper.collegeMapper;
import com.chen.service.collegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class collegeServerImpl implements collegeService {

    @Autowired
    private collegeMapper collegeMapper;
    @Override
    public college getCollegeById(Integer id) {
        System.out.println("查询："+id);
        return collegeMapper.getCollegeById(id);
    }
}
