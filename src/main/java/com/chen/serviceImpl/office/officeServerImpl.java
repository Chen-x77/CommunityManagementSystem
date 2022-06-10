package com.chen.serviceImpl.office;

import com.chen.entity.office;
import com.chen.entity.people;
import com.chen.mapper.office.officeMapper;
import com.chen.service.office.officeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class officeServerImpl implements officeService {
    @Autowired
    private officeMapper officeMapper;

    @Override
    public Boolean addCommOffice(office office) {
        int n = officeMapper.addCommOffice(office);
        if (n > 0) return true;
        return null;
    }

    @Override
    public List<office> finCommOfficeList(Integer com_id) {
        return officeMapper.finCommOfficeList(com_id);
    }

    @Override
    public boolean delCommOffice(Integer id) {
        int n = officeMapper.delCommOffice(id);
        if (n > 0) return true;
        return false;
    }

    @Override
    public List<office> finCommOfficeBypeoId(Integer peoId) {
        return officeMapper.finCommOfficeBypeoId(peoId);
    }

}

