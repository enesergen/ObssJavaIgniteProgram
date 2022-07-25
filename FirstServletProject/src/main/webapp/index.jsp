<%@ page contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%
    String name="obss";
    System.out.println(name);
%>
</h1>
<form action="<%=request.getContextPath()%>/hello-servlet" method="post">
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