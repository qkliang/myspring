<%--
  Created by IntelliJ IDEA.
  User: lqk
  Date: 2020/3/20
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="emps"> 显示所有员工信息</a>

  <form action="testSessionAttribute" method="post">
      <input id="id" name="id" value="1" type="hidden"/><br/>
    姓名:<input type="text" name="username" value="Tom"><br/>
    email : <input type="text" name="email" value="Tom@qq.com"/><br/>
    age : <input type="text" name="age" value="12"/><br/>
    <input type="submit" value="提交">
  </form>
  <br/>

  <a href="testSessionAttributes">testSessionAttributes</a>
  <br/>

  <a href="testModelMap">testModelMap</a>
  <br/>

  <a href="testModelAndView">testModelAndView</a>
  <br/>

  <a href="testServletApi">testServletApi</a>
  <br/>
  <form action="testPojo" method="post">
      username : <input type="text" name="username" />
    password : <input type="password" name="password" />
    email : <input type="text" name="email" />
    age : <input type="text" name="age" />
    city: <input type="text" name="address.city">
    province: <input type="text" name="address.province">
    <input type="submit" name="提交" />
  </form>
  <br/>
  <a href="testRequestCookie">testRequestCookie</a>
  <br/>
  <a href="testRequestHeader">testRequestHeader</a>
  <br/>
  <a href="testRequestParam">testRequestParam</a>
  <br/>
  <form action="testRestPut/1" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="testRestPut"/>
  </form>
  <br/>
  <!--delete 请求 -->
  <form action="testRestDelete/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="testRestDelete">
  </form>
  <br/>
  <a href="testPathVariable/1"> testPathVariable </a>
  <br/>
    <form action="hello" method="get">

      <input type="submit" value="hello" />
    </form>
    <a href="hello">hello world</a>
  </body>
</html>
