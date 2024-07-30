package org.scoula.ex04.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_delete_cookie")
public class CartDeleteCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.print("<html><body>");
        // 기존 쿠기 얻기
        Cookie [] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie c : cookies) {
//                쿠키의 유효기간을 1초로 설정해서 사라지게 만든다
                c.setMaxAge(1);
                response.addCookie(c);
            }
        }
        out.print("장바구니 비었음<br>");
        out.print("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.print("</body></html>");
    }
}
