<%--
  Created by IntelliJ IDEA.
  User: wwSSS
  Date: 2024/7/25
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="margin: 0 auto" width="80%" cellpadding="5" cellspacing="0" border="1">
    <tr>
        <td>序号</td>
        <td>信息</td>
        <td>备注</td>
    </tr>

    <c:forEach items="${list}" var="demo" varStatus="i">
        <tr align="center">
            <td>${i.count}</td>
            <td>${demo.info}</td>
            <td>${demo.remark}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
