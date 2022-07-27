package com.example.servletwithdbexample.Servlets;

import com.example.servletwithdbexample.Contact.Contact;
import com.example.servletwithdbexample.DbOperation.DbOperations;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "update", value = "/update")
public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Contact contact=DbOperations.getOne(id);
        PrintWriter out=response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "UPDATE PAGE" + "</h1>");
        out.println("<form action=\"update\" method=\"POST\">");
        out.println("ID:"+"<input name=\"id\" type=\"text\" value="+contact.getId()+" readonly>");
        out.println("<br><br>");
        out.println("NAME:"+"<input name=\"isim\" type=\"text\" placeholder="+contact.getName()+">");
        out.println("<br><br>");
        out.println("TELEFON:"+"<input name=\"telefon\" type=\"text\" placeholder="+contact.getTelnumber()+">");
        out.println("<br><br>");
        out.println("<input type=\"submit\" values=\"Update\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        DbOperations.updateContact(new Contact(Integer.parseInt(request.getParameter("id")),request.getParameter("isim"),request.getParameter("telefon")));
        response.sendRedirect("http://localhost:8080/ServletWithDBExample_war_exploded/");

    }
}
