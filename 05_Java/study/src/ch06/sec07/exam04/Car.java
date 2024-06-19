package ch06.sec07.exam04;

public class Car {
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    // 기본 생성자
    Car(){}

    // 생성자1 (파라미터 1개)
    Car(String model){
        this.model = model;
    }

    Car(String model, String color){
        this.model = model;
        this.color = color;
    }

    Car(String model, String color, int maxSpeed){
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
