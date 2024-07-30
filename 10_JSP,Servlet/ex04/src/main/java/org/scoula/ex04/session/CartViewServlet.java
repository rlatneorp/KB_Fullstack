package org.scoula.ex04.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_view")
public class CartViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // MIME 타입 설정
        response.setContentType("text/html;charset=UTF-8");

        // 자바 I/O
        PrintWriter out = response.getWriter();

        // html 작성 및 출력
        out.print("<html><body>");
        out.print("장바구니 리스트");

        // 세션 객체 얻기
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(20); //20초

        if(session != null){
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");
            out.print("상품 : " + list + "<br>");
        } else {
            out.print("세션 없음" + "<br>");
        }

        out.print("<a href='session_product.jsp'> 상품 선택 페이지 </a><br>");
        out.print("<a href='cart_delete'>장바구니 비우기</a><br>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
