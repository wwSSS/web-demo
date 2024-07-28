package com.its.servlet;

import com.its.enities.Demo;
import com.its.service.DemoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    DemoService demoService = new DemoService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String f = request.getParameter("f");
        if ("save".equals(f)) {
            save(request, response);
        } else if ("update".equals(f)) {

        } else if ("query".equals(f)) {
            query(request, response);
        } else if ("delete".equals(f)) {

        } else {
            throw new RuntimeException("请传f标识");
        }
//        String info=req.getParameter("info");
//        String remark=req.getParameter("remark");
////        String add=req.getRemoteAddr();
////        System.out.println("add="+add);
//        System.out.println("info="+info);
//        System.out.println("remark="+remark);
//        Demo demo=new Demo();
//        demo.setInfo(info);
//        demo.setRemark(remark);
//        DemoService demoService=new DemoService();
//        boolean b=demoService.save(demo);
//        if (b) {
//            System.out.println("成功");
//        }else {
//            System.out.println("失败");
//        }
    }

    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Demo> list = demoService.query();
        for (Demo demo : list) {
            System.out.println("demo=" + demo);
        }
        request.setAttribute("list", list);
        request.getRequestDispatcher("demo-list.jsp").forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String info = request.getParameter("info");
        String remark = request.getParameter("remark");
//        String add=req.getRemoteAddr();
//        System.out.println("add="+add);
        System.out.println("info=" + info);
        System.out.println("remark=" + remark);
        Demo demo = new Demo();
        demo.setInfo(info);
        demo.setRemark(remark);
        DemoService demoService = new DemoService();
        boolean b = demoService.save(demo);
        if (b) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }
}
