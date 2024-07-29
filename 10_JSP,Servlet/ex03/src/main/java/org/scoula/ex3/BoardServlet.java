package org.scoula.ex3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<html><body>");

//        받아온 파라미터들의 이름말을 열거자로 만듬
        Enumeration<String> enu = request.getParameterNames();
//        hasMoreElements : 요소가 더 있는지 체크해서 없을때까지 돈다
        while(enu.hasMoreElements()){
//            nextElement : 열거자를 돌면서 다음 요소를 가져옴
            String name = enu.nextElement();
//            열거자에 저장된 이름으로 해당 값들을 가져옴
            String value = request.getParameter(name);

            out.print(name + " : " + value + "<br>");
        }

        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
