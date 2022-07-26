<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Context and Initialization Servlet Parameters</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<form action="${pageContext.request.contextPath}/hello-servlet" method="get">
    <label for="name"><strong>Name:</strong></label>
    <input type="text" name="name" id="name">
    <br><br>
    <label for="email"><strong>Email:</strong></label>
    <input type="text" name="email" id="email">
    <br><br>
    <input type="submit" value="Login">
</form>
</body>
</html>