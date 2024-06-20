package ch07.sec10.exam01;

public class PhoneExample {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone("홍길동");
        // 추상 클래스는 객체 생성 불가능
        // Phone phone = new Phone();

        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.turnOff();
    }
}
