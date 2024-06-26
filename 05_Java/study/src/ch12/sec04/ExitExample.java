package ch12.sec04;

public class ExitExample {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            System.out.println(i);
            if(i == 5){
                System.out.println("프로세스 강제 종료");
//              System.exit(): 프로세스를 강제로 종료시킨다. 0이 코드로 들어가면 정상 종료를 의미한다
                System.exit(0);
            }
        }
    }
}
