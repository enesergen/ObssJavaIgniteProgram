package com.example.servletthreadatmexample;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletAtm", value = "/ServletAtm")
public class ServletAtm extends HttpServlet {
    public int deger=400;
    @Override
    protected synchronized  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int param=Integer.parseInt(request.getParameter("money"));
        if(deger>=param){
            deger-=param;
            System.out.println("Para çekildi:"+param+" Yeni Bakiye:"+deger);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int param=Integer.parseInt(request.getParameter("money"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(param>=0){
            deger+=param;
        }
    }
}
