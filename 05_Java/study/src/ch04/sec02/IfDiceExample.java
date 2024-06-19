package ch04.sec02;

public class IfDiceExample {
    public static void main(String[] args) {
        // Math.random() 함수는 0.0에서 1.0사이의 수를 랜덤 생성한다.
        // 원하는 범위의 수를 곱해준 후 1 더해주면 원하는 범위 생성이 가능하다/
        int num = (int)(Math.random()*6) + 1;
        if(num==1) {
            System.out.println("1번이 나왔습니다.");
        } else if(num==2) {
            System.out.println("2번이 나왔습니다.");
        } else if(num==3) {
            System.out.println("3번이 나왔습니다.");
        } else if(num==4) {
            System.out.println("4번이 나왔습니다.");
        } else if(num==5) {
            System.out.println("5번이 나왔습니다.");
        } else {
            System.out.println("6번이 나왔습니다.");
        }
    }
}


