package com.example.cookiesexample;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        Cookie c1=new Cookie("key",key);
        Cookie c2=new Cookie("value",value);
        //buraya setPath yazılabilir.

        response.addCookie(c1);
        response.addCookie(c2);
        response.sendRedirect("http://localhost:8080/CookiesExample_war_exploded/getCookies");

    }

    public void destroy() {
        }
}