package com.example.servletwithdbexample.Servlets;

import com.example.servletwithdbexample.Contact.Contact;
import com.example.servletwithdbexample.DbOperation.DBConnector;
import com.example.servletwithdbexample.DbOperation.DbOperations;
import org.postgresql.Driver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "AddContactServlet", value = "/elifnur")
public class AddContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        System.out.println(name);
        System.out.println(tel);

        try {
            DbOperations.addContact(new Contact(0,name,tel));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Contact contact:DbOperations.getAllContact()
             ) {
            System.out.println(contact.getName());
        }
        try {
            response.sendRedirect("http://localhost:8080/ServletWithDBExample_war_exploded/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
