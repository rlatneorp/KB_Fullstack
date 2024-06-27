package ch14.sec03.exam02;

import java.awt.*;

public class BeepPrintExample {
    public static void main(String[] args) {
        // 작업 스레드를 따로 만들었기 때문에 비프음 작업과 출력 작업이 동시에 진행됨
        Thread thread = new Thread(new Runnable(){ // 작업 스레드 생성
            @Override
            public void run(){
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for(int i = 0; i < 5; i++){
                    toolkit.beep();
                    try{Thread.sleep(500);}catch(Exception e){}
                }
            }
        });
        thread.start(); // 작업 스레드 실행
        
        for(int i=0; i<5; i++) {
            System.out.println("띵");
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }
}
