package com.example.servletfunctionsexample;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet/*")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;");

        if(request.getRequestURL().toString().contains("secured")){
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }else {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + "Request URL:"+request.getRequestURL() + "</h1>");
            out.println("<h1>" + "getRequestURI:"+request.getRequestURI() + "</h1>");
            out.println("<h1>" + "getContextPath:"+request.getContextPath() + "</h1>");
            out.println("<h1>" + "getPathInfo:"+request.getPathInfo() + "</h1>");
            out.println("<h1>" + "getPathTranslated:"+request.getPathTranslated() + "</h1>");
            out.println("</body></html>");
        }


    }

    public void destroy() {
    }
}