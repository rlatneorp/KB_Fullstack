package org.scoula.lib.cli;

public abstract class Application {
    protected abstract void createMenu();

    public void init(){
        System.out.println("어플리케이션을 초기화합니다.");
        createMenu();
    }

    void cleanup(){
        System.out.println("어플리케이션을 정리합니다.");
    }

    public void run(){
       init();
       for(;;){
           if(Input.readInt("선택> ") == '0'){
                cleanup();
                break;
           }
           if(Input.readInt("선택> ") != '0'){
               System.out.println( "를 입력했습니다.");
           }
       }
    }
}
