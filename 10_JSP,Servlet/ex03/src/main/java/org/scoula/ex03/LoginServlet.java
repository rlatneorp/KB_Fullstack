package org.scoula.ex03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
//    get 메서드로 보낸 데이터를 받아오기 위해서는 doGet 메소드 사용
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        요청에서 파라미터 얻기
        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");

//        응답 내보내기
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("아이디값: " + userid + "<br>");
        out.print("비밀번호값: " + passwd + "<br>" );
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        post 메소드의 경우 기본값 인코딩은 한글이 깨지므로 UTF-8 변경 필수
//        request.setCharacterEncoding("UTF-8");
//        get 메서드와 동일한 로직을 처리하고 싶으므로 doGet 호출
        doGet(request, response);
    }
}
