package com.example.firstservletproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("name");
        String password=req.getParameter("password");
        if(password.equals("123") && name.equals("enes")) {
            req.getRequestDispatcher("Success.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("Error.jsp").forward(req,resp);

        }
    }
}
