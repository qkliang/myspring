<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: lqk
  Date: 2020/4/5
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增员工</title>
</head>
<body>
<%
    HashMap<String, String> map = new HashMap<>();
    map.put("1","男");
    map.put("2","女");
    request.setAttribute("genders",map);
%>
    <form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">

        <table>
            <c:if test="${employee.id == null}">
            <tr>
                <td>lastName</td>
                <td><form:input path="lastName"></form:input></td>
            </tr>
            </c:if>
            <c:if test="${employee.id != null}">
                <form:hidden path="id" />
                <input type="hidden" name="_method" value="PUT"/>
            </c:if>
            <tr>
                <td>email</td>
                <td><form:input path="email"></form:input></td>
            </tr>
            <tr>
                <td>gender</td>
                <td><form:radiobuttons path="gender" items="${genders}"></form:radiobuttons></td>
            </tr>
            <tr>
                <td>birth</td>
                <td><form:input path="birth"></form:input></td>
            </tr>
            <tr>
                <td>salary</td>
                <td><form:input path="salary"></form:input></td>
            </tr>
            <tr>
                <td>department</td>
                <td><form:select path="department.id" items="${departments}"
                                 itemLabel="departmentName" itemValue="id"></form:select></td>
            </tr>

            <tr>
                <td colspan="2"><input type="submit" name="submit" value="submit"/></td>
            </tr>
        </table>

    </form:form>
</body>
</html>
