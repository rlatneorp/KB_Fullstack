package org.scoula.ex04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/request_redirect")
public class RequestRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 속설 설정
        request.setAttribute("username", "홍길동");
        request.setAttribute("useraddress", "서울");

        //redirect
        response.sendRedirect("response_redirect");

    }
}
