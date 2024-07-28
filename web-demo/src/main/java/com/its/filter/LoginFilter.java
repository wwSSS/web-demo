package com.its.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session=request.getSession();
        String path=request.getRequestURI();
        System.out.println("path = "+path);
        //白名单
        List<String> whiteList=new ArrayList<>();
        whiteList.add("/");
        whiteList.add("/login.jsp");
        whiteList.add("/login");
        if (whiteList.contains(path)) {
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            //白名单外，要验证
            Object user =session.getAttribute("user");
            if (user == null) {
                //拦截
                request.setAttribute("message","非法入侵请重新登陆");
                request.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
