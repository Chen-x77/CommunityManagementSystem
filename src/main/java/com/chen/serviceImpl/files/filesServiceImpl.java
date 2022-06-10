package com.chen.serviceImpl.files;
import com.chen.entity.files;
import com.chen.mapper.applycommMapper;
import com.chen.mapper.files.filesMapper;
import com.chen.service.files.filesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class filesServiceImpl implements filesService {
    @Autowired
    private filesMapper filesMapper;


    @Override
    public Boolean addCommFiles(files files) {
        int n=filesMapper.addCommFiles(files);
        if(n>0){
            return true;
        }
        return false;
    }

    @Override
    public files getFilebyId(Integer id) {
        return filesMapper.getFilebyId(id);
    }

    @Override
    public List<files> findCommFileslist(Integer com_id) {
        return filesMapper.findCommFileslist(com_id);
    }

    @Override
    public Boolean delfile(Integer id) {
        int n=filesMapper.delfile(id);
        if(n>0){
            return true;
        }
        return false;
    }

    @Override
    public List<files> queryCommFileslistByName(Integer com_id, String name) {
        return filesMapper.queryCommFileslistByName(com_id,name);
    }
}

