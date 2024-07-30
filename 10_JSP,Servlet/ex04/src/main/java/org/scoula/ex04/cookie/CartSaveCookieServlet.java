package org.scoula.ex04.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_save_cookie")
public class CartSaveCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String product = request.getParameter("product");

//        request에서 모든 쿠키를 가져온다
        Cookie[] cookies = request.getCookies();
        Cookie c = null;
        if(cookies == null || cookies.length == 0){
//            쿠키가 하나도 없을때 새로운 쿠키를 생성한다
            c = new Cookie("product", product);
        } else {
//            쿠키가 있으면 쿠키의 길이로 인덱스를 넣어준다
//            Cookie의 개수가 4개일때는 ("product5",product)
            c = new Cookie("product" + (cookies.length + 1), product);
        }

        //쿠키를 응답처리
//        쿠키의 유효기간 설정해주는 메소드, 해당 메소드를 추가하면 OS파일에 쿠키가 저장된다
//        헤당 메소드가 없으면 기본적으로 메모리에 저장돼서 브라우저 종료시 쿠키가 사라진다
//        c.setMaxAge(60*60);

//        response에 쿠키를 추가해준다
        response.addCookie(c);

        out.print("<html><body>");
        out.print("Product 추가! <br>");
        out.print("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_view_cookie'>장바구니 보기</a>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
