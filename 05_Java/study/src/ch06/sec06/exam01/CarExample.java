package ch06.sec06.exam01;

public class CarExample {
    public static void main(String[] args) {
        // Car 객체 생성
        Car myCar = new Car();

        // Car객체의 필드값 읽기
        // 필드에 접근할 때는 기본적으로 객체명으로 접근
        System.out.println("모델명: " + myCar.model);
        System.out.println("시동여부: " + myCar.start);
        System.out.println("현재속도: " + myCar.speed);
    }
}
