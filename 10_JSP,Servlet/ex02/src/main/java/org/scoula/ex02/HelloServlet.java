package org.scoula.ex02;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "MyServlet", urlPatterns = {"/xxx", "/yyy"})
public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        System.out.println("HelloServlet 요청");

        PrintWriter out = response.getWriter();
        out.println("<h1>Hello World!</h1>");
    }
//    서블릿 초기화 해주는 메서드
     @Override
     public void init() throws ServletException {
         System.out.println("init 호출");
     }
//    서블릿 제대로 종료됐을때 불러주는 메서드
     @Override
     public void destroy() {
         System.out.println("destroy 호출");
     }
 }