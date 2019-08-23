<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: justinsortega
  Date: 2019-08-23
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp" />
<h1>Apply Now for: <span>${sessionScope.program}</span></h1>

<form action="#">

    <c:if test="${sessionScope.program == 'DS'}">
        <label for="q1">Do you know Python?</label>
        <select name="q1" id="q1">
            <option value="1">yes</option>
            <option value="0">no</option>
        </select>
    </c:if>

    <label for="q2">Do you like solving problems?</label>
    <select name="q2" id="q2">
        <option value="1">yes</option>
        <option value="0">no</option>
    </select>

</form>

<h3>Price: $<span>${price}</span>.00</h3>
</body>
</html>
