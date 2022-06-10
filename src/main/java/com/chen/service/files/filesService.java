package com.chen.service.files;
import com.chen.entity.files;

import java.util.List;

public interface filesService {

    //添加文件
    Boolean addCommFiles(files files);
    //找到文件
    files getFilebyId(Integer id);

    List<files> findCommFileslist(Integer com_id);

   Boolean delfile(Integer id);

    List<files> queryCommFileslistByName(Integer com_id,String name);

}
