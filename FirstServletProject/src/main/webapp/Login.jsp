<%--
  Created by IntelliJ IDEA.
  User: ENES
  Date: 25.07.2022
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=request.getContextPath()%>
<form action="<%=request.getContextPath()%>/login" method="post">
    Name:<input type="text" name="name">
    Password:<input type="password" name="password">
    <input type="submit" value="Login">
</form>

</body>
</html>
