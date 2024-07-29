package org.scoula.ex3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sports")
public class SportsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String[] sports = request.getParameterValues("sports");
        String sex = request.getParameter("sex");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        if(sports != null) {
            for (String sport : sports) {
                out.print("좋아하는 운동: " + sport + "<br>");
            }
        }
        out.print("성별 :" + sex + "<br>");
        out.print("</body></html>");
    }
}
