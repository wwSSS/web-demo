package com.its.service;

import com.its.dao.UserDao;

import javax.servlet.http.HttpServletRequest;

public class UserService {
    private UserDao userDao=new UserDao();
    public boolean checklogin(String username, String password, HttpServletRequest request) {
        return userDao.checklogin(username,password,request);

    }
}
