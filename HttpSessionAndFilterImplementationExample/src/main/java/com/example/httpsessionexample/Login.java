package com.example.httpsessionexample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        HttpSession session=req.getSession();
        if(username.equals("enes") && password.equals("123")){
            session.setAttribute("login",username);
            resp.sendRedirect("profile.jsp");

        }else{
            resp.sendRedirect("login.jsp");
        }
    }
}
