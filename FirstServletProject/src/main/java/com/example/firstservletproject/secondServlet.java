package com.example.firstservletproject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "secondServlet",urlPatterns = "/secondServlet")
public class secondServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=ISO-8859-9");
        response.setCharacterEncoding("ISO-8859-9");
        request.setCharacterEncoding("ISO-8859-9");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Second Page" + "</h1>");
        out.println("</body></html>");
    }

    }

