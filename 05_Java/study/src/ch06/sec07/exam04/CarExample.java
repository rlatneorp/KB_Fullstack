package ch06.sec07.exam04;

public class CarExample {
    public static void main(String[] args) {
        // 같은 이름의 생성자를 여러개 만드는 것을 생성자 오버로딩이라고 한다
//        파라미터의 타입과 개수에 따라 알아서 적합한 생성자를 찾아간다.
        Car car1 = new Car();
        System.out.println("car.company : " + car1.company);
        System.out.println();

        Car car2 = new Car();
        System.out.println("car2.company : " + car2.company);
        System.out.println("car2.model : " + car2.model);
        System.out.println();

        Car car3 = new Car("자가용", "빨강");
        System.out.println("car3.company : " + car3.company);
        System.out.println("car3.model : " + car3.model);
        System.out.println("car3.color : " + car3.color);
        System.out.println();

        Car car4 = new Car("택시", "검정", 200);
        System.out.println("car4.company : " + car4.company);
        System.out.println("car4.model : " + car4.model);
        System.out.println("car4.color : " + car4.color);
        System.out.println("car4.maxSpeed : " + car4.maxSpeed);
    }


}
