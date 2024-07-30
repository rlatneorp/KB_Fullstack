package org.scoula.ex04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/request_redirect")
public class ResponseRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getAttribute("username");
        String useraddress = (String) request.getAttribute("useraddress");

        //속성 설정
        request.setAttribute("username", username);
        request.setAttribute("useraddress", useraddress);

        //forward
        RequestDispatcher dis = request.getRequestDispatcher("/redirect_response.jsp");
        dis.forward(request, response);
    }

}
