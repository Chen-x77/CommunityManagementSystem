package com.chen.mapper.files;

import com.chen.entity.files;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface filesMapper {

   //上传文件
   Integer addCommFiles(files files);

   //找到文件
   files getFilebyId(Integer id);

   List<files> findCommFileslist(Integer com_id);
   //删除文件
   Integer delfile(Integer id);


   List<files> queryCommFileslistByName(Integer com_id,String name);
}
