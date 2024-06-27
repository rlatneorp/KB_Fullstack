package ch14.sec03.exam01;

import java.awt.*;

public class BeepPrintExample {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // 하나의 메인 스레드에서 작동하므로 비프음 5번 발생 후 "띵" 5번 출력
        for(int i = 0; i < 5; i++){
            toolkit.beep(); // 비프음 발생
            try{Thread.sleep(500);}catch(Exception e){} // 0.5초간 일시정지
        }

        for(int i = 0; i < 5; i++){
            System.out.println("띵");
            try{Thread.sleep(500);}catch(Exception e){}
        }
    }
}
