package com.its.service;

import com.its.dao.DemoDao;
import com.its.enities.Demo;

import java.util.List;

public class DemoService {
    DemoDao dao=new DemoDao();

    public  List<Demo> query() {
        return dao.query();
    }

    public boolean save(Demo demo) {

         boolean b=dao.save(demo);
         return b;
    }

}
