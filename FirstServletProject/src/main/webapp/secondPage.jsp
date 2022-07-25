<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: ENES
  Date: 25.07.2022
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    <table>
        <tr>
            <td>input1:<input type="text"></td>
        </tr>
        <tr>
            <td>input1:<input type="radio"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>

<%
        PrintWriter printer2 = response.getWriter();
    for (int i=0;i<100;i++){
        printer2.write("selam\n");
    }
%>
</body>
</html>
