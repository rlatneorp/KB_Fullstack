package ch07.sec08.exam02;

public class Driver {

    // 메서드 선언(클래스 타입의 매개변수를 가지고 있음)
    // DI, Injection, 주입받는다 => 외부 클래스에서 객체를 넘겨줌
    public void drive(Vehicle vehicle){
        vehicle.run();
    }
}
