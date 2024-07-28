<%--
  Created by IntelliJ IDEA.
  User: wwSSS
  Date: 2024/7/25
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies=request.getCookies();
    if (cookies != null) {
        for (Cookie cookie:cookies) {
            if ("username".equals(cookie.getName())){
                String v1=cookie.getValue();
                request.setAttribute("username",v1);
            }
            if ("password".equals(cookie.getName())){
                String v2=cookie.getValue();
                request.setAttribute("password",v2);
            }

        }
    }
%>
<form action="/user">
    <input type="hidden" name="f" value="login"><br>
    <span style="color: red">${message}</span><br>
    账号：<input type="text" name="username" value="${username}" placeholder="请输入账号信息"><br>
    密码：<input type="password" name="password" value="${password}" placeholder="请输入密码"><br>
    <input type="checkbox" name="remember">是否记住密码？<br>
    <button>登录</button>
</form>
</body>
</html>
