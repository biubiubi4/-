<%--
  Created by IntelliJ IDEA.
  User: 石头哥
  Date: 2025/11/5
  Time: 上午12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>酒店客房预订系统 - 登录</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">登录</h2>
    <form action="LoginServlet" method="post">
        <div class="form-group">
            <label for="username">用户名：</label>
            <input type="text" class="form-control" name="username" id="username" required>
        </div>
        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" class="form-control" name="password" id="password" required>
        </div>
        <div class="form-group">
            <label for="role">身份：</label>
            <select class="form-control" name="role" id="role">
                <option value="user">用户</option>
                <option value="admin">管理员</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">登录</button>
        <a href="register.jsp" class="btn btn-link">没有账号？去注册</a>
    </form>
    <%
        String error = (String) request.getAttribute("error");
        if(error != null){
    %>
    <div class="alert alert-danger mt-3"><%= error %></div>
    <% } %>
</div>
</body>
</html>