package ch08.sec11.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.run();
        // 기존에 있던 한국타이어를 금호타이어로 교체시킴
        myCar.tire1 = new KumhoTire();
        myCar.tire2 = new KumhoTire();
        
        // 위 코드와 같은 코드지만 결과값이 다르다 => 다형성
        myCar.run();
    }
}
