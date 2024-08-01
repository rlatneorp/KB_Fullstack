package org.scoula;

import org.scoula.command.Command;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {

    Map<String, Command> getMap;
    Map<String, Command> postMap;
//    뷰의 기본 경로와 확장자를 설정해준다
    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";

    private String getCommandName(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
//        substring(시작인덱스) : 해당 인덱스부터 문자열을 잘라준다
        return requestURI.substring(contextPath.length());
    }

    private Command getCommand(HttpServletRequest request){
        String commandName = getCommandName(request);

        Command command;
        if(request.getMethod().equalsIgnoreCase("GET")){
            command = getMap.get(commandName);
        } else{
            command = postMap.get(commandName);
        }
        return command;
    }

//    서블릿 초기화 메소드
    @Override
    public void init() {
//     map은 인터페이스이므로 구현 클래스인 HashMap으로 객체 생성
        getMap = new HashMap<>();
        postMap = new HashMap<>();
        createMap(getMap, postMap);
    }

    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap){}

    public void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewName = command.execute(request, response);
//        redirect로 처리할경우 view의 경로에서 "redirect:"를 제외하고 띄운다
        if(viewName.startsWith("redirect:")){
            response.sendRedirect(viewName.substring("redirect:".length()));
        } else{
//            forward로 처리할 경우
//            가지고 온 뷰의 이름에 "/views/"를 앞에 ".jsp"를 뒤에 붙여준다
            String view = prefix + viewName + suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = getCommand(request);
        if (command != null) {
            execute(command, request, response);
        } else {
            String view = prefix + "404" + suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
