package com.chen.service.office;


import com.chen.entity.files;
import com.chen.entity.office;
import com.chen.entity.people;

import java.util.List;

public interface officeService {

    //添加部门
    Boolean addCommOffice(office office);
    //查找社团部门
    List<office> finCommOfficeList(Integer com_id);
    //删除部门
    boolean delCommOffice(Integer id);

    //查找成员任职信息
    List<office>finCommOfficeBypeoId(Integer peoId);
}
