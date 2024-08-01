package org.scoula.frontcontroller;

import org.scoula.DispatcherServlet;
import org.scoula.command.Command;
import org.scoula.controller.HomeController;
import org.scoula.controller.TodoController;
import javax.servlet.annotation.WebServlet;
import java.util.Map;

//경로 지정하는 방법은 두가지가 있다. 1) 디렉토리 기반, 2) 확장명 기반
//디렉토리 기반(/board), 확장명 기반(*.do)
@WebServlet("/")
public class FrontControllerServlet extends DispatcherServlet {
   HomeController homeController = new HomeController();
   TodoController todoController = new TodoController();

    @Override
    public void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {
//        "/" 경로로 HomeController의 getIndex 메소드를 찾을수 있다(메소드 참조)
//    put으로 Map에 아이템을 넣어준다
//        원래 아래의 코드
//        getMap.put("/", new Command() {
//            @Override
//            public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
//                return new HomeController().getIndex(request, response);
//            }
//        });
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
