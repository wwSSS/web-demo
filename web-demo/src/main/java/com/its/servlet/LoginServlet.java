package com.its.servlet;

import com.its.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        boolean b = userService.checklogin(username, password,request);
        if (b) {
            if ("on".equals(remember)){
                Cookie c1=new Cookie("username",username);
                Cookie c2=new Cookie("password",password);
                c1.setMaxAge(3600*24*30);
                c2.setMaxAge(3600*24*30);
                response.addCookie(c1);
                response.addCookie(c2);
            }
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("message","账号密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
