package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    ServletContext sc;

//    설정에 있는 application scope 를 sc에 할당해서 초기화 해준다
    @Override
    public void init(ServletConfig config) throws ServletException {
        sc = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        applicatin scope에 속성 설정
        sc.setAttribute("scopeName", "applicationScope 값");

//        현재 세션을 가져오거나 존재하지 않으면 새로 생성
        HttpSession session = request.getSession();
//        session scope에 속성 설정
        session.setAttribute("scopeName", "sessionScope 값");

//        request scope에 속성 설정
        request.setAttribute("scopeName", "requestScope 값");

        Member member = new Member("홍길동", "hong");
        request.setAttribute("member", member);

//        scope.jsp 화면 포워딩
        request.getRequestDispatcher("scope.jsp").forward(request, response);
    }

}
