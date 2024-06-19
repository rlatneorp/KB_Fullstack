package ch04.sec03;

public class SwitchExample {
    public static void main(String[] args) {
        // 1부터 6까지 랜덤생성
        int num = (int)(Math.random()*6) + 1;
        
        // 하나의 값으로 비교할 때 switch문을 많이 사용한다
//        break를 적어줘야 다음 케이스가 실행이 안된다
        switch(num) {
            case 1:
            System.out.println("1번이 나왔습니다.");
                break;
            case 2:
                System.out.println("2번이 나왔습니다.");
                break;
            case 3:
                System.out.println("3번이 나왔습니다.");
                break;
            case 4:
                System.out.println("4번이 나왔습니다.");
                break;
            case 5:
                System.out.println("5번이 나왔습니다.");
                break;
            default:
                System.out.println("6번이 나왔습니다.");
        }
    }
}
