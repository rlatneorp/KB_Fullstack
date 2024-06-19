package ch06.sec09;

public class Car {
    // 필드 선언
    String model;
    int speed;

    // 생성자 선언
    Car(String model){
        this.model = model;
    }

    // set 메소드 선언
    void setSpeed(int speed){
        this.speed = speed;
    }

    void run(){
        // 현재 객체의 speed를 100으로 변경
        this.setSpeed(100);
        System.out.println(this.model + "가 달립니다.(시속:" + this.speed + "km/h)");
    }
}
