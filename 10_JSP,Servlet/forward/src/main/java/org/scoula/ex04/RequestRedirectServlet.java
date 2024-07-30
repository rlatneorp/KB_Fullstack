package org.scoula.ex04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/request_redirect")
public class RequestRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 해당 요청은 내부에서 쓰이지 않으므로 무의미하다
        request.setAttribute("username", "홍길동");
        request.setAttribute("useraddress", "서울");

        //response_redirect URL로 리다이렉트 시킨다.
        response.sendRedirect("response_redirect");

    }
}
