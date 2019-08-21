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
<div class="container">
    <label><b>Username</b></label>
    <input id="uname" type="text" placeholder="Enter Username" name="uname" required>

    <label><b>Password</b></label>
    <input id="psw" type="password" placeholder="Enter Password" name="psw" required>

    <button id="submitter" type="submit">Login</button>

    <script>
        ${"#submitter"}.onclick(function () {
            $.post("http://localhost:8080/login", {username:${"#uname"}, password: ${"#psw"}}).then(function () {
                alert("success");
            })
        });
    </script>
</div>
</body>
</html>
