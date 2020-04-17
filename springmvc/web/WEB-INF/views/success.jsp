<%@ page import="java.text.SimpleDateFormat" pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lqk
  Date: 2020/3/20
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <h3>跳转成功</h3>

    time :    ${requestScope.time}
    <br>
    names:${requestScope.get("names")}
    <br>
    requestUSer : ${requestScope.user}
    <br>
    sessionUser : ${sessionScope.user}
<br>
requestString : ${requestScope.school}
sessionString : ${sessionScope.school}
    <br/><br/>

<fmt:bundle basename="i18n">
    <fmt:message key="i18n.Username"></fmt:message>
</fmt:bundle>
</body>
</html>
