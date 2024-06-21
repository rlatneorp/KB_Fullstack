package cli.ui;

import cli.command.Command;

public class MenuItem {
    private String title;
    private Command cmd;

    public MenuItem(String title, Command cmd) {
        this.title = title;
        this.cmd = cmd;
    }

    public String getTitle(){
        return title;
    }
    void run(){
        if(cmd != null){
            cmd.excute();
        }
    }
}
