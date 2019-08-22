<%--
  Created by IntelliJ IDEA.
  User: justinsortega
  Date: 2019-08-21
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="kid-dash.jsp" %>
    <link rel="stylesheet" href="css/main.css">
    <c:if test="${param.isKid == true}">
        <link rel="stylesheet" href="css/kid.css">
    </c:if>
    <title>Title of Page</title>
</head>
<body>
</body>
</html>
