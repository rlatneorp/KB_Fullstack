package org.scoula.ex04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//    속성 설정 (키,밸류)
//    의미없음. request로 보낸 곳을 벗어나면 request는 끝이나서 null이 됨
        request.setAttribute("username", "홍길동");
        request.setAttribute("useraddress", "서울");
    // forward
    // response.jsp로 요청을 전달할 RequestDispatcher를 가져온다.
         RequestDispatcher dis = request.getRequestDispatcher("/response.jsp");
    // request와 response를 포워딩시킨다
         dis.forward(request, response);
    }
}
