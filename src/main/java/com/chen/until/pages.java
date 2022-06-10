package com.chen.until;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class pages {

    /*分页参数传递*/
    public Map getPages(int currentPage,int pageSize){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        return map;
    }
}
