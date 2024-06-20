package ch07.sec08.exam02;

public class DriverExample {
    public static void main(String[] args) {
        // Driver 객체 생성
        Driver driver = new Driver();
        // 매개값으로 Bus 객체를 제공하고 dirver() 메서드 호출
        Bus bus = new Bus();
        // driver.drive(new Bus()); 와 동일
        driver.drive(bus);

        // 매개값으로 Taxi 객체를 제공하고 dirver() 메서드 호출
        Taxi taxi = new Taxi();
        // driver.drive(new Taxi()); 와 동일
        driver.drive(taxi);

    }
}
