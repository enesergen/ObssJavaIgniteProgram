<%--
  Created by IntelliJ IDEA.
  User: ENES
  Date: 28.07.2022
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

if(session.getAttribute("login")==null){
    response.sendRedirect("login.jsp");
}
%>
Welcome to Profile Page
Username:<%=session.getAttribute("login")%>
<hr>
<a href="logout">Logout</a>
</body>
</html>
