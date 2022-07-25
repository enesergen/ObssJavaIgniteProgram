package com.example.firstservletproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="thirdPage",urlPatterns = "/thirdPage")
public class ThirdPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=ISO-8859-9");
        response.setCharacterEncoding("ISO-8859-9");
        request.setCharacterEncoding("ISO-8859-9");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");

        System.out.println(name);
        System.out.println(surname);
        System.out.println(password);


    }
}
