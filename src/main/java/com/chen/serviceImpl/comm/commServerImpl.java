package com.chen.serviceImpl.comm;
import com.chen.entity.comm;
import com.chen.mapper.comm.commMapper;
import com.chen.service.comm.commService;
import com.chen.until.pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


@Service
public class commServerImpl implements commService {
    @Autowired
    private commMapper commMapper;
    @Resource
    private pages pages;
    @Override
    public boolean addComm(comm comm) {
        int flag=commMapper.addComm(comm);
        if(flag>0){
            return true;
        }
        return false;
    }

    @Override
    public comm findComm(String name) {
        return commMapper.findComm(name);
    }
    @Override
    public List<comm> findCommList() {
        return commMapper.findCommList();
    }

    @Override
    public boolean delComm(Integer id) {
        int flag=commMapper.delComm(id);
        if(flag>0){
            System.out.println("删除成功");
            return true;
        }else {
            System.out.println("删除失败");
        }
        return false;

    }

    @Override
    public boolean delCommOfficeALL(Integer com_id) {
        int n=commMapper.delCommOfficeALL(com_id);
        if(n>0){
            return true;
        }
        return false;
    }
    @Override
    public comm getCommById(Integer id) {
        return commMapper.getCommById(id);
    }

    //修改社团
    @Override
    public Boolean updataComm(comm comm) {
        int n=commMapper.updataComm(comm);
        if(n>0){
            System.out.println("修改成功");
            return true;
        }
        System.out.println("修改失败");
        return false;
    }

    //根据名字模糊匹配社团
    @Override
    public List<comm>queryCommList(String name){
        return commMapper.queryCommList(name);
    }
}

