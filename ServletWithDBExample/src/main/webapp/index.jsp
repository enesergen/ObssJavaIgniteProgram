<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.servletwithdbexample.Contact.Contact" %>
<%@ page import="com.example.servletwithdbexample.DbOperation.DbOperations" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="AddContactServlet" method="post">
    Name:<input type="text" name="name">
    <br><br>
    Telefon:<input type="text" name="tel">
    <br><br>
    <input type="submit" value="Add Contact">
</form>

<TABLE style="border:black 1px solid">
    <TR>
        <th>ID</th>
        <th>NAME</th>
        <th>TEL</th>
        <th>EDIT</th>
    </TR>

        <% ArrayList<Contact> getAllContacts = DbOperations.getAllContact();
            for (int i = 0; i < getAllContacts.size(); i++) { %>
    <tr>
    <td>
            <%=getAllContacts.get(i).getId() %>
        </td>
        <td>
            <%=getAllContacts.get(i).getName() %>
        </td>
        <td>
            <%=getAllContacts.get(i).getTelnumber() %>
        </td>
        <td>
            <a href="http://localhost:8080/ServletWithDBExample_war_exploded/update?id=<%=getAllContacts.get(i).getId() %>">Edit</a>
        </td>
    </tr>
        <% } %>

</TABLE>


</body>
</html>