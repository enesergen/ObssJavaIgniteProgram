package com.example.firstservletproject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "fourthPageTable",urlPatterns = "/fourthPageTable")
public class fourthPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("ISO-8859-9");
        req.setCharacterEncoding("ISO-8859-9");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<table style=\"border: 1px solid red;color: blue\">\n" +
                "    <tr>\n" +
                "        <th>Name</th>\n" +
                "        <th>Surname</th>\n" +
                "        <th>Password</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Enes</td>\n" +
                "        <td>Ergen</td>\n" +
                "        <td>*****</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Enes</td>\n" +
                "        <td>Ergen</td>\n" +
                "        <td>*****</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Enes</td>\n" +
                "        <td>Ergen</td>\n" +
                "        <td>*****</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Enesaaaaaaa</td>\n" +
                "        <td>Ergen</td>\n" +
                "        <td>*****</td>\n" +
                "    </tr>\n" +
                "</table>");
        out.println("</body></html>");

    }
}
