<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ads</title>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<h2>${sessionScope.program}</h2>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">


        <h1>Welcome to the Adlister ${sessionScope.loggedIn}</h1>
    </div>
</body>
</html>
