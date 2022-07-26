package com.example.servletinitexample;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet", initParams = {
        @WebInitParam(name = "name", value = "obss"),
        @WebInitParam(name = "email", value = "info@obss.com.tr")}
)
public class HelloServlet extends HttpServlet {
    private String message;



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        if(request.getParameter("name").
                equals(getServletConfig().getInitParameter("name")) &&
                request.getParameter("email")
                        .equals(getServletConfig().getInitParameter("email"))
        ){
            request.getRequestDispatcher("ServletSuccess").forward(request, response);
        }else{
            request.getRequestDispatcher("ServletFail").forward(request, response);

        }

    }

    public void destroy() {
    }
}