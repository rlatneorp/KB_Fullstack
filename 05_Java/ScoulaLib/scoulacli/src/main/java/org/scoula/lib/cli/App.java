package org.scoula.lib.cli;

import org.scoula.lib.cli.command.ExitCommand;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.ui.MenuItem;

public abstract class App {
    Menu menu;

    public App() {
    }

    public void init() {
        menu = new Menu();
        createMenu(menu);
//        모든 앱에 동일하게 들어갈 수 있는 종료 메뉴만 따로 빼둠
        menu.add(new MenuItem("종료", new ExitCommand()));
    }

    public void createMenu(Menu menu) {
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void run() {
//        ArrayList로 변하면서 초기에 크기를 지정해줄 필요가 없어짐
        init();
        while(true) {
            menu.printMenu();
            // 사용자가 입력한 번호에 해당하는 command 리턴
            Command command = menu.getSelect();
            command.execute();
        }
    }
}