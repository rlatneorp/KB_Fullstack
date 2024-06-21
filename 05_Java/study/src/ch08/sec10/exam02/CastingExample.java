package ch08.sec10.exam02;

public class CastingExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();

        vehicle.run();
        // 상위 개념에서 만든 객체에선 하위 클래스 메서드 접근 불가능
        // vehicle.checkFace();

        // 강제 타입 변환후 호출
        // Bus 타입으로 변환 후에는 Bus 클래스의 메소드 사용 가능
        Bus bus = (Bus) vehicle;
        bus.run();
        bus.checkFace();
    }
}
