package ch04.sec02;

public class IfElseExample {
    public static void main(String[] args) {
        int score = 85;
//        if-else문은 위의 if문이 ture일 경우 아래 조건을 ㅡ체크하지 않는다
        if(score > 90) {
            System.out.println("점수가 90보다 큽니다");
            System.out.println("등급은 A입니다");
        } else {
            System.out.println("점수가 90보다 작습니다.");
            System.out.println("등급은 B입니다.");
        }
    }
}
