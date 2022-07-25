package com.example.firstservletproject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=ISO-8859-9");
        response.setCharacterEncoding("ISO-8859-9");
        request.setCharacterEncoding("ISO-8859-9");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=ISO-8859-9");
        response.setCharacterEncoding("ISO-8859-9");
        request.setCharacterEncoding("ISO-8859-9");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Registration Informations" + "</h1>");
        out.println("<p>"+"Name:"+name+"</p>");
        out.println("<p>"+"Name:"+surname+"</p>");
        out.println("<p>"+"Name:"+password+"</p>");
        out.println("</body></html>");
        System.out.println(name);
        System.out.println(surname);
        System.out.println(password);
    }



    public void destroy() {
    }
}