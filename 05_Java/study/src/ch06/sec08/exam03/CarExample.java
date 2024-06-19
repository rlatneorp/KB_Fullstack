package ch06.sec08.exam03;

public class CarExample {
    public static void main(String[] args) {
        // Car 객체 생성
        Car myCar = new Car();

        // 리턴값이 없는 setGas() 메서드 호출
//        myCar의 gas를 5로 변경
        myCar.setGas(5);
//      isLeftGas() 메서드를 호춣패서 받은 리턴값이 true일 경우 if 블록 생성
//        전체 가스 값이 5이므로 isLeftGas내에서 ture를 반환
        if(myCar.isLeftGas()){
            System.out.println("출발합니다.");
            // 리턴 값이 없는 run() 메서드 호출
            // gas가 0이 될때까지 gas를 1씩 줄이면서 가스 상태 출력
            myCar.run();
        }
        // 마지막에는 gas가 0인 상태
        System.out.println("gas를 주입하세요.");
    }
}
