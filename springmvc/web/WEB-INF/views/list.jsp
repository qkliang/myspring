<%--
  Created by IntelliJ IDEA.
  User: lqk
  Date: 2020/4/5
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工信息</title>
</head>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".delete").click(function(){
            var href = $(this).attr("href");
            $("form").attr("action", href).submit();
            return false;
        });
    })
</script>
<body>
    <a href="emp">新增员工</a>
    <br/> <br/>
    <form action="" method="POST">
        <input type="hidden" name="_method" value="DELETE"/>
    </form>
    <c:if test="${empty requestScope.employees}">
        没有任何员工信息
    </c:if>
    <c:if test="${!empty requestScope.employees}">
        <table border="1" cellpadding="1" cellspacing="1">
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>邮箱</td>
                <td>性别</td>
                <td>部门</td>
                <td>修改</td>
                <td>删除</td>
            </tr>
            <c:forEach items="${requestScope.employees}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>${emp.gender ==0 ? 'Female' : 'Male'}</td>
                    <td>${emp.department.departmentName}</td>
                    <td><a href="emp/${emp.id}">编辑</a> </td>
                    <td><a class="delete" href="emp/${emp.id}">删除</a> </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>

</html>
