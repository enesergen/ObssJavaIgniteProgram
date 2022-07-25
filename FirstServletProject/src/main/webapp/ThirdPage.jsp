<%--
  Created by IntelliJ IDEA.
  User: ENES
  Date: 25.07.2022
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    Third Page
</h1>
<form action="<%=request.getContextPath()%>/thirdPage" method="get">
    Name:<input type="text" name="name">
    <br><br>
    Surname:<input type="text" name="surname">
    <br><br>
    Password:<input type="password" name="password">
    <br><br>
    <input type="submit" value="Register">

</form>
</body>
</html>
