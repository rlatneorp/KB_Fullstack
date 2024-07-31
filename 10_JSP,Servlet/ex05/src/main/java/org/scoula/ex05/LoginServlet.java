package org.scoula.ex05;

import org.scoula.ex05.domain.Member;
import org.scoula.ex05.dto.LoginDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");

        LoginDTO loginDTO = new LoginDTO(userid, passwd);

        request.setAttribute("userid", userid);
        request.setAttribute("passwd", passwd);

        request.setAttribute("login", loginDTO);

        HttpSession session = request.getSession();
        Member member = new Member("홍길동", userid);
        session.setAttribute("user", member);

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
