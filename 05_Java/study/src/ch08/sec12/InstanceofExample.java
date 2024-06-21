package ch08.sec12;

public class InstanceofExample {
    public static void main(String[] args) {
        //구현 객체 생성
        Taxi taxi = new Taxi();
        Bus bus = new Bus();

        //ride() 메소드 호출 시 구현 객체를 매개값으로 전달
        ride(taxi);
        System.out.println();
        ride(bus);
    }
    // 무조건 큰 interface를 넣어준다
    public static void ride(Vehicle vehicle) {
//      if(vehicle instanceof Bus){
//        Bus bus = (Bus) vehicle;
//        bus.checkFace();
//     }

        // 위의 코드와 동일
//        instanceof : 해당 객체의 타입을 체크해준다
//        형변환 시 에러 발생을 방지해줌
        if(vehicle instanceof Bus bus){
            bus.checkFace();
        }
        vehicle.run();
    }
}
