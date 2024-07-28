package com.its.listener;

import com.its.enities.User;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.time.LocalDateTime;

@WebListener
public class LoginListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {

        HttpSession session=httpSessionBindingEvent.getSession();
        Object user =session.getAttribute("user");
        if (user != null) {
            User u=(User) user;
            System.out.println(LocalDateTime.now()+"["+u.getName()+"] ip地址：192.168.31.20");
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {


    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
