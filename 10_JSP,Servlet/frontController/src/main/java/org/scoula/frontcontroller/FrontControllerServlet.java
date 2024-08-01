package org.scoula.frontcontroller;

import org.scoula.command.Command;
import org.scoula.controller.HomeController;
import org.scoula.controller.TodoController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class FrontControllerServlet extends HttpServlet {
   Map<String, Command> getMap;
   Map<String, Command> postMap;

   String prefix = "/WEB-INF/views/";
   String suffix = ".jsp";

   HomeController homeController = new HomeController();
   TodoController todoController = new TodoController();

   private String getCommandName(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
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


    @Override
    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();

        getMap.put("/", homeController::getIndex);

        getMap.put("/todo/list", todoController::getList);
        getMap.put("/todo/view", todoController::getView);
        getMap.put("/todo/create", todoController::getCreate);
        getMap.put("/todo/update", todoController::getUpdate);

        postMap.put("/todo/create", todoController::postCreate);
        postMap.put("/todo/update", todoController::postUpdate);
        postMap.put("/todo/delete", todoController::postDelete);
    }

    public void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewName = command.execute(request, response);
        if(viewName.startsWith("redirect:")){
            response.sendRedirect(viewName.substring("redirect:".length()));
        } else{
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
