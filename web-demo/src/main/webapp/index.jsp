<%--
  Created by IntelliJ IDEA.
  User: wwSSS
  Date: 2024/7/24
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--<%--%>
<%--    Object user=session.getAttribute("user");--%>
<%--    if (user == null) {--%>
<%--        request.setAttribute("message","非法请求，请先登录否则后果自负");--%>
<%--        request.getRequestDispatcher("login.jsp").forward(request,response);--%>
<%--    }--%>
<%--%>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/user?f=logout">退出</a>
<center>
    <h1>热烈欢迎[${user.name}]登录系统</h1>
</center>

<form action="/demo" method="get">
    <input type="hidden" name="f" value="save">
    <input type="text" name="info"><br>
    <textarea name="remark"></textarea><br>
    <button>提交</button>
</form>
<hr>
<a href="/demo?f=query">查询</a>
</body>
</html>
