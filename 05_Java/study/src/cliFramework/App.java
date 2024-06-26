package cliFramework;

import cliFramework.command.*;
import cliFramework.ui.MenuItem;

public abstract class App {
    Menu menu;
    public App() {
    }
    public void init() {
        menu = new Menu();
        createMenu(menu);
        menu.add(new MenuItem("종료", new ExitCommand()));
    }
    public void createMenu(Menu menu) {
    }
    public void run() {
        init();
        while(true) {
            menu.printMenu();
            Command command = menu.getSelect();
            command.execute();
        }
    }
}