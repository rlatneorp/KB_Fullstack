package org.scoula.dynamicwep;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Servlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//       charset 설정 추가해야 한글 안 깨짐
        response.setContentType("text/html; charset=UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
        // servlet에서 html 코드를 쓰기 위해서는 out.println()을 사용해야 한다
        out.println("<html><body>");
        // 해당 부분에서 위에서 넣어준 message 변수를 가져옴
        out.println("<h1>" + message + "</h1>");
//        out.println("<a href=" + "/" + ">" + "Home" + "</a>");
//        중간에 " 작성할 경우 \ 역슬래쉬 필수
        out.println("<a href=\"/\">홈으로</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}