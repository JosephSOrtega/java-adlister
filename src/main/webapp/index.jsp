<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/partials/header.jsp" %>
<%--or--%>
<%--    <jsp:include page="partials/header.jsp" />--%>

    <title><%= "some title" %>
    </title>

</head>
<body>
<c:if test="true">
    <h1>Variable names should be very descriptive</h1>
</c:if>
<c:if test="false">
    <h1>single letter variable names are good</h1>
</c:if>
<% request.setAttribute("message", "Hello, World!"); %>
...
<h1>Here is the message: ${message}</h1>

<%-- This assumes we are visiting a page and have ?page_no=5 (or something
     similar) appended to the query string --%>
<p>"page_no" parameter: ${param.page_no}</p>
<p>User-Agent header: ${header["user-agent"]}</p>


<%@ include file="/partials/scripts.jsp" %>

</body>
</html>
