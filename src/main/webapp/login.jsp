<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: justinsortega
  Date: 2019-08-21
  Time: 09:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${param.uname == 'admin' && param.psw == 'password'}">
    <%
        response.sendRedirect("/profile.jsp");
    %>
    <h1>Worked!</h1>
</c:if>

<div class="container">
    <form name="submitForm" method="post" action="./login.jsp">
        <label>Username
            <input id="uname" type="text" placeholder="Enter Username" name="uname" required>
        </label>
        <label>Password
            <input id="psw" type="password" placeholder="Enter Password" name="psw" required>
        </label>
        <input type="hidden" name="param1" value="param1Value">
        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>
