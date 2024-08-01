package org.scoula.frontcontroller;

import org.scoula.DispatcherServlet;
import org.scoula.command.Command;
import org.scoula.controller.HomeController;
import org.scoula.controller.TodoController;
import javax.servlet.annotation.WebServlet;
import java.util.Map;

@WebServlet("/")
public class FrontControllerServlet extends DispatcherServlet {
   HomeController homeController = new HomeController();
   TodoController todoController = new TodoController();

    @Override
    public void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {
        getMap.put("/", homeController::getIndex);

        getMap.put("/todo/list", todoController::getList);
        getMap.put("/todo/view", todoController::getView);
        getMap.put("/todo/create", todoController::getCreate);
        getMap.put("/todo/update", todoController::getUpdate);

        postMap.put("/todo/create", todoController::postCreate);
        postMap.put("/todo/update", todoController::postUpdate);
        postMap.put("/todo/delete", todoController::postDelete);
    }
}
