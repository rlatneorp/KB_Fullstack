package org.scoula.ex05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/format")
public class FormatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        현재 날짜로 today 속성 셋팅
        req.setAttribute("today", new Date());

        req.getRequestDispatcher("format.jsp")
                .forward(req, resp);
    }
}
