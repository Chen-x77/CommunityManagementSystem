package com.chen.mapper;


import com.chen.entity.college;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface collegeMapper {
    college getCollegeById(Integer id);
}
